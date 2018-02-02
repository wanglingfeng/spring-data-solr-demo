package com.solr.demo.service.impl;

import com.solr.demo.repository.ProductRepository;
import com.solr.demo.repository.domain.Product;
import com.solr.demo.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findByName(String searchTerm, Pageable pageable) {
        if (StringUtils.isBlank(searchTerm)) return productRepository.findAll(pageable);

        return productRepository.findByNameIn(splitSearchTermAndRemoveIgnoredCharacters(searchTerm), pageable);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findOne(id);
    }

    @Override
    public FacetPage<Product> autoCompleteNameFragment(String fragment, Pageable pageable) {
        if (StringUtils.isBlank(fragment)) return new SolrResultPage<>(Collections.emptyList());

        return productRepository.findByNameStartsWith(splitSearchTermAndRemoveIgnoredCharacters(fragment), pageable);
    }

    private Collection<String> splitSearchTermAndRemoveIgnoredCharacters(String searchTerm) {
        String[] searchTerms = StringUtils.split(searchTerm, " ");
        List<String> result = new ArrayList<>(searchTerms.length);

        for (String term : searchTerms) {
            if (StringUtils.isNotEmpty(term)) {
                result.add(Pattern.compile("\\p{Punct}").matcher(term).replaceAll(" "));
            }
        }
        return result;
    }
}
