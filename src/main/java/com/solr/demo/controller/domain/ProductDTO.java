package com.solr.demo.controller.domain;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {

    private String id;
    private String name;
    private boolean available;
    private List<String> features;
    private  float price;
    private List<String> categories;
    private int popularity;
}
