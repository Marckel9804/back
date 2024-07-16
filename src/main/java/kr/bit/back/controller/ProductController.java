package kr.bit.back.controller;

import kr.bit.back.entity.Product;
import kr.bit.back.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bit")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> findaAll() {
        return ResponseEntity.ok("Hello World");
    }

    @CrossOrigin("*")
    @GetMapping("/products")
    public ResponseEntity<?> findaAllProducts() {
        return new ResponseEntity<>(productService.productAll(), HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/product") // restful 웹 서비스의 엔드포인트
    public ResponseEntity<?> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.productSave(product), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/product/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.productOne(id), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.productDelete(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.productUpdate(id, product), HttpStatus.OK);
    }
}
