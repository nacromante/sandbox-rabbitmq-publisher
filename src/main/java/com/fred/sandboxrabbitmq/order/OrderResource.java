package com.fred.sandboxrabbitmq.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class OrderResource {
    
    @Autowired
    private OrderQueueSender sender;

    @PostMapping("/send")
    public void send( @RequestBody Order order){
        sender.send(order.getName());
    }   
}