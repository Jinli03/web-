package select;

import dao.ComplaintDao;
import entity.Complaint;
import entity.Dish;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class ComplaintService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    private ComplaintDao complaintDao = new ComplaintDao();

    public void addComplaint(Complaint complaint) {
        complaintDao.addComplaint(complaint);
    }

    public List<Complaint> selectAllComplaints() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Complaint> complaints = mapper.selectAllComplaints();
        sqlSession.close();
        return complaints;
    }


    public void addReply(Complaint complaint) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addReply(complaint);
        sqlSession.commit();
        sqlSession.close();
    }


    public int count() {
        int count = 0;
        try (SqlSession sqlSession = factory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<Complaint> complaints = mapper.selectAllComplaints();
            for (Complaint complaint : complaints) {
                if (complaint.getReplied() == 0) {
                    count++;
                }
            }
        }
        return count;
    }


}
