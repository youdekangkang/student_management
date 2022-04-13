package com.xzx.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    public final static String ROLE_STUDENT="Student";
    public final static String ROLE_TEACHER="Teacher";
    public final static String ROLE_MANAGER="Manager";

    private int id;
    private String username;
    private String password;
    private String role;
}
