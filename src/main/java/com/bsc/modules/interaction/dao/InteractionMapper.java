package com.bsc.modules.interaction.dao;
import java.util.List;
import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.modules.interaction.entity.Interaction;
/**
 * @author YangRui
 */
@MybatisDao
public interface InteractionMapper extends CrudDao<Interaction>{
    Interaction get(int id);

    Interaction getT(Interaction entity);

    public List<Interaction> findList(Interaction entity);

    List<Interaction> findAllList(Interaction entity);

    int insert(Interaction entity);

    int update(Interaction entity);

    int delete(int id);
}
