package mapper;

import entity.Cuser;
import entity.User;

import java.util.List;

public interface UserMapper {
    List<Cuser> selectAll();
    void addCanteenManager(Cuser cuser);
    User selectByusername(String username);
}
