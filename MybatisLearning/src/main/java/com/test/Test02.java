package com.test;

import com.test.entity.User;
import com.test.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        // 加载 MyBatis 配置文件
        InputStream resourceAsStream = Test01.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        // 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取接口的代理对象
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);

        // 新增用户
        User newUser = new User()
                .setUsername("王五")
                .setPassword("123456")
                .setAge(22);
        int insertResult = userRepository.add(newUser);
        sqlSession.commit();
        System.out.println("Insert result: " + insertResult); // 输出受影响的行数

        // 获取新增的用户
        User user = userRepository.get(newUser.getId());
        System.out.println("User retrieved: " + user);

        // 更新用户
        if (user != null) {
            user.setUsername("王五改");
            int updateResult = userRepository.update(user);
            sqlSession.commit();
            System.out.println("Update result: " + updateResult); // 输出受影响的行数
        }

        // 删除用户
        if (user != null) {
            int deleteResult = userRepository.delete(user.getId());
            sqlSession.commit();
            System.out.println("Delete result: " + deleteResult); // 输出受影响的行数
        }

        // 通过 用户名和年龄查询
        User user1 = userRepository.getByNameAge("张三", 21);
        System.out.println(user1);

        // 获取 User 的个数
        System.out.println(userRepository.getCount());


        List<User> all = userRepository.getAll();
        for (User user2 : all) {
            System.out.println(user2);
        }

        // 关闭 SqlSession
        sqlSession.close();
    }
}
