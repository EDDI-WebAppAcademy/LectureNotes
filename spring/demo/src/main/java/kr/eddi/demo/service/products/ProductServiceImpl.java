package kr.eddi.demo.service.products;

import kr.eddi.demo.controller.jpa.board.request.BoardRequest;
import kr.eddi.demo.controller.product.request.ProductRequest;
import kr.eddi.demo.entity.jpa.boards.Board;
import kr.eddi.demo.entity.products.Product;
import kr.eddi.demo.repository.products.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public void register(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setProductDescription(productRequest.getProductDescription());
        product.setPrice(productRequest.getPrice());
        product.setSeller(productRequest.getSeller());

        repository.save(product);
    }

    @Override
    public List<Product> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "productNo"));
    }

    @Override
    public Product read(Long productNo) {
        Optional<Product> maybeProduct = repository.findById(productNo);

        if (maybeProduct.equals(Optional.empty())) {
            log.info("Can't read product info!!!");
            return null;
        }

        return maybeProduct.get();
    }

    @Override
    public void modify(Product product) {
        repository.save(product);
    }

    @Override
    public void remove(Long productNo) {
        repository.deleteById(productNo);
    }
}
