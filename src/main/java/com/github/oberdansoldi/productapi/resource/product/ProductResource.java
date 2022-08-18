package com.github.oberdansoldi.productapi.resource.product;

import com.github.oberdansoldi.productapi.domain.dto.ProductRequestDto;
import com.github.oberdansoldi.productapi.domain.dto.ProductResponseDto;
import com.github.oberdansoldi.productapi.domain.entity.Product;
import com.github.oberdansoldi.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
public class ProductResource {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductResponseDto>> getById(@PathVariable("id") final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductRequestDto productRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") final Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(!productService.existsById(id));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.update(product));
    }

}
