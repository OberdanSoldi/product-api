package com.github.oberdansoldi.productapi.service.builder;

import com.github.oberdansoldi.productapi.domain.dto.ProductRequestDto;
import com.github.oberdansoldi.productapi.domain.dto.ProductResponseDto;
import com.github.oberdansoldi.productapi.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductBuilder {

    public ProductResponseDto toProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .cod(product.getCod())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public Product toProduct(ProductRequestDto productRequestDto) {
        return Product.builder()
                .cod(productRequestDto.getCod())
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .build();
    }
}
