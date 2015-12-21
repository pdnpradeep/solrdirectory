package com.solrdirectory.controllers;

import com.solrdirectory.service.SolrCurdService;
import com.solrdirectory.utils.JacksonMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.solrdirectory.searchmodel.DataModel;

import java.util.Map;

/**
 * Created by Pradeep.P on 15-10-2015.
 */
@Controller
public class index {

    @Autowired
    SolrCurdService solrCurdService;

    @RequestMapping("solr")
    public String index(){
        System.out.println("checking index controller exection");
        return "firstpage";
    }

    @RequestMapping(value = "savedatatosolr")
    @ResponseBody
    public String saveDataToSolr(@RequestBody String newRecord){
        System.out.println("newRecordString"+newRecord);
        DataModel dataModel = (DataModel) JacksonMethods.convertJSONStringToObject(newRecord, DataModel.class);
        String returnvalue = solrCurdService.saveSolrData(dataModel);
        System.out.println("newRecord"+ dataModel);
       // System.out.println("newRecord"+ dataModel.getPhoneNo());
        //String savedOrNot = solrCurdService.saveSolrData(newRecord);
        return "{\"sucess\":"+ returnvalue +"}";
    }

    @RequestMapping(value = "allsolrdata")
    @ResponseBody
    public String allSolrData(){
        String data = solrCurdService.retriveAllSolrData();
        return data;
    }

    @RequestMapping(value = "solrsearch")
    @ResponseBody
    public String solrSearch(@RequestParam("term") String term){
        return solrCurdService.searchSolrRecord(term);
    }
}
