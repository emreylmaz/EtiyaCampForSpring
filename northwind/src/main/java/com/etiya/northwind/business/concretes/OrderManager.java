package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderManager implements OrderService {

    @Autowired
    private OrderRepository orderRepository;




    @Override
    public List<OrderListResponse> getAll() {
        List<Order> result = orderRepository.findAll();
        List<OrderListResponse> response = new ArrayList<>();

        for (Order order : result){
            OrderListResponse orderListResponse = new OrderListResponse();
            orderListResponse.setOrderId(order.getOrderId());
            orderListResponse.setEmployeeId(order.getEmployees().getEmployeeId());
            orderListResponse.setCustomerId(order.getCustomers().getId());
            orderListResponse.setShipName(order.getShipName());

            response.add(orderListResponse);
        }

        return response;
    }
}
