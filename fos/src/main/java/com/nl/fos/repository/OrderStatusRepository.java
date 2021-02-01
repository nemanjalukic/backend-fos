package com.nl.fos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nl.fos.model.OStatus;
import com.nl.fos.model.Order;
import com.nl.fos.model.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

	Optional<OrderStatus> findByStatus(OStatus os);

}
