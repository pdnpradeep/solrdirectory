package com.solrdirectory.config;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * Created by Pradeep.P on 11-11-2015.
 */
@Configuration
@EnableSolrRepositories("com.solrdirectory.searchrepository")
public class SolrConfig {

    private String SOLR_HTTP_SERVER_URL = "SOLR_HTTP_SERVER_URL";

    @Bean(name = "solrTemplate")
    public SolrTemplate solrTagTemplate() throws Exception {

        if(isEmbeddedServer()){

        }else{
            HttpSolrServer httpSolrServer = new HttpSolrServer(getSolrUrl());
            return new SolrTemplate(httpSolrServer,"solrdirectory");
        }
        return null;
    }

    private String getSolrUrl() {
        System.out.println("SOLR_HTTP_SERVER_URL>>>>"+System.getProperty(SOLR_HTTP_SERVER_URL));
        return System.getProperty(SOLR_HTTP_SERVER_URL);
    }

    private boolean isEmbeddedServer() {
        return false;
    }

}
