package com.indiumsoft.ordermicroservice.service;

import com.indiumsoft.ordermicroservice.common.Payment;
import com.indiumsoft.ordermicroservice.common.TransactionRequest;
import com.indiumsoft.ordermicroservice.common.TransactionResponse;
import com.indiumsoft.ordermicroservice.entity.Order;
import com.indiumsoft.ordermicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest) {

        String responseMessage = "";
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getOrderId());
        payment.setAmount(order.getPrice()* order.getQty());



        // rest call

       Payment paymentResponse =  restTemplate.postForObject("http://PAYMENT-SERVICE/payments/doPayment", payment, Payment.class);

       if(paymentResponse.getPaymentStatus().equals("Success")){
           responseMessage = "payment processed, your order is placed";
       }
       else{
           responseMessage = "error occurred at payment, order moved to cart";
       }

        orderRepository.save(order);

        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), responseMessage);
    }


}
