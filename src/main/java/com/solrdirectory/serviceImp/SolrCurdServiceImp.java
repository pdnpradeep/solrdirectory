package com.solrdirectory.serviceImp;

import com.solrdirectory.searchrepository.SearchRepository;
import com.solrdirectory.service.SolrCurdService;
import com.solrdirectory.utils.JacksonMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.support.SolrRepositoryFactory;
import org.springframework.stereotype.Service;
import com.solrdirectory.searchmodel.DataModel;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pradeep.P on 22-11-2015.
 */
@Service
public class SolrCurdServiceImp implements SolrCurdService {

    @Autowired
    SolrTemplate solrTemplate;

    public SearchRepository searchRepository;

    @PostConstruct
    public void init() {
        searchRepository = new SolrRepositoryFactory(solrTemplate).getRepository(SearchRepository.class);
    }
    @Transactional
    public String saveSolrData(DataModel singledocument) {
        DataModel savedDocument =  searchRepository.save(singledocument);
        if(savedDocument == null){
            return "error";
        }
        return "success";
    }

    public String retriveAllSolrData() {
        List<DataModel> dataModels = new ArrayList<DataModel>();
        for(DataModel temp:searchRepository.findAll()){
            System.out.println("id:"+temp.getPhoneNo());
            dataModels.add(temp);
        }
        return  JacksonMethods.convertObjectTOJSONString(dataModels);
    }

    public String searchSolrRecord(String record) {
        List<DataModel> dataModels = new ArrayList<DataModel>();
        for(DataModel temp:searchRepository.search(record)){
            dataModels.add(temp);
        }
        return JacksonMethods.convertObjectTOJSONString(dataModels);
    }

    public String deleteSolrRecord(DataModel record) {
        return null;
    }

}
