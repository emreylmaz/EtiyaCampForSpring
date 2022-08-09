package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailManager implements OrderDetailService{

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ModelMapperService modelMapperService;



    @Override
    public List<OrderDetailListResponse> getAll() {
        List<OrderDetail> result=orderDetailRepository.findAll();
        List<OrderDetailListResponse> response= result.stream()
                .map(item -> this.modelMapperService.forResponse()
                        .map(item,OrderDetailListResponse.class) )
                .collect(Collectors.toList());

        return response;
    }

}
