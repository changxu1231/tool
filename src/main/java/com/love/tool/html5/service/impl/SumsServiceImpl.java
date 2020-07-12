package com.love.tool.html5.service.impl;

import com.love.tool.html5.mapper.SumsMapper;
import com.love.tool.html5.service.ISumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 不会飞得鹰
 * @Date: 2020/5/9 23:16
 */
@Service
public class SumsServiceImpl implements ISumsService {
    @Autowired
    private SumsMapper sumsMapper;
    @Override
    /**
     * 查询所有sums表的信息
     */
    public List listSumsAll() {
        return sumsMapper.listSumsAll();
    }
}
