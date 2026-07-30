package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RestaurantTable;
import com.example.demo.exception.RestaurantTableServiceException;
import com.example.demo.repositary.TableRepository;
import com.example.demo.service.RestaurantTableService;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService{

	
	
	 @Autowired
	    private TableRepository repository;

	    @Override
	    public RestaurantTable saveTable(RestaurantTable table) {
	        return repository.save(table);
	    }

	    @Override
	    public List<RestaurantTable> getAllTables() {
	        return repository.findAll();
	    }

	    @Override
	    public RestaurantTable getTableById(Integer id) {
	        return repository.findById(id).orElseThrow(() -> new RestaurantTableServiceException("Table not found",HttpStatus.NOT_FOUND));

	    }

	    @Override
	    public RestaurantTable updateTable(Integer id, RestaurantTable table) {

	        RestaurantTable existingTable = repository.findById(id)
	                .orElseThrow(() -> new RestaurantTableServiceException("Table not found",HttpStatus.NOT_FOUND));

	        existingTable.setTableNo(table.getTableNo());
	        existingTable.setQrCodes(table.getQrCodes());
	        existingTable.setTabletStatus(table.getTabletStatus());

	        return repository.save(existingTable);
	    }

	    @Override
	    public void deleteTable(Integer id) {

	        RestaurantTable existingTable = repository.findById(id)
	                .orElseThrow(() -> new RestaurantTableServiceException("Table not found",HttpStatus.NOT_FOUND));

	        repository.delete(existingTable);
	    }
}
