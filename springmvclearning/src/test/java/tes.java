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

        //����MyBatis�������ļ�
        InputStream inputStream = UsersController.class.getClassLoader().getResourceAsStream("mybatis/mybatisconfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder() ;
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.�Զ���ӿ�
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Users> list = userMapper.findUsers();
        for (Users user:list) {
            System.out.println(user.getId()+"\t"+user.getName()+"\t"+user.getPassword()+"\t"+user.getMoney());
        }
        sqlSession.close();
    }
}
