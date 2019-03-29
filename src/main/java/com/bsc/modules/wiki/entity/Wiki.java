package com.bsc.modules.wiki.entity;

import com.bsc.common.persistence.BaseEntity;
import com.bsc.modules.dict.entity.Dict;
import com.bsc.modules.space.entity.Space;
import com.bsc.modules.user.entity.User;

public class Wiki extends BaseEntity{
    private Wiki wiki;
    private Space space;
    private User creator;
    private String time;
    private User modifier;
    private String lasttime;
    private String title;
    private String content;
    private String type;

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getCreator() {
        return creator;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public void setWiki(Wiki wiki) {
        this.wiki = wiki;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Space getSpace() {
        return space;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getModifier() {
        return modifier;
    }

    public void setModifier(User modifier) {
        this.modifier = modifier;
    }
}
