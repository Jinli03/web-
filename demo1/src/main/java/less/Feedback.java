import java.util.*;

class Feedback {
    private String customerName;
    private String message;

    public Feedback(String customerName, String message) {
        this.customerName = customerName;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Feedback from " + customerName + ": " + message;
    }
}

class FeedbackManager {
    private List<Feedback> feedbackList;

    public FeedbackManager() {
        feedbackList = new ArrayList<>();
    }

    public void addFeedback(String customerName, String message) {
        feedbackList.add(new Feedback(customerName, message));
    }

    public void printAllFeedback() {
        for (Feedback feedback : feedbackList) {
            System.out.println(feedback);
        }
    }

    // 示例用法
    public static void main(String[] args) {
        FeedbackManager feedbackManager = new FeedbackManager();
        feedbackManager.addFeedback("John Doe", "Great food and service!");
        feedbackManager.addFeedback("Jane Smith", "Pizza was a bit cold.");
        feedbackManager.printAllFeedback();
    }
}
