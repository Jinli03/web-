package mapper;

import entity.Canteen;
import entity.Cuser;

import java.util.List;

public interface UserMapper {
    List<Cuser> selectAllCanteenManager();
    void addCanteenManager(Cuser cuser);
    Cuser selectCanteenManagerByUsername(String username);
    void updateCanteenManager(Cuser cuser);
    void deleteCanteenManager(String username);
    List<Canteen> selectAllCanteen();
    void addCanteen(Canteen canteen);
    Canteen selectCanteenByCanteenname(String name);
    void updateCanteen(Canteen canteen);
    void deleteCanteen(String name);
}
