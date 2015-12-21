package com.solrdirectory.utils;

import com.solrdirectory.searchrepository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;

/**
 * Created by Pradeep.P on 22-11-2015.
 */
public class SolrUtils {

    @Autowired
    SolrTemplate solrTemplate;

}
