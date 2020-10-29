package com.example.zm.excel;

import com.example.zm.entity.UserInfo;
import com.example.zm.mapper.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:zm
 * @since 2020/10/26 11:24
 */
@Service
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void getTest() {
        UserInfo userInfo = userInfoMapper.selectById("7aca0ac5-fc19-4de9-87f6-0d196a4f46e6");
        System.out.println(userInfo);
    }
}
