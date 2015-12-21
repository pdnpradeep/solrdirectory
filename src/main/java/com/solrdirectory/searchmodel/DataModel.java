package com.solrdirectory.searchmodel;

import lombok.Data;
import lombok.ToString;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by Pradeep.P on 22-10-2015.
 */
@Data
@ToString
public class DataModel implements Serializable {

    private static final long serialVersionUID = 1376230720961449195L;

    @Id
    @Field(value = "phoneno")
    private Long PhoneNo;
    @Field(value = "fname")
    private String firstName;
    @Field(value = "lname")
    private  String lastName;
}
