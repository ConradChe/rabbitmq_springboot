package com.cgq.learn.rabbitmq_springboot.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
// 持久化 非独占 非自动删除
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloCustomer {

    @RabbitHandler
    public void receive(String message){
        System.out.println("message = "+message);
    }
}
