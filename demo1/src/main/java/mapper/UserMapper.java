package mapper;

import entity.Canteen;
import entity.Comment;
import entity.Cuser;
import entity.Forum;
import entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //投诉消息处理
    List<Complaint> selectAllComplaints();
    void addReply(Complaint complaint);



    //菜品增删改
    List<Dish> selectAllDishes();
    void addDishes(Dish dish);
    Dish selectDishesByid(String id);
    void updateDishes(Dish dish);
    void deleteDishes(String id);
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
    List<Forum> selectAllForum();
    List<String> selectAllForumTitles();
    void deleteForum(int id);
    //师生对菜品信息的检索
    List<Dish> selectAllDishesByConditions(Dish dish);
    List<Comment> selectDishCommentById(String id);
    void addDishCommentById(Comment comment);
    Dish selectDishById(String dish);
    //师生对食堂信息的检索
    List<Dish> selectDishesByCanteenName(String name);
    //师生活跃等级
    int selectTsTimes(String username);
    void updateTsTimes(@Param("username") String username, @Param("times") int times);
    List<Tsuser> selectAllTsuserAndTimes();
    float queryDishAvarageGradeById(String dish);
    void updateDishAverageGradeById(@Param("id") String id, @Param("grade") int grade);
}
