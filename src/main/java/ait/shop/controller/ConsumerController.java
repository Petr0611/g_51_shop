package ait.shop.controller;


import ait.shop.model.entity.Consumer;
import ait.shop.service.interfaces.ConsumerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    public final ConsumerService service;

    public ConsumerController(ConsumerService service) {
        this.service = service;
    }

    @PostMapping
    public Consumer saveConsumer(@RequestBody Consumer consumer) {
        return service.saveConsumer(consumer);
    }

    @GetMapping
    public List<Consumer> getAll() {
        return service.getAllActiveConsumers();
    }

    @GetMapping("/{id}")
    public Consumer getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Consumer update(@PathVariable Long id, @RequestBody Consumer consumer) {
        return service.update(id, consumer);
    }

    @DeleteMapping("/{consumerId}")
    public Consumer removeById(@PathVariable("consumerId") Long id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/{consumerName}")
    public Consumer removeByName(@PathVariable("consumerName") String name) {
        return service.deleteByName(name);
    }

    @PutMapping("/restore/{id}")
    public Consumer restoreConsumer(@PathVariable Long id) {
        return service.restoreConsumerById(id);

    }

    @GetMapping("/consumers/active/count")
    public Long getActiveConsumerCount() {
        return service.getConsumerCount();
    }


}
