package kr.eddi.demo.controller.product;

import kr.eddi.demo.controller.product.request.ProductRequest;
import kr.eddi.demo.entity.products.Product;
import kr.eddi.demo.service.products.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("43th/product")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> productList () {
        log.info("productList()");

        return productService.list();
    }

    @PostMapping("/register")
    public void productRegister (@RequestBody ProductRequest productRequest) {
        log.info("productRegister()");

        productService.register(productRequest);
    }

    @GetMapping("/{productNo}")
    public Product ProductRead (@PathVariable("productNo") Long productNo) {
        log.info("ProductRead()");

        return productService.read(productNo);
    }

    @DeleteMapping("/{productNo}")
    public void productRemove (@PathVariable("productNo") Long productNo) {
        log.info("productRemove()");

        productService.remove(productNo);
    }

    @PutMapping("/{productNo}")
    public Product productModify (@PathVariable("productNo") Long productNo, @RequestBody Product product) {
        log.info("productModify()");

        product.setProductNo(productNo);
        productService.modify(product);

        return product;
    }
}
