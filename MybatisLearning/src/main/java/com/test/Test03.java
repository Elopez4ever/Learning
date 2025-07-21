package com.test;

import com.test.entity.Student;
import com.test.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test03 {
    public static void main(String[] args) {
        // 加载 MyBatis 配置文件
        InputStream resourceAsStream = Test01.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        // 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取接口的代理对象
        StudentRepository repository = sqlSession.getMapper(StudentRepository.class);

        Student student1 = repository.getById(1);
        System.out.println(student1);


        sqlSession.close();
    }
}
