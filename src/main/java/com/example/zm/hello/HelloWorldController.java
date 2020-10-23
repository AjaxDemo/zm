package com.example.zm.hello;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.zm.easy.DemoDataListener;
import com.example.zm.entity.UserInfo;
import com.example.zm.entity.UserInfoDTO;
import com.example.zm.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author:zm
 * @since 2020/10/22 19:13
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/world")
    public String world() {
        return "HelloWorld";
    }

    @RequestMapping("/easyImport")
    public String easyImport(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();

        EasyExcel.read(inputStream, UserInfoDTO.class,new DemoDataListener(userInfoMapper)).sheet().doRead();
        //获取数据
        return "index";
    }
}
