package mapper;

import entity.Cuser;

import java.util.List;

public interface UserMapper {
    List<Cuser> selectAll();
    void addCanteenManager(Cuser cuser);
    Cuser selectCanteenManagerByUsername(String username);
    void updateCanteenManager(Cuser cuser);
    void deleteCanteenManager(String username);
}
