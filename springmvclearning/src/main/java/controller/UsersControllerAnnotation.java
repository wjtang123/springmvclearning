package controller;

import entity.Users;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/*
 * Description:implements the Handler based on the annotation
 * Author：wjtang
 * Date:2020/04/26
 * */
@Controller
public class UsersControllerAnnotation {

    @RequestMapping("/usersList.action")
    public ModelAndView usersList(@RequestParam String username,@RequestParam String password){
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
        if(username.equals("wjtang")&&password.equals("382388")){
            modelAndView.addObject("UserList",list); //It equals to "request.setAttribute()" Model
            modelAndView.setViewName("/WEB-INF/jsp/usersList.jsp");//View
        }else {
            modelAndView.setViewName("index.jsp");//View
        }
        return modelAndView;
    }
}
