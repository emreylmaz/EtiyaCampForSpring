package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderManager implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapperService modelMapperService;




    @Override
    public List<OrderListResponse> getAll() {
        List<Order> result = orderRepository.findAll();
        List<OrderListResponse> response = result.stream()
                .map(item -> this.modelMapperService.forResponse()
                        .map(item,OrderListResponse.class) ).collect(Collectors.toList());



        return response;
    }
}
