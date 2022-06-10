package com.example.restaurants.controller;

import com.example.restaurants.dto.ReceiptDto;
import com.example.restaurants.model.Orders;
import com.example.restaurants.model.Receipt;
import com.example.restaurants.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/request")
    public Receipt postOrder(@RequestBody ReceiptDto receiptDto){
        Receipt orders = orderService.postOrder(receiptDto);
        return orders;
    }

    @GetMapping("/orders")
    public List<Orders> getOrder() throws SQLException {
        List<Orders> orders = orderService.getOrder();
        return orders;
    }


}
