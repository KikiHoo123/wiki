package com.bsc.modules.team.dao;

import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.modules.team.entity.Tmember;

import java.util.List;

@MybatisDao
public interface TmemberMapper extends CrudDao<Tmember>{
    Tmember get(int id);

    Tmember getT(Tmember entity);

    List<Tmember> findList(Tmember entity);

    List<Tmember> findAllList(Tmember entity);

    int insert(Tmember entity);

    int update(Tmember entity);

    int delete(int id);
}
