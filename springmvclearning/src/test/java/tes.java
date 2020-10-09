import controller.UsersController;
import entity.Users;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class tes {

    public static void main(String args[]){

        //加载MyBatis的配置文件
        InputStream inputStream = UsersController.class.getClassLoader().getResourceAsStream("mybatis/mybatisconfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder() ;
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.自定义接口
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Users> list = userMapper.findUsers();
        for (Users user:list) {
            System.out.println(user.getId()+"\t"+user.getName()+"\t"+user.getPassword()+"\t"+user.getMoney());
        }
        sqlSession.close();
    }
}
