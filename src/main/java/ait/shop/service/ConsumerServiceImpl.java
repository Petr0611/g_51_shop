package ait.shop.service;

import ait.shop.model.entity.Consumer;
import ait.shop.service.interfaces.ConsumerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public Consumer saveConsumer(Consumer consumer) {
        return null;
    }

    @Override
    public List<Consumer> getAllActiveConsumers() {
        return null;
    }

    @Override
    public Consumer getById(Long id) {
        return null;
    }

    @Override
    public Consumer update(Long id, Consumer consumer) {
        return null;
    }

    @Override
    public Consumer deleteById(Long id) {
        return null;
    }

    @Override
    public Consumer deleteByName(String name) {
        return null;
    }

    @Override
    public Consumer restoreConsumerById(Long id) {
        return null;
    }

    @Override
    public long getConsumerCount() {
        return 0;
    }
}
