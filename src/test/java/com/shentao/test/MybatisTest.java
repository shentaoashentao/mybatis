package com.shentao.test;

import com.shentao.mapper.BrandMapper;
import com.shentao.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void  testSelectAll() throws IOException {

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取UserMapper接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        //执行方法
        List<Brand> brands = brandMapper.selectAll();

        for (Brand brand : brands) {
            System.out.println(brand);
        }

        sqlSession.close();
    }

    @Test
    public void  testSelectById() throws IOException {

        int id=1;

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取UserMapper接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        //执行方法
        List<Brand> brands = brandMapper.selectById(id);

        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void  testselectByCondition() throws IOException {

        int status=1;
        String companyName = "华为";
        String brandName="华为";


        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        Map map = new HashMap<>();
        //map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);//注释掉因为在试动态sql


        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取UserMapper接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        //执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,brandName,companyName);
        List<Brand> brands = brandMapper.selectByCondition(map);


        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void  testselectByConditionSinglingle() throws IOException {

        int status=1;
        String companyName = "华为";
        String brandName="华为";


        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        //封装对象
        Brand brand = new Brand();
        //brand.setStatus(status);
       // brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

    /*    Map map = new HashMap<>();
        //map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);//注释掉因为在试动态sql*/


        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取UserMapper接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        //执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,brandName,companyName);
        List<Brand> brands = brandMapper.selectByConditionSinglingle(brand);


        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void  testadd() throws IOException {

        int status=1;
        String companyName = "莫恩康";
        String brandName="莫恩康";
        String description = "我是莫恩康";
        int ordered = 10;

/*        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";*/

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

    /*    Map map = new HashMap<>();
        //map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);//注释掉因为在试动态sql*/


        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取UserMapper接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        //执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,brandName,companyName);
        brandMapper.add(brand);

        //由于自动回滚 需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void  testdeleteById() throws IOException {

        int id = 3;

/*        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";*/

  /*      //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);*/

    /*    Map map = new HashMap<>();
        //map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);//注释掉因为在试动态sql*/


        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取UserMapper接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        //执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,brandName,companyName);
        brandMapper.deleteById(id);

        //由于自动回滚 需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void  testdeleteByIds() throws IOException {

        int[] ids = {6,7};

/*        //处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";*/

  /*      //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);*/

    /*    Map map = new HashMap<>();
        //map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);//注释掉因为在试动态sql*/


        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取UserMapper接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        //执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,brandName,companyName);
        brandMapper.deleteByIds(ids);

        //由于自动回滚 需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
