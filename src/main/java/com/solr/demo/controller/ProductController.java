package com.solr.demo.controller;

import com.solr.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.findById(id));

        return "product";
    }
}
