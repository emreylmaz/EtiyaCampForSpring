package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailManager implements OrderDetailService{

    @Autowired
    private OrderDetailRepository orderDetailRepository;



    @Override
    public List<OrderDetailListResponse> getAll() {
        List<OrderDetail> result=orderDetailRepository.findAll();
        List<OrderDetailListResponse> response= new ArrayList<>();
        for(OrderDetail orderDetail : result)
        {
            OrderDetailListResponse detailListResponse=new OrderDetailListResponse();
            detailListResponse.setOrderId(orderDetail.getOrder().getOrderId());
            detailListResponse.setProductId(orderDetail.getProduct().getProductId());
            detailListResponse.setProductName(orderDetail.getProduct().getProductName());
            response.add(detailListResponse);
        }
        return response;
    }

}
