package com.zosh.trading.repository;

import com.zosh.trading.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository <PaymentOrder, Long> {


}
