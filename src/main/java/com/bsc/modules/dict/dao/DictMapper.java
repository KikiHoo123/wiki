package com.bsc.modules.dict.dao;

import com.bsc.common.annotation.MybatisDao;
import com.bsc.common.persistence.CrudDao;
import com.bsc.modules.dict.entity.Dict;
import java.util.List;

    @MybatisDao
    public interface  DictMapper extends CrudDao<Dict> {

        Dict get(int id);

        Dict getT(Dict entity);

        List<Dict> findList(Dict entity);

        List<Dict> findAllList(Dict entity);

        int insert(Dict entity);

        int update(Dict entity);

        int delete(int id);
    }
