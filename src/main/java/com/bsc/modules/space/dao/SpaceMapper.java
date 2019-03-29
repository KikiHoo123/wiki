package com.bsc.modules.space.dao;

import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.modules.space.entity.Space;
import java.util.List;

@MybatisDao
public interface SpaceMapper extends CrudDao<Space> {
    Space get(int id);

    Space getT(Space entity);

    List<Space> findList(Space entity);

    List<Space> findAllList(Space entity);

    int insert(Space entity);

    int update(Space entity);

    int delete(int id);

    List<Space> getQueryList(Space entity);
}
