package com.test;

import com.test.entity.Customer;
import com.test.entity.Student;
import com.test.repository.CustomerRepository;
import com.test.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test06 {
    public static void main(String[] args) {
        // 加载 MyBatis 配置文件
        InputStream resourceAsStream = Test01.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        // 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取接口的代理对象
        StudentRepository repository = sqlSession.getMapper(StudentRepository.class);

        Student byId = repository.findById(1);
        System.out.println(byId.getName());

        System.out.println("==================================系统休眠 2 秒...一会儿再来获取你的班级===========================");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(byId.getClazz());

        sqlSession.close();
    }
}
