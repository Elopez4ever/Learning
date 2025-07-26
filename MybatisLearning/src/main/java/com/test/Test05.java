package com.test;

import com.test.entity.Customer;
import com.test.repository.CustomerRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test05 {
    public static void main(String[] args) {
        // 加载 MyBatis 配置文件
        InputStream resourceAsStream = Test01.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        // 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取接口的代理对象
        CustomerRepository repository = sqlSession.getMapper(CustomerRepository.class);

        Customer byId = repository.getById(1);
        System.out.println(byId);

        sqlSession.close();
    }
}
