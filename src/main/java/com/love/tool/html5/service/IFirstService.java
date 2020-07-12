package com.love.tool.html5.service;

import com.love.tool.html5.entity.First;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 不会飞得鹰
 * @Date: 2020/5/12 13:55
 */
public interface IFirstService {
    /**
     * 查询所有first表
     * @return
     */
    List<First> listFirstAll();
    /**
     * 查询姓名
     */
    List <First> findFirstName();

    /**
     * 更新数据
     * @param
     * @param id
     * @return
     */
    String updateFirst(String firstLine, String secondLine, String thirdLine, String titleTime, Integer id);

    /**
     * 添加爱心便签
     * @param firstLine
     * @param secondLine
     * @param thirdLine
     * @param firstName
     * @param titleTime
     * @return
     */
    String insertFirst(String firstLine,String secondLine,String thirdLine,String firstName,String titleTime);

    /**
     * 删除爱心便签
     * @param ids
     * @return
     */
    String deleteFirst(String ids);
}
