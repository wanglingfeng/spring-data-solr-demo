package com.solr.demo.controller;

import com.solr.demo.controller.domain.ProductDTO;
import com.solr.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductDTO findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(ProductDTO dto) {
        productService.create(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable String id) {
        productService.remove(id);
    }
}
