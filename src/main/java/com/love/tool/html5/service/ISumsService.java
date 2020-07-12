package com.love.tool.html5.service;

import com.love.tool.html5.entity.Sums;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 不会飞得鹰
 * @Date: 2020/5/9 23:15
 */
public interface ISumsService {
    /**
     * 查询所有sums表的信息
     * @return
     */
    List<Sums> listSumsAll();
}
