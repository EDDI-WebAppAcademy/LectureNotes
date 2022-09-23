package kr.eddi.demo.repository.products;

import kr.eddi.demo.entity.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
