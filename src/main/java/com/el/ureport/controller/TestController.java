package com.el.ureport.controller;

import com.alibaba.fastjson.JSONObject;
import com.el.ureport.util.Result;
import com.el.ureport.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping(value = "/test", produces = "application/json;charset=utf-8")
public class TestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("student/query")
    public Result query() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from student");
        System.out.println(JSONObject.toJSONString(maps));
        if (maps == null || maps.size() < 1) {
            return ResultGenerator.genSuccessResult("未抓取到数据");
        }
        return ResultGenerator.genSuccessResult(JSONObject.parseArray(JSONObject.toJSONString(maps)));
    }

    @RequestMapping("print")
    public Result print() {
        return ResultGenerator.genSuccessResult("接口调用成功");
    }
}
