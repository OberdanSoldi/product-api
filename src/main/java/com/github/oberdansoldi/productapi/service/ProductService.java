package com.github.oberdansoldi.productapi.service;

import com.github.oberdansoldi.productapi.domain.dto.ProductRequestDto;
import com.github.oberdansoldi.productapi.domain.dto.ProductResponseDto;
import com.github.oberdansoldi.productapi.domain.entity.Product;
import com.github.oberdansoldi.productapi.exceptions.ProductNotFoundException;
import com.github.oberdansoldi.productapi.repository.ProductRepository;
import com.github.oberdansoldi.productapi.service.builder.ProductBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductBuilder productBuilder;

    public ProductResponseDto create(final ProductRequestDto productRequestDto) {
        Product productToCreate = productBuilder.toProduct(productRequestDto);
        Product createdProduct = productRepository.save(productToCreate);
        return productBuilder.toProductResponseDto(createdProduct);
    }

    public Optional<ProductResponseDto> getById(final Long id) {
        final Optional<Product> product = productRepository.findById(id);
        product.orElseThrow(ProductNotFoundException::new);
        return product.map(productBuilder::toProductResponseDto);
    }

    public List<ProductResponseDto> getAll() {
        final List<Product> products = productRepository.findAll();
        return products.stream().map(productBuilder::toProductResponseDto).collect(Collectors.toList());
    }

    public Product update(final Product product) {
        if (product.getId() != null && productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        }
        throw new ProductNotFoundException();
    }

    public void delete(final Long id) {
        productRepository.findById(id).map(product -> {
            productRepository.deleteById(product.getId());
            return Void.TYPE;
        }).orElseThrow(ProductNotFoundException::new);
    }

    public boolean existsById(final Long id) {
        return productRepository.existsById(id);
    }
}
