package com.bsc.modules.team.dao;

import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.modules.team.entity.Team;

import java.util.List;

@MybatisDao
public interface TeamMapper extends CrudDao<Team>{
    Team get(int id);

    Team getT(Team entity);

    List<Team> findList(Team entity);

    List<Team> findAllList(Team entity);

    int insert(Team entity);

    int update(Team entity);

    int delete(int id);
}
