package select;

import entity.Canteen;
import entity.Comment;
import entity.Cuser;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import util.SqlSessionFactoryUtils;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
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

}

