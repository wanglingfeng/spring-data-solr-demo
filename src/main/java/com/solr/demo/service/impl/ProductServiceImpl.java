package com.solr.demo.service.impl;

import com.solr.demo.controller.domain.ProductDTO;
import com.solr.demo.repository.ProductRepository;
import com.solr.demo.repository.domain.Product;
import com.solr.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> dtoList = new ArrayList<>();
        Iterable<Product> iterable = productRepository.findAll();

        iterable.forEach(p -> {
            ProductDTO dto = convertModelToDTO(p);
            dtoList.add(dto);
        });

        return dtoList;
    }

    @Override
    public ProductDTO findById(String id) {
        Product product = productRepository.findOne(id);

        return convertModelToDTO(product);
    }

    @Override
    public void create(ProductDTO dto) {
        Product product = convertDTOToModel(dto);

        if (null == product) return;

        productRepository.save(product);
    }

    @Override
    public void remove(String id) {
        productRepository.delete(id);
    }

    private ProductDTO convertModelToDTO(Product product) {
        if (null == product) return null;

        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setAvailable(product.isAvailable());
        dto.setFeatures(product.getFeatures());
        dto.setPrice(product.getPrice());
        dto.setCategories(product.getCategories());
        dto.setPopularity(product.getPopularity());

        return dto;
    }

    private Product convertDTOToModel(ProductDTO dto) {
        if (null == dto) return null;

        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setAvailable(dto.isAvailable());
        product.setFeatures(dto.getFeatures());
        product.setPrice(dto.getPrice());
        product.setCategories(dto.getCategories());
        product.setPopularity(dto.getPopularity());

        return product;
    }
}
