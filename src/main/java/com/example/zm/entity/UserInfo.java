package com.example.zm.entity;

import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @author:zm
 * @since 2020/10/23 9:42
 */
@Data
public class UserInfo {
    private String id;
    private String username;
    private String age;
    private String gender;
    private String birthday;
    private String phone;
    //private String test;
}
