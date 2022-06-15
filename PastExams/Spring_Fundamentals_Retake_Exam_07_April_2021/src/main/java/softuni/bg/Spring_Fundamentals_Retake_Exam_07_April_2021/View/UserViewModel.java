package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.View;

public class UserViewModel {
    private String username;

    private int countOfOrders;

    public UserViewModel() {
    }

    public UserViewModel(String username, int countOfOrders) {
        this.username = username;
        this.countOfOrders = countOfOrders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCountOfOrders() {
        return countOfOrders;
    }

    public void setCountOfOrders(int countOfOrders) {
        this.countOfOrders = countOfOrders;
    }
}
