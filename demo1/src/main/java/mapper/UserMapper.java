package mapper;

import entity.Canteen;
import entity.Comment;
import entity.Cuser;

import java.util.List;

public interface UserMapper {
    //系统管理员对食堂管理员信息增删改查
    List<Cuser> selectAllCanteenManager();
    void addCanteenManager(Cuser cuser);
    Cuser selectCanteenManagerByUsername(String username);
    void updateCanteenManager(Cuser cuser);
    void deleteCanteenManager(String username);
    //系统管理员对食堂信息增删改查
    List<Canteen> selectAllCanteen();
    void addCanteen(Canteen canteen);
    Canteen selectCanteenByCanteenname(String name);
    void updateCanteen(Canteen canteen);
    void deleteCanteen(String name);
    //系统管理员对评价信息删查
    List<Comment> selectAllComment();
    void deleteComment(int id);
    //系统管理员对交流社区信息删查

}
