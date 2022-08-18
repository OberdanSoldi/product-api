package com.github.oberdansoldi.productapi.repository;

import com.github.oberdansoldi.productapi.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
