package com.zosh.trading.service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.zosh.trading.domain.PaymentMethod;
import com.zosh.trading.model.PaymentOrder;
import com.zosh.trading.model.User;
import com.zosh.trading.response.PaymentResponse;

public interface PaymentService {

    PaymentOrder createOrder (User user, Long amount, PaymentMethod paymentMethod);


    PaymentOrder getPaymentOrderById (Long id) throws Exception;

    Boolean proceedPaymentOrder ( PaymentOrder paymentOrder, String paymentId) throws RazorpayException;

    PaymentResponse createRazorPaymentLink (User user, Long Amount, Long orderId) throws RazorpayException;

    PaymentResponse createStripePaymentLink (User user, Long amount, Long orderId) throws StripeException;



}
