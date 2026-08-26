package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.RestaurantTableDto;
import com.example.demo.entity.RestaurantTable;
import com.example.demo.exception.RestaurantTableServiceException;
import com.example.demo.mapper.RestaurantTableMapper;
import com.example.demo.repositary.TableRepository;
import com.example.demo.service.RestaurantTableService;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

	private final TableRepository repository;

	public RestaurantTableServiceImpl(TableRepository repository) {
		this.repository = repository;
	}

	@Override
	public RestaurantTableDto saveTable(RestaurantTableDto dto) {

		if (repository.existsById(dto.getTableNo())) {

			throw new RestaurantTableServiceException("Table number already exists", HttpStatus.CONFLICT);

		}

		RestaurantTable table = RestaurantTableMapper.mapToRestaurantTable(dto);

		RestaurantTable savedTable = repository.save(table);

		return RestaurantTableMapper.mapToRestaurantTableDto(savedTable);
	}

	@Override
	public List<RestaurantTableDto> getAllTables() {

		return repository.findAll().stream().map(RestaurantTableMapper::mapToRestaurantTableDto)
				.collect(Collectors.toList());
	}

	@Override
	public RestaurantTableDto getTableById(Integer id) {

		RestaurantTable table = repository.findById(id)
				.orElseThrow(() -> new RestaurantTableServiceException("Table not found", HttpStatus.NOT_FOUND));

		return RestaurantTableMapper.mapToRestaurantTableDto(table);
	}

	@Override
	public RestaurantTableDto updateTable(Integer id, RestaurantTableDto dto) {

		RestaurantTable existingTable = repository.findById(id)
				.orElseThrow(() -> new RestaurantTableServiceException("Table not found", HttpStatus.NOT_FOUND));

		existingTable.setTableNo(dto.getTableNo());
		existingTable.setQrCodes(dto.getQrCodes());
		existingTable.setTabletStatus(dto.getTabletStatus());

		RestaurantTable updatedTable = repository.save(existingTable);

		return RestaurantTableMapper.mapToRestaurantTableDto(updatedTable);
	}

	@Override
	public void deleteTable(Integer id) {

		RestaurantTable existingTable = repository.findById(id)
				.orElseThrow(() -> new RestaurantTableServiceException("Table not found", HttpStatus.NOT_FOUND));

		repository.delete(existingTable);
	}
}