package com.course.server.service;

import com.course.server.dto.Test;
import com.course.server.dto.TestExample;
import com.course.server.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> list() {
        TestExample testExample = new TestExample();
        testExample.createCriteria().andIdEqualTo("001");
        testExample.setOrderByClause("id desc");
        return testMapper.selectByExample(testExample);
    }

}