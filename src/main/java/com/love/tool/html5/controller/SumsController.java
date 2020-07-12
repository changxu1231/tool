package com.love.tool.html5.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.love.tool.html5.entity.Sums;
import com.love.tool.html5.service.ISumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 不会飞得鹰
 * @Date: 2020/5/9 20:04
 */
@Controller
public class SumsController {
    @Autowired
    private ISumsService sumsService;
    @RequestMapping("/homePage")
    public String homePage(Model model, Integer num) {
        //分页
        if (num == null) {
            PageHelper.startPage(0, 10);
        } else {
            PageHelper.startPage(num, 10);
        }
        //查询数据并传入前端页面
        List<Sums> findAll = sumsService.listSumsAll();
        PageInfo pageInfo = new PageInfo<Sums>(findAll);
        model.addAttribute("findAll", findAll);
        model.addAttribute("pageInfo", pageInfo);
        return "tool/homePage";
    }

}
