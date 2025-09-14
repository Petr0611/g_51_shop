package ait.shop.service.interfaces;

import ait.shop.model.dto.ConsumerDTO;
import ait.shop.model.entity.Consumer;

import java.util.List;

public interface ConsumerService {

    ConsumerDTO saveConsumer(ConsumerDTO consumer);

    List<ConsumerDTO> getAllActiveConsumers();

    ConsumerDTO getById(Long id);

    ConsumerDTO update(Long id, ConsumerDTO consumer);

    ConsumerDTO deleteById(Long id);

    ConsumerDTO deleteByName( String name);

    ConsumerDTO restoreConsumerById(Long id);

    long getConsumerCount();



}
