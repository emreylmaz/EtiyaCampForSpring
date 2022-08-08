package com.etiya.northwind.business.responses.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListResponse {




        private int orderId;


        private String customerId;

        private int employeeId;


        private String shipName;


}
