package org.as.devtechsolution.order.repository;

import org.as.devtechsolution.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<org.as.devtechsolution.order.model.Order, Long> {
}
