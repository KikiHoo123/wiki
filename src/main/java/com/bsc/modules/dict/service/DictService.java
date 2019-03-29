package com.bsc.modules.dict.service;
import com.bsc.common.persistence.CrudService;
import com.bsc.modules.dict.dao.DictMapper;
import com.bsc.modules.dict.entity.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DictService extends CrudService< DictMapper, Dict> {
    @Autowired
    private DictMapper dictMapper;
    @Autowired
    private DictService dictService;

    @Override // 重写方法,根据用户id来获取整个字典实体
    public Dict get(int id) {
        Dict dict = dictMapper.get(id);
        return dict;
        //return super.get(id);xz
    }

    @Override
    public Dict getT(Dict entity) {
        return super.getT(entity);
    }

    @Override
    public List<Dict> findList(Dict entity) {
        List<Dict> dictList = dictMapper.findList(entity);
        for(int i = 0; i < dictList.size(); i ++){
            dictList.set(i, dictService.get(dictList.get(i).getId()));
        }
        return dictList;
        //return super.findList(entity);xz
    }

    @Override
    public int insert(Dict entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Dict entity) {
        return super.update(entity);
    }

    @Override
    public int delete(int id) { return super.delete(id); }

    @Override
    public int deleteAll(int[] ids) {
        return super.deleteAll(ids);
    }
}
