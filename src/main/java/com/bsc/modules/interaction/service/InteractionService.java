package com.bsc.modules.interaction.service;
import com.bsc.common.utils.DictUtils;
import com.bsc.modules.space.service.SpaceService;
import com.bsc.modules.user.service.UserService;
import com.bsc.modules.wiki.entity.Wiki;
import com.bsc.modules.wiki.service.WikiService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.bsc.common.persistence.CrudService;
import com.bsc.modules.interaction.entity.Interaction;
import com.bsc.modules.interaction.dao.InteractionMapper;

/**
 * @author YangRui
 */
@Service
public class InteractionService extends CrudService<InteractionMapper,Interaction>{
    @Autowired
    private InteractionService interactionService;
    @Autowired
    private InteractionMapper interactionMapper;
    @Autowired
    private WikiService wikiService;
    @Autowired
    private UserService userService;
    @Autowired
    private SpaceService spaceService;
    @Override
    public Interaction get(int id) {
       Interaction interaction = interactionMapper.get(id);//根据id
          if ((interaction.getWikiID())!=null && (interaction.getWikiID().getId())!= null) {
            interaction.setWikiID(wikiService.get(interaction.getWikiID().getId()));
        }
      //  if ((interaction.getUserID())!=null && (interaction.getUserID().getId())!= null) {
            interaction.setUserID(userService.get(interaction.getUserID().getId()));
        //}
        if ((interaction.getSpaceID())!=null && (interaction.getSpaceID().getId())!= null) {
              interaction.setSpaceID(spaceService.get(interaction.getSpaceID().getId()));
        }
       return interaction;
       //return super.get(id);
    }

    @Override
    public Interaction getT(Interaction entity) {
        return super.getT(entity);
    }

    @Override
    public List<Interaction> findList(Interaction entity) {
        List<Interaction> interactionList = interactionMapper.findList(entity);//获得符合条件的数据
        for(int i = 0; i < interactionList.size(); i ++){
         interactionList.set(i, interactionService.get(interactionList.get(i).getId()));//得到获得数据的id，
         //   interactionList.get(i).setType(DictUtils.getDictLabel(interactionList.get(i).getType(),"INTERACT"));
       }
      return interactionList;
     //   return super.findList(entity);
    }

    @Override
    public int insert(Interaction entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Interaction entity) {
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
