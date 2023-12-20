package select;

import dao.ComplaintDao;
import entity.Complaint;

public class ComplaintService {
    private ComplaintDao complaintDao = new ComplaintDao();
    public  void addComplaint(Complaint complaint) {
      complaintDao.addComplaint(complaint);
    }
}
