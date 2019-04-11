package com.bsc.modules.team.entity;

import com.bsc.common.persistence.BaseEntity;
import com.bsc.modules.user.entity.User;

import java.util.List;

public class Team extends BaseEntity{
    private User creator;
    private String time;
    private String title;
    private String intro;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntro() {
        return intro;
    }
}
