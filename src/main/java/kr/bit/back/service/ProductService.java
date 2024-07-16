package kr.bit.back.service;

import kr.bit.back.entity.Product;
import kr.bit.back.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product productSave(Product product) {
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> productAll(){
        return productRepository.findAll();
    }

    @Transactional
    public Product productOne(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("plz id check!!"));
    }

    @Transactional
    public String productDelete(Long id) {
        productRepository.deleteById(id);
        return "ok";
    }

    @Transactional
    public Product productUpdate(Long id, Product product) {

        Product res = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("plz id check!!"));

        res.setProductName(product.getProductName());
        res.setProductCompany(product.getProductCompany());
        productRepository.save(res);

        return res;
    }
}
