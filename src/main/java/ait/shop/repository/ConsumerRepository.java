package ait.shop.repository;

import ait.shop.model.entity.Consumer;
import ait.shop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
}
