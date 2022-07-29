package com.shentao.mapper;

import com.shentao.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    //查询所有
    List<Brand> selectAll();
    //根据id查询
    List<Brand> selectById(int id);
    //根据条件查询(多条件)
    /*
    *    参数接受
    *       1.散装参数 ：如果方法中有多个参数需要使用@Param
    * */

    //List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String ompanyName,@Param("brandName")String brandName);
    List<Brand> selectByCondition(Map map);

    //单条件
    List<Brand> selectByConditionSinglingle (Brand brand);

    //添加
    void add(Brand brand);
    //修改
    int update(Brand brand);
    //删除
    void deleteById(int id);
    //批量删除
    void deleteByIds(@Param("ids") int[] ids);
}
