package mapper;

import entity.Users;

import java.util.List;

public interface UserMapper {
    public int insertUser(Users users);
    public List<Users> findUsers();
}
