package com.packt.webstore.service;

import com.packt.webstore.domain.AvailableProductSearchCriteria;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kamil on 2017-09-04.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByAttribute(AvailableProductSearchCriteria attribute, String value) {
        return productRepository.getProductsByAttribute(attribute, value);
    }

    @Override
    public List<Product> getProductsByPriceFilter(Map<String, String> priceFilter) {
        return productRepository.getProductsByPriceRange(priceFilter);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParameters) {
        return  productRepository.getProductsByFilter(filterParameters);
    }
}
