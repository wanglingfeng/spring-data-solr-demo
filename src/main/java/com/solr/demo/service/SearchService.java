package com.solr.demo.service;

import com.solr.demo.repository.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;

public interface SearchService {

    Page<Product> findByName(String searchTerm, Pageable pageable);

    FacetPage<Product> autoCompleteNameFragment(String fragment, Pageable pageable);
}
