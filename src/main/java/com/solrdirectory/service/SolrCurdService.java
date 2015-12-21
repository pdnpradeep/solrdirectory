package com.solrdirectory.service;

import com.solrdirectory.searchmodel.DataModel;

import java.util.List;

/**
 * Created by Pradeep.P on 22-11-2015.
 */
public interface SolrCurdService {

    String saveSolrData(DataModel singledocument);
    String retriveAllSolrData();
    String searchSolrRecord(String record);
    String deleteSolrRecord(DataModel record);
}
