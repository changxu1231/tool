package com.love.tool.html5.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.love.tool.html5.entity.First;
import com.love.tool.html5.service.IFirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 不会飞得鹰
 * @Date: 2020/5/12 13:54
 */
@Controller
public class FirstController {
    @Autowired
    private IFirstService firstService;
    /**
     * 引导页书签查询＋分页
     *
     * @param model
     * @param num
     * @return
     */
    @RequestMapping("/")
    public String first(Model model, Integer num) {
        //分页
        if (num == null) {
            PageHelper.startPage(0, 3);
        } else {
            PageHelper.startPage(num, 3);
        }
        //查询数据并传入前端页面
        List<First> findAll = firstService.listFirstAll();
        PageInfo pageInfo = new PageInfo<First>(findAll);
        model.addAttribute("findAll", findAll);
        model.addAttribute("pageInfo", pageInfo);
        return "tool/first";
    }

    /**
     * 页面修改标签
     *
     * @param first
     * @return
     */
    @PostMapping("firstAjax")
    @ResponseBody
    public String firstAjax(First first) {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        first.setTitleTime(now);
        firstService.updateFirst(first.getFirstLine(), first.getSecondLine(), first.getThirdLine(), first.getTitleTime(), first.getId());
        return "SUCCESS";
    }

    /**
     * 添加爱心便签
     */
    @PostMapping("addBian")
    @ResponseBody
    public String addBian(First first) {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        first.setTitleTime(now);
        firstService.insertFirst(first.getFirstLine(), first.getSecondLine(), first.getThirdLine(), first.getFirstName(), first.getTitleTime());
        return "SUCCESS";
    }

    @PostMapping("deleteFirst")
    @ResponseBody
    public String deleteFirst(String ids) {
        System.err.println(ids);
        if (ids != null && ids.length() != 0) {
            String[] list = ids.split(",");
            for (int i = 0; i < list.length; i++) {
                firstService.deleteFirst(list[i]);
            }
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }

}
