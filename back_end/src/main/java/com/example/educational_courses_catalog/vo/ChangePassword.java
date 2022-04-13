package com.example.educational_courses_catalog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassword {
    private String username;
    private String oldPassword;
    private String newPassword;
}
