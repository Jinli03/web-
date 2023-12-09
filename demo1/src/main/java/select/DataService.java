package select;

import entity.Cuser;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import util.SqlSessionFactoryUtils;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Cuser> query() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Cuser> cuser = mapper.selectAll();
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

}

