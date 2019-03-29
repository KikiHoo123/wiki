package com.bsc.modules.team.entity;

import com.bsc.common.persistence.BaseEntity;
import com.bsc.modules.team.entity.Team;
import com.bsc.modules.user.entity.User;

public class Tmember extends BaseEntity{
    private Team team;
    private User member;

    public Team getTeam() {
        return team;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
