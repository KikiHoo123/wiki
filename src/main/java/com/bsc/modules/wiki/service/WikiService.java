package com.bsc.modules.wiki.service;

import com.bsc.common.persistence.CrudService;
import com.bsc.common.utils.Page;
import com.bsc.modules.dict.service.DictService;
import com.bsc.modules.space.service.SpaceService;
import com.bsc.modules.user.service.UserService;
import com.bsc.modules.wiki.dao.WikiMapper;
import com.bsc.modules.wiki.entity.Wiki;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class WikiService extends CrudService<WikiMapper,Wiki>{
    @Autowired
    private WikiMapper wikiMapper;
    @Autowired
    private WikiService wikiService;
    @Autowired
    private UserService userService;
    @Autowired
    private SpaceService spaceService;
    @Override
    public Wiki get(int id) {
        Wiki wiki=wikiMapper.get(id);
        if ((wiki.getWiki())!=null && (wiki.getWiki().getId())!= null) {
            wiki.setWiki(wikiService.get(wiki.getWiki().getId()));
        }
        wiki.setCreator(userService.get(wiki.getCreator().getId()));
        wiki.setModifier(userService.get(wiki.getModifier().getId()));
        wiki.setSpace(spaceService.get(wiki.getSpace().getId()));
        return wiki;
        //return super.get(id);
    }

    @Override
    public Wiki getT(Wiki entity) {
        return super.getT(entity);
    }

    @Override
    public List<Wiki> findList(Wiki wiki) {
        List<Wiki> wikiList=wikiMapper.findList(wiki);//获得符合条件的实体，返回数组
        for (int i=0;i<wikiList.size();i++){
            wikiList.set(i,wikiService.get(wikiList.get(i).getId()));
        }
        return wikiList;
    }

    @Override
    public int insert(Wiki entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Wiki entity) {
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

    public PageInfo<Wiki> getQueryList(Wiki wiki)  {

        List<Wiki> wikiList= wikiMapper.getQueryList(wiki);
        for(int i = 0; i < wikiList.size(); i ++) {
            wikiList.set(i, wikiService.get(wikiList.get(i).getId()));
        }
        return new PageInfo<Wiki>(wikiList,2);
        //return wikiList;
    }
}
