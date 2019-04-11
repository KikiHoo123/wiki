package com.bsc.modules.space.entity;

import com.bsc.common.persistence.BaseEntity;
import com.bsc.modules.user.entity.User;

import java.util.List;

public class Space extends BaseEntity {
    private User creator;
    private String name;
    private String type;
    private String time;
    private String intro;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }



}
