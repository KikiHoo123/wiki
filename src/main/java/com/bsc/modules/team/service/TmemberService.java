package com.bsc.modules.team.service;

import com.bsc.common.persistence.CrudService;
import com.bsc.modules.team.dao.TmemberMapper;
import com.bsc.modules.team.entity.Team;
import com.bsc.modules.team.entity.Tmember;
import com.bsc.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TmemberService extends CrudService<TmemberMapper,Tmember>{
    @Autowired
    private TmemberMapper tmemberMapper;
    @Autowired
    private TeamService teamService;
    @Autowired
    private UserService userService;
    @Autowired
    private TmemberService tmemberService;
    @Override
    public Tmember get(int id) {
        Tmember tmember=tmemberMapper.get(id);
        tmember.setTeam(teamService.get(tmember.getTeam().getId()));
        tmember.setMember(userService.get(tmember.getMember().getId()));
        return tmember;
        //return super.get(id);
    }

    @Override
    public Tmember getT(Tmember entity) {
        return super.getT(entity);
    }

    /*
    * 根据外键team获取list
    * */
    public List<Tmember> findListForgein(Team team, Tmember tmember){
        int j=0;
        List<Tmember> tmemberList=tmemberMapper.findList(tmember);
        for (int i=0;i<tmemberList.size();i++){
            if (tmemberList.get(i).getTeam().getId()==team.getId()){
                tmemberList.set(j,tmemberService.get(tmemberList.get(i).getId()));
                j++;
            }
        }
        tmemberList=tmemberList.subList(0,j);
        return tmemberList;
    }

    @Override
    public List<Tmember> findList(Tmember entity) {
        List<Tmember> tmemberList=tmemberMapper.findList(entity);
        for (int i=0;i<tmemberList.size();i++){
            tmemberList.set(i, tmemberService.get(tmemberList.get(i).getId()));
        }
        return tmemberList;
        //return super.findList(entity);
    }

    @Override
    public int insert(Tmember entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Tmember entity) {
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
