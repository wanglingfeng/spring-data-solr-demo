package com.solr.demo.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = {"com.solr.demo.repository"}, multicoreSupport = true)
public class SearchContext {

    @Bean
    public SolrClient solrClient(@Value("${solr.host}") String solrHost) {
        return new HttpSolrClient(solrHost);
    }
}
