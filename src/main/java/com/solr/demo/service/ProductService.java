package com.solr.demo.service;

import com.solr.demo.controller.domain.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAll();

    ProductDTO findById(String id);

    void create(ProductDTO product);

    void remove(String id);
}
