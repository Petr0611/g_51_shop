package ait.shop.service.interfaces;

import ait.shop.model.entity.Consumer;

import java.util.List;

public interface ConsumerService {

    Consumer saveConsumer(Consumer consumer);

    List<Consumer> getAllActiveConsumers();

    Consumer getById(Long id);

    Consumer update(Long id, Consumer consumer);

    Consumer deleteById(Long id);

    Consumer deleteByName( String name);

    Consumer restoreConsumerById(Long id);

    long getConsumerCount();



}
