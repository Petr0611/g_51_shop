package ait.shop.controller;


import ait.shop.model.dto.ConsumerDTO;
import ait.shop.model.dto.ProductDTO;
import ait.shop.model.entity.Consumer;
import ait.shop.service.interfaces.ConsumerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    public final ConsumerService service;

    public ConsumerController(ConsumerService service) {
        this.service = service;
    }

    @Operation(summary = "Create consumerDTO", description = "Add new consumerDTO.", tags = { "Consumer" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ConsumerDTO.class)),
                    @Content(mediaType = "application/xml", schema = @Schema(implementation = ConsumerDTO.class)) }) })

    @PostMapping
    public ConsumerDTO saveConsumer(@RequestBody ConsumerDTO consumerDTO) {
        return service.saveConsumer(consumerDTO);
    }

    @GetMapping
    public List<ConsumerDTO> getAll() {
        return service.getAllActiveConsumers();
    }

    @Operation(summary = "Get consumer by id", description = "Get consumer by id", tags = { "Consumer" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ConsumerDTO.class)),
                            @Content(mediaType = "application/xml", schema = @Schema(implementation = ConsumerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ip supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Consumer not found", content = @Content)
    })

    @GetMapping("/{id}")
    public ConsumerDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ConsumerDTO update(@PathVariable Long id, @RequestBody ConsumerDTO consumerDTO) {
        return service.update(id, consumerDTO);
    }

    @DeleteMapping("/{consumerId}")
    public ConsumerDTO removeById(@PathVariable("consumerId") Long id) {
        return service.deleteById(id);
    }

    @DeleteMapping("/{consumerName}")
    public ConsumerDTO removeByName(@PathVariable("consumerName") String name) {
        return service.deleteByName(name);
    }

    @PutMapping("/restore/{id}")
    public ConsumerDTO restoreConsumer(@PathVariable Long id) {
        return service.restoreConsumerById(id);

    }

    @GetMapping("/consumers/active/count")
    public Long getActiveConsumerCount() {
        return service.getConsumerCount();
    }


}
