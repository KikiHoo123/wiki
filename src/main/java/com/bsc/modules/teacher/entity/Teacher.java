package com.bsc.modules.teacher.entity;
import com.bsc.common.persistence.BaseEntity;
import com.bsc.modules.user.entity.User;

public class Teacher extends BaseEntity{
    private User userID;
    private String lecture;
    private String intro;

    public User getUserID() {
        return userID;
    }
    public void setUserID(User user) {
        this.userID = user;
    }

    public String getLecture() {
        return lecture;
    }
    public void setLecture(String lecture) { this.lecture = lecture; }

    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
}
