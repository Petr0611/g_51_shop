package ait.shop.service;

import ait.shop.model.dto.ConsumerDTO;
import ait.shop.model.entity.Consumer;
import ait.shop.repository.ConsumerRepository;
import ait.shop.service.interfaces.ConsumerService;
import ait.shop.service.mapping.ConsumerMappingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final ConsumerRepository repository;
    private final ConsumerMappingService mapper;

    public ConsumerServiceImpl(ConsumerRepository repository, ConsumerMappingService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ConsumerDTO saveConsumer(ConsumerDTO consumerDTO) {
        Consumer consumer = mapper.mapDtoToEntity(consumerDTO);
//        consumerDTO.setActive(true);
        return mapper.mapEntityToDto(repository.save(consumer));
    }

    @Override
    public List<ConsumerDTO> getAllActiveConsumers() {
        return repository.findAll().stream()
                .filter(Consumer::isActive)
                .map(mapper::mapEntityToDto)
                .toList();
    }

    @Override
    public ConsumerDTO getById(Long id) {
        Consumer consumer = repository.findById(id).orElse(null);
        if (consumer == null || !consumer.isActive()) return null;
        return mapper.mapEntityToDto(consumer);
    }

    @Override
    public ConsumerDTO update(Long id, ConsumerDTO consumerDTO) {
        return null;
    }

    @Override
    public ConsumerDTO deleteById(Long id) {
        return null;
    }

    @Override
    public ConsumerDTO deleteByName(String name) {
        return null;
    }

    @Override
    public ConsumerDTO restoreConsumerById(Long id) {
        return null;
    }

    @Override
    public long getConsumerCount() {
        return 0;
    }
}
