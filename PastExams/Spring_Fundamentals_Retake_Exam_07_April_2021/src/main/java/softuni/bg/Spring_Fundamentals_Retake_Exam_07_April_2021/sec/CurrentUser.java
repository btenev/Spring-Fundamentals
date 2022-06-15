package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.sec;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private long id;

    private String username;

    public CurrentUser() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void clear() {
        this.id = 0;
        this.username = null;
    }
}
