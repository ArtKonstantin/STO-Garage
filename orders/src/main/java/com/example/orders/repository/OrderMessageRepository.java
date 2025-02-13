package com.example.orders.repository;

import com.example.orders.entity.OrderMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderMessageRepository extends JpaRepository<OrderMessageEntity, String> {
  @Modifying
  @Transactional
  @Query("UPDATE OrderMessageEntity e SET e.sent = TRUE WHERE e.id = :id")
  void markSent(final String id);

  @Modifying
  @Transactional
  @Query("UPDATE OrderMessageEntity e SET e.sentError = TRUE WHERE e.id = :id")
  void markSentError(final String id);
}
