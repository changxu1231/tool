package com.love.tool.html5.mapper;

import com.love.tool.html5.entity.Sums;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 不会飞得鹰
 * @Date: 2020/5/9 23:13
 */
@Mapper
public interface SumsMapper {
    /**
     * 查询所有sums表的数据，其中包含代码段所有的信息
     *
     * @return
     */
    @Select("<script> select * from sums </script>")
    List<Sums> listSumsAll();
}
