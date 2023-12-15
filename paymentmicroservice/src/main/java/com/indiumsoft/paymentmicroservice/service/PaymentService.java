package com.indiumsoft.paymentmicroservice.service;

import com.indiumsoft.paymentmicroservice.entity.Payment;
import com.indiumsoft.paymentmicroservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String paymentProcessing(){
        return new Random().nextBoolean()?"Success":"false";
    }

    public Payment getPaymentDetailsByOrderId(int orderId) {

        return paymentRepository.findByOrderId(orderId);

    }

    public List<Payment> getAllPaymentsDetails() {

        return paymentRepository.findAll();
    }
}
