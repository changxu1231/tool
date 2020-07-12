package com.love.tool.html5.service.impl;

import com.love.tool.html5.entity.First;
import com.love.tool.html5.mapper.FirstMapper;
import com.love.tool.html5.service.IFirstService;
import com.love.tool.html5.service.ISumsService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 不会飞得鹰
 * @Date: 2020/5/12 13:55
 */
@Service
public class FirstServiceImpl implements IFirstService {
    @Autowired
    private FirstMapper firstMapper;

    @Override
    public List listFirstAll() {
        return firstMapper.listFirstAll();
    }

    @Override
    public List findFirstName() {
        return firstMapper.findFirstName();
    }

    @Override
    public String updateFirst(String firstLine, String secondLine, String thirdLine, String titleTime, Integer id) {
        return firstMapper.updateFirst(firstLine, secondLine, thirdLine, titleTime, id);
    }

    @Override
    public String insertFirst(String firstLine, String secondLine, String thirdLine, String firstName, String titleTime) {
        return firstMapper.insertFirst(firstLine, secondLine, thirdLine, firstName, titleTime);
    }

    @Override
    public String deleteFirst(String ids) {
        return firstMapper.deleteFirst(ids);
    }
}
