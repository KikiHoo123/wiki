package com.bsc.modules.team.service;

import com.bsc.common.persistence.CrudService;
import com.bsc.modules.team.dao.TeamMapper;
import com.bsc.modules.team.entity.Team;
import com.bsc.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class TeamService extends CrudService<TeamMapper,Team>{
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;

    @Override
    public Team get(int id) {
        Team team=teamMapper.get(id);//根据id获得team实体
        team.setCreator(userService.get(team.getCreator().getId()));
        return team;
        //return super.get(id);
    }

    @Override
    public Team getT(Team entity) {
        return super.getT(entity);
    }

    @Override
    public List<Team> findList(Team entity) {
        List<Team> teamList=teamMapper.findList(entity);
        for (int i=0;i<teamList.size();i++) {
            teamList.set(i, teamService.get(teamList.get(i).getId()));
        }
        return teamList;
    }


    @Override
    public int insert(Team entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Team entity) {
        return super.update(entity);
    }

    @Override
    public int delete(int id) {
        return super.delete(id);
    }

    @Override
    public int deleteAll(int[] ids) {
        return super.deleteAll(ids);
    }
}
