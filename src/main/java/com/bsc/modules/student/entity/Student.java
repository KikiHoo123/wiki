package com.bsc.modules.student.entity;
import com.bsc.common.persistence.BaseEntity;
import com.bsc.modules.user.entity.User;

public class Student extends BaseEntity{
    private User userID;
    private String grade;
    private String step;

    public User getUserID() {
        return userID;
    }
    public void setUserID(User user) {
        this.userID = user;
    }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getStep() {
        return step;
    }
    public void setStep(String step) { this.step = step; }


}
