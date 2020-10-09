package controller;


import entity.Users;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/*
* Description:implements the Handler or Controller
* Author：wjtang
* Date:2020/04/26
* */
public class UsersController implements Controller {

    /*Get users list*/
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //加载MyBatis的配置文件
        InputStream inputStream = UsersController.class.getClassLoader().getResourceAsStream("mybatis/mybatisconfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder() ;
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.自定义接口
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Users> list = userMapper.findUsers();//get the list of users
        for (Users user:list) {
            System.out.println(user.getId()+"\t"+user.getName()+"\t"+user.getPassword()+"\t"+user.getMoney());
        }
        sqlSession.close();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("UserList",list); //It equals to "request.setAttribute()" Model
        modelAndView.setViewName("/WEB-INF/jsp/usersList.jsp");//View

        return modelAndView;
    }
}
