package com.springdata.springdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentModel {

    private long id;
    private String name;
    private GuideModel guide;
}
