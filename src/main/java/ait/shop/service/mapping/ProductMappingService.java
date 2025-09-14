package ait.shop.service.mapping;

import ait.shop.model.dto.ProductDTO;
import ait.shop.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface ProductMappingService {

@Mapping(target = "id", ignore = true)
@Mapping(target = "active", constant = "true")
    Product mapDtoToEntity(ProductDTO dto);

    ProductDTO mapEntityToDto(Product entity);


// Ручной маппинг
//    public Product mapDtoToEntity(ProductDTO dto) {
//        Product entity = new Product();
//        entity.setTitle(dto.getTitle());
//        entity.setPrice(dto.getPrice());
//
//        return entity;
//    }
//
//    public ProductDTO mapEntityToDto(Product entity) {
//        ProductDTO dto = new ProductDTO();
//        dto.setId(entity.getId());
//        dto.setTitle(entity.getTitle());
//        dto.setPrice(entity.getPrice());
//
//        return dto;
//
//    }

}
