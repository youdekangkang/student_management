package com.xzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course  {

    private int id;
    private String name;
    private Double hours;
    private String description;
    private String syllabus;
    private int teacher;
//    priavte User teacher;
}
