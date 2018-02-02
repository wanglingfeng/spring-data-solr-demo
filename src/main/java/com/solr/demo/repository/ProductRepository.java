package com.solr.demo.repository;

import com.solr.demo.repository.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.Query.Operator;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.Collection;

public interface ProductRepository extends SolrCrudRepository<Product, String> {

    @Highlight(prefix = "<b>", postfix = "</b>")
    @Query(fields = {"id", "name", "price", "features", "inStock" }, defaultOperator = Operator.AND)
    HighlightPage<Product> findByNameIn(Collection<String> names, Pageable page);

    @Facet(fields = {"name"})
    FacetPage<Product> findByNameStartsWith(Collection<String> nameFragments, Pageable pageable);

}
