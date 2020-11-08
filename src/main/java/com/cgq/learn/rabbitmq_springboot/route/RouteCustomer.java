package com.cgq.learn.rabbitmq_springboot.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //临时队列
                    exchange = @Exchange(value = "directs",type = "direct"), //指定交换机
                    key = {"info","error","warn"}
            )
    })
    public void receive1(String message) {
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //临时队列
                    exchange = @Exchange(value = "directs",type = "direct"), //指定交换机
                    key = {"info"}
            )
    })
    public void receive2(String message) {
        System.out.println("message2 = " + message);
    }
}
