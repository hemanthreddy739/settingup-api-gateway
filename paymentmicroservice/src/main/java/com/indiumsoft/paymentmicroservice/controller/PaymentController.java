package com.indiumsoft.paymentmicroservice.controller;


import com.indiumsoft.paymentmicroservice.entity.Payment;
import com.indiumsoft.paymentmicroservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        return paymentService.doPayment(payment);

    }


    @GetMapping("/{id}")
    public Payment getPaymentDetailsByOrderId(@PathVariable("id") int orderId){

        return paymentService.getPaymentDetailsByOrderId(orderId);


    }


    @GetMapping("/all")
    public List<Payment> getAllPaymentsDetails(){

        return paymentService.getAllPaymentsDetails();


    }


}
