package com.bsc.modules.space.service;

import com.bsc.common.persistence.CrudService;
import com.bsc.common.utils.DictUtils;
import com.bsc.modules.space.dao.SmemberMapper;
import com.bsc.modules.space.entity.Smember;
import com.bsc.modules.space.dao.SpaceMapper;
import com.bsc.modules.space.entity.Space;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.user.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class SpaceService  extends CrudService<SpaceMapper,Space> {
    @Autowired
    private SpaceMapper spaceMapper;
    @Autowired
    private SmemberMapper smemberMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private SpaceService spaceService;

    @Override
    public Space get(int id) {
        Space space = spaceMapper.get(id);//根据id
        Smember smember=new Smember();
        smember.setSpaceID(space);
        space.setCreator(userService.get(space.getCreator().getId()));
        return space;
    }


    @Override
    public Space getT(Space entity) {
        return super.getT(entity);
    }

    @Override
    public List<Space> findList(Space entity) {
        //   Space space = spaceMapper.get(id);
		//entity.setType("2");
        List<Space> spaceList = spaceMapper.findList(entity);//获得符合条件的数据
        for(int i = 0; i < spaceList.size(); i ++){
            spaceList.set(i,spaceService.get(spaceList.get(i).getId()));//得到获得数据的id，
        }
        //   space.setType(DictUtils.getDictLabel(space.getType(),"SPACE"));
        return spaceList;
        // return super.findListentity);
    }

    @Override
    public int insert(Space entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Space entity) {
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

    public List<Space> getQueryList(Space space) {
        List<Space> spaceList = spaceMapper.getQueryList(space);
        for (int i = 0; i < spaceList.size(); i++) {
            spaceList.set(i, spaceService.get(spaceList.get(i).getId()));
        }
        // return new PageInfo<Space>(spaceList,2);
        return spaceList;
    }
}
