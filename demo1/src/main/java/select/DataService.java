package select;

import entity.Canteen;
import entity.Comment;
import entity.Cuser;
import entity.Forum;
import entity.*;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import util.SqlSessionFactoryUtils;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    //菜品增删改
    public List<Dish> selectAllDishes() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Dish> canteen = mapper.selectAllDishes();
        sqlSession.close();
        return canteen;
    }
    public void addDishes(Dish dish) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addDishes(dish);
        sqlSession.commit();
        sqlSession.close();
    }
    public Dish selectDishesByUserid(String id) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Dish dish = mapper.selectDishesByid(id);
        sqlSession.close();
        return dish;
    }
    public void updateDishes(Dish dish) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateDishes(dish);
        sqlSession.commit();
        sqlSession.close();
    }
    public void deleteDishes(String id) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteDishes(id);
        sqlSession.commit();
        sqlSession.close();
    }


    //系统管理员对食堂管理员增删改查
    public List<Cuser> selectAllCanteenManager() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Cuser> cuser = mapper.selectAllCanteenManager();
        sqlSession.close();
        return cuser;
    }
    public void addCanteenManager(Cuser cuser) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addCanteenManager(cuser);
        sqlSession.commit();
        sqlSession.close();
    }
    public Cuser selectCanteenManagerByUsername(String username) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Cuser cuser = mapper.selectCanteenManagerByUsername(username);
        sqlSession.close();
        return cuser;
    }
    public void updateCanteenManager(Cuser cuser) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateCanteenManager(cuser);
        sqlSession.commit();
        sqlSession.close();
    }
    public void deleteCanteenManager(String username) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteCanteenManager(username);
        sqlSession.commit();
        sqlSession.close();
    }

    //系统管理员对食堂增删改查
    public List<Canteen> selectAllCanteen() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Canteen> canteen = mapper.selectAllCanteen();
        sqlSession.close();
        return canteen;
    }
    public void addCanteen(Canteen canteen) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addCanteen(canteen);
        sqlSession.commit();
        sqlSession.close();
    }
    public Canteen selectCanteenByName(String name) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Canteen canteen = mapper.selectCanteenByCanteenname(name);
        sqlSession.close();
        return canteen;
    }
    public void updateCanteen(Canteen canteen) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateCanteen(canteen);
        sqlSession.commit();
        sqlSession.close();
    }
    public void deleteCanteen(String username) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteCanteen(username);
        sqlSession.commit();
        sqlSession.close();
    }
    //系统管理员对评价信息删查
    public List<Comment> selectAllComment() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Comment> comment = mapper.selectAllComment();
        sqlSession.close();
        return comment;
    }
    public void deleteComment(int id) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteComment(id);
        sqlSession.commit();
        sqlSession.close();
    }
    //系统管理员对论坛信息删查
    public List<Forum> selectAllForum() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Forum> forum = mapper.selectAllForum();
        sqlSession.close();
        return forum;
    }
    public void deleteForum(int id) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteForum(id);
        sqlSession.commit();
        sqlSession.close();
    }
    public List<String> selectAllForumTitles(){
        List<String> titles = new ArrayList<>();
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        titles = mapper.selectAllForumTitles();
        return titles;
    }
    //师生检索菜品信息
    public List<Dish> selectAllDishesByConditions(Dish dish){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); // Assuming DishMapper is the correct mapper interface
        List<Dish> dishes = mapper.selectAllDishesByConditions(dish);
        sqlSession.close();
        return dishes;
    }
    public List<Comment> selectDishCommentById(String id) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Comment> comment = mapper.selectDishCommentById(id);
        sqlSession.close();
        return comment;
    }
    public void addDishCommentById(Comment comment) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addDishCommentById(comment);
        sqlSession.commit();
        sqlSession.close();
    }
    public Dish selectDishById(String id) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Dish dish = mapper.selectDishById(id);
        sqlSession.close();
        return dish;
    }
    //师生检索食堂信息
    public List<Dish> selectDishesByCanteenName(String  name){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); // Assuming DishMapper is the correct mapper interface
        List<Dish> dishes = mapper.selectDishesByCanteenName(name);
        sqlSession.close();
        return dishes;
    }
}

