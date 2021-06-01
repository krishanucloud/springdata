package com.springdata.springdata.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuideModel {

    private long id;
    private String name;
    private List<StudentModel> students;
}
