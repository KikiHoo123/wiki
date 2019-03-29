package com.bsc.modules.space.service;
import com.bsc.modules.space.entity.Space;
import com.bsc.modules.space.service.SpaceService;
import com.bsc.modules.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.bsc.common.persistence.CrudService;
import com.bsc.modules.space.dao.SmemberMapper;
import com.bsc.modules.space.entity.Smember;
/**
 * @author yangrui
 */
@Service
public class SmemberService extends CrudService<SmemberMapper,Smember>{
    @Autowired
    private SmemberMapper smemberMapper;
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private UserService userService;
    @Autowired
    private SmemberService smemberService;
    @Override
    public Smember get(int id) {
        Smember smember = smemberMapper.get(id);//根据id
        smember.setSpaceID(spaceService.get(smember.getSpaceID().getId()));
        smember.setMember(userService.get(smember.getMember().getId()));
        return smember;
        /*return super.get(id);*/
    }
    /*
     * 根据外键space获取list
     * */
    public List<Smember> findListForgein(Space space, Smember smember){
        int j=0;
        List<Smember> smemberList=smemberMapper.findList(smember);
        for (int i=0;i<smemberList.size();i++){
            if (smemberList.get(i).getSpaceID().getId()==space.getId()){
                smemberList.set(j,smemberService.get(smemberList.get(i).getId()));
                j++;
            }
        }
        for (;j<smemberList.size();j++){
            smemberList.set(j,null);
        }
        return smemberList;
    }

    @Override
    public Smember getT(Smember entity) {
        return super.getT(entity);
    }

    @Override
    public List<Smember> findList(Smember entity) {
        List<Smember> smemberList = smemberMapper.findList(entity);//获得符合条件的数据
        for(int i = 0; i < smemberList.size(); i ++){
            smemberList.set(i, get(smemberList.get(i).getId()));//得到获得数据的id，
        }
        return smemberList;
        /*return super.findList(entity);*/
    }

    @Override
    public int insert(Smember entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Smember entity) {
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

