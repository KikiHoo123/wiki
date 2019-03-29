package com.bsc.modules.space.dao;
import java.util.List;
import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.modules.space.entity.Smember;

/**
 * @author yangrui
 */
@MybatisDao
public interface SmemberMapper extends CrudDao<Smember>{
    Smember get(int id);

    Smember getT(Smember entity);

    List<Smember> findList(Smember entity);

    List<Smember> findAllList(Smember entity);

    int insert(Smember entity);

    int update(Smember entity);

    int delete(int id);

}
