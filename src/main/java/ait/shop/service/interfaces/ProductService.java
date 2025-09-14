package ait.shop.service.interfaces;

import ait.shop.model.dto.ProductDTO;
import ait.shop.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDTO saveProduct(ProductDTO product);

    ProductDTO getById(Long id);

    List<ProductDTO> getAllActiveProducts();

    ProductDTO update(Long id, ProductDTO product);

    ProductDTO deleteById(Long id);

    ProductDTO deleteByTitle(String title);

    ProductDTO restoreProductById(Long id);

    long getProductCount();

    BigDecimal getTotalPrice();

    BigDecimal averagePrice();

}
