package com.test;

import com.test.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

// 使用原生接口
public class Test01 {
    public static void main(String[] args) {
        // 加载 MyBatis 配置文件
        InputStream resourceAsStream = Test01.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        // 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 调用 MyBatis 的原生接口执行 SQL
        String statement = "mapper.UserMapper.get";
        User user = sqlSession.selectOne(statement, 1);
        System.out.println(user);
        sqlSession.close();
    }
}
