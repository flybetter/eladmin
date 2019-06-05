package me.zhengjie.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class SecondHouseServiceImplTest {

    @Autowired
    private SecondHouseService secondHouseService;

    @Test
    public void queryCountList() {
        Object object = secondHouseService.queryCountList(null, null, null);
        System.out.println(object.toString());
    }
}