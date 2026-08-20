package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Dto.OrderItemDto;
import com.example.demo.Dto.OrderResponseDto;
import com.example.demo.Enums.OrderStatus;
import com.example.demo.Enums.PaymentStatus;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.Product;
import com.example.demo.entity.RestaurantTable;
import com.example.demo.exception.OrderServiceException;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.repositary.CustomerRepo;
import com.example.demo.repositary.OrderRepo;
import com.example.demo.repositary.ProductRepo;
import com.example.demo.repositary.TableRepository;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepo orderRepo;
	private CustomerRepo customerRepo;
	private TableRepository restaurantTableRepo;
	private ProductRepo productRepo;

	public OrderServiceImpl(OrderRepo orderRepo, CustomerRepo customerRepo, TableRepository restaurantTableRepo,
			ProductRepo productRepo) {

		this.orderRepo = orderRepo;
		this.customerRepo = customerRepo;
		this.restaurantTableRepo = restaurantTableRepo;
		this.productRepo = productRepo;
	}

	@Override
	public OrderResponseDto addOrder(OrderDto dto) {

		Customer customer = customerRepo.findById(dto.getCustomerId())
				.orElseThrow(() -> new OrderServiceException("Customer not found", HttpStatus.NOT_FOUND));

		RestaurantTable table = restaurantTableRepo.findById(dto.getTableId())
				.orElseThrow(() -> new OrderServiceException("Table not found", HttpStatus.NOT_FOUND));

		Order order = OrderMapper.mapToOrder(dto);

		order.setCustomer(customer);
		order.setRestaurantTable(table);

		order.setCreatedAt(LocalDate.now());
		order.setOrderTime(LocalDateTime.now());

		order.setOrderNumber("ORD-" + System.currentTimeMillis());
		order.setOrderStatus(OrderStatus.PENDING);
		order.setPaymentStatus(PaymentStatus.PENDING);

		Integer totalAmount = 0;
		
		for (OrderItemDto itemDto : dto.getOrderItems()) {
			Product prod = productRepo.findById(itemDto.getProductId())
					.orElseThrow(() -> new OrderServiceException("Product Not Found", HttpStatus.NOT_FOUND));
			if (prod.getAvailable() == false)
				throw new OrderServiceException( prod.getId()+ " Product Not Available", HttpStatus.NOT_FOUND);
			OrderItem ordItm = new OrderItem();

			ordItm.setProduct(prod);
			ordItm.setQuantity(itemDto.getQuantity());
			Integer itemTotal = prod.getPrice() * itemDto.getQuantity();

			ordItm.setPrice(prod.getPrice());
			ordItm.setSubTotal(itemTotal);
			ordItm.setOrder(order);
			order.getOrderItems().add(ordItm);
			totalAmount = totalAmount + itemTotal;
			
		}
		order.setTotalAmount(totalAmount);
order.setEstimatedReadyTime(LocalDateTime.now().plusMinutes(25));
		Order savedOrder = orderRepo.save(order);
		return OrderMapper.mapToOrderResponseDto(savedOrder);

	}

	@Override
	public List<OrderResponseDto> getAllOrders() {

		List<Order> orders = orderRepo.findAll();

		if (orders.isEmpty()) {
			throw new OrderServiceException("Orders not found", HttpStatus.NOT_FOUND);
		}

		return orders.stream().map(OrderMapper::mapToOrderResponseDto).collect(Collectors.toList());
	}

	@Override
	public OrderResponseDto getOrder(int id) {

		Order order = orderRepo.findById(id)
				.orElseThrow(() -> new OrderServiceException("Order not found", HttpStatus.NOT_FOUND));

		return OrderMapper.mapToOrderResponseDto(order);
	}

	@Override
	public OrderResponseDto updateOrder(int id, OrderDto dto) {

		Order order = orderRepo.findById(id)
				.orElseThrow(() -> new OrderServiceException("Order not found", HttpStatus.NOT_FOUND));

		if (order.getPaymentStatus() != PaymentStatus.PENDING || order.getOrderStatus() != OrderStatus.PENDING) {

			throw new OrderServiceException("Order cannot be edited after payment or processing has started",
					HttpStatus.BAD_REQUEST);
		}

		List<OrderItem> newOrderItems = new ArrayList<>();

		Integer totalAmount = 0;

		for (OrderItemDto itemDto : dto.getOrderItems()) {

			Product product = productRepo.findById(itemDto.getProductId())
					.orElseThrow(() -> new OrderServiceException("Product not found: " + itemDto.getProductId(),
							HttpStatus.NOT_FOUND));
			if (product.getAvailable() == false)
				throw new OrderServiceException( product.getId()+ " Product Not Available", HttpStatus.NOT_FOUND);

			OrderItem orderItem = new OrderItem();

			orderItem.setProduct(product);
			orderItem.setQuantity(itemDto.getQuantity());
			orderItem.setPrice(product.getPrice());

			Integer itemTotal = product.getPrice() * itemDto.getQuantity();

			orderItem.setSubTotal(itemTotal);

			orderItem.setOrder(order);

			newOrderItems.add(orderItem);

			totalAmount = totalAmount + itemTotal;
		}

		order.getOrderItems().clear();

		order.getOrderItems().addAll(newOrderItems);

		order.setTotalAmount(totalAmount);

		order.setSpecialInstructions(dto.getSpecialInstructions());

		Order updatedOrder = orderRepo.save(order);

		return OrderMapper.mapToOrderResponseDto(updatedOrder);
	}

	@Override
	public void deleteOrder(int id) {

		Order order = orderRepo.findById(id)
				.orElseThrow(() -> new OrderServiceException("Order not found", HttpStatus.NOT_FOUND));

		if (order.getPaymentStatus() != PaymentStatus.PENDING || order.getOrderStatus() != OrderStatus.PENDING) {

			throw new OrderServiceException("Order cannot be deleted after payment or preparation has started",
					HttpStatus.BAD_REQUEST);
		}

		orderRepo.delete(order);
	}
}