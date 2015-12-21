package com.solrdirectory.searchrepository;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import com.solrdirectory.searchmodel.DataModel;

import java.util.List;

/**
 * Created by Pradeep.P on 21-11-2015.
 */
public interface SearchRepository extends SolrCrudRepository<DataModel,Long> {

    @Query("fulltext:*?0*")
    public List<DataModel> search(String searchTerm);
}
