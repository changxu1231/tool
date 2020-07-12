package com.love.tool.html5.mapper;

import com.love.tool.html5.entity.First;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: 不会飞得鹰
 * @Date: 2020/5/12 13:54
 */
@Mapper
public interface FirstMapper {
    /**
     * 查询所有first表，按时间倒序输出
     *
     * @return
     */
    @Select("<script> select * from first order by titleTime desc</script>")
    List<First> listFirstAll();
    /**
     * 查询姓名
     */
    @Select("<script> select firstName from first  </script>")
    List<First> findFirstName();

    /**
     * 更新first数据
     */
    @Select("<script> UPDATE first SET firstLine=#{firstLine},secondLine=#{secondLine},thirdLine=#{thirdLine},titleTime=#{titleTime} where id = #{id} </script>")
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
    @Select("insert into first(firstLine,secondLine,thirdLine,firstName,titleTime) values(#{firstLine},#{secondLine},#{thirdLine},#{firstName},#{titleTime})")
    String insertFirst(String firstLine,String secondLine,String thirdLine,String firstName,String titleTime);

    /**
     * 删除爱心便签
     * @param ids
     * @return
     */
    @Select("delete from first where id = #{ids} ")
    String deleteFirst(String ids);
}
