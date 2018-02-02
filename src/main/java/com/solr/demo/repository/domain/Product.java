package com.solr.demo.repository.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.geo.Point;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

@SolrDocument(solrCoreName = "product-info")
@Data
public class Product {

    @Id
    @Indexed
    private String id;

    @Indexed("name")
    private String name;

    @Indexed("inStock")
    private boolean available;

    @Indexed
    private List<String> features;

    @Indexed("price")
    private  Float price;

    @Indexed("cat")
    private List<String> categories;

    @Indexed
    private Integer popularity;

    @Indexed("store")
    private Point location;
}
