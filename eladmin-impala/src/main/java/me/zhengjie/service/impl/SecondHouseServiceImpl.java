package me.zhengjie.service.impl;


import com.alibaba.fastjson.JSON;
import me.zhengjie.dto.CountDate;
import me.zhengjie.service.HouseService;
import me.zhengjie.service.SecondHouseService;
import org.apache.avro.data.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("SecondHouseService")
public class SecondHouseServiceImpl<T> extends HouseService<T> implements SecondHouseService<T> {

    @Autowired
    @Qualifier("impalaJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public String queryCountList(String startDate, String endDate, String deviceId) {
        String sql = super.getHouseCountSql(startDate, endDate, "secondhouselog", deviceId);
        List<CountDate> objects = (List<CountDate>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<CountDate>(CountDate.class));
        long[][] result = super.getHouseResult(objects);
        return JSON.toJSONString(result);
    }

}
