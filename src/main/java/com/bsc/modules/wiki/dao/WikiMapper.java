package com.bsc.modules.wiki.dao;

import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.common.utils.Page;
import com.bsc.modules.wiki.entity.Wiki;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@MybatisDao
public interface WikiMapper extends CrudDao<Wiki>{
    Wiki get(int id);

    Wiki getT(Wiki entity);

    List<Wiki> findList(Wiki entity);

    List<Wiki> findAllList(Wiki entity);

    int insert(Wiki entity);

    int update(Wiki entity);

    int delete(int id);

    List<Wiki> getQueryList(Wiki entity);

}
