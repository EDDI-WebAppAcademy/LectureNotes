package kr.eddi.demo.service.products;

import kr.eddi.demo.controller.product.request.ProductRequest;
import kr.eddi.demo.entity.products.Product;

import java.util.List;

public interface ProductService {
    public void register(ProductRequest productRequest);
    public List<Product> list();
    public Product read(Long productNo);
    public void modify(Product product);
    public void remove(Long productNo);
}
