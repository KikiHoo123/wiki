package com.bsc.modules.wiki.controller;

import com.bsc.common.utils.DictUtils;
import com.bsc.common.utils.Page;
import com.bsc.modules.space.entity.Space;
import com.bsc.modules.space.service.SpaceService;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.wiki.dao.WikiMapper;
import com.bsc.modules.wiki.entity.Wiki;
import com.bsc.modules.wiki.service.WikiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.nio.file.spi.FileSystemProvider;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "wiki")
public class WikiController {
    @Autowired
    private WikiService wikiService;
    @Autowired
    private WikiMapper wikiMapper;
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private HttpSession session;
    @RequestMapping(value = {"", "list"})
    private String list(HttpServletRequest request, Model model, Wiki wiki) {
        int pageNum=1;
        if(request.getParameter("pageNum")==null || "".equals(request.getParameter("page"))){
            pageNum=1;
        }
        else{
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum, 5);
        List<Wiki> wikiList = wikiService.findList(wiki);
        for (int i = 0; i < wikiList.size(); i++) {
            wikiList.get(i).setType(DictUtils.getDictLabel(wiki.getType(), "GENDER"));
        }
        PageInfo<Wiki> wikiPageInfo = new PageInfo<>(wikiList);
        //得到分页中的条目对象
        List<Wiki> pageList = wikiPageInfo.getList();
        //将结果存入model进行传送
        model.addAttribute("pageList",pageList);
        model.addAttribute("wikiList", wikiList);
        return "wiki/list";
    }


    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Wiki wiki = wikiService.get(id);
        wiki.setType(DictUtils.getDictLabel(wiki.getType(), "GENDER"));
        model.addAttribute("wiki", wiki);
        return "wiki/details";
    }

    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败！";
        int successNum = wikiService.delete(id);
        if (successNum > 0)
            msg = "删除成功" + successNum + "条记录";
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/wiki/list";
    }

    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id, Model model, Wiki wiki) {
        if (id != null) {
            wiki = wikiService.get(id);
            wiki.setType(DictUtils.getDictLabel(wiki.getType(), "GENDER"));
        }
        model.addAttribute("wiki", wiki);
        return "wiki/edit";
    }

    @RequestMapping("/add/{id}")
    private String add(Wiki wiki, Model model,@PathVariable Integer id) {
        wiki = new Wiki();
        model.addAttribute("wiki", wiki);
        Space space=spaceService.get(id);
        model.addAttribute("space",space);
        return "wiki/add";
    }

    @RequestMapping(value = {"/{sid}/save", "/save/{id}"})
    private String save(Wiki wiki, RedirectAttributes redirectAttributes,@PathVariable Integer sid) {
        String msg = "保存失败！";
        int successNum = 0;
        Date date=new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        if (wiki.getId() == null) {
            wiki.setTime(timestamp.toString().substring(0,19));
            wiki.setLasttime(wiki.getTime());
            wiki.setCreator((User)session.getAttribute("user"));
            wiki.setModifier(wiki.getCreator());
            Space space=spaceService.get(sid);
            wiki.setSpace(space);
            successNum = wikiService.insert(wiki);
        } else {
            wiki.setModifier((User)session.getAttribute("user"));
            wiki.setLasttime(timestamp.toString().substring(0,19));
            successNum = wikiService.update(wiki);
        }
        if (successNum > 0) {
            msg = "保存成功" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/wiki/list";
    }

    @RequestMapping("/queryList")
    private String query(HttpServletRequest request, HttpSession httpSession, Wiki wiki, Model model) throws UnsupportedEncodingException {
        int pageNum=1;
        if(request.getParameter("pageNum")==null || "".equals(request.getParameter("page"))){
            pageNum=1;
        }
        else{
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        String condition = new String(request.getParameter("condition"));
        httpSession.setAttribute("condition",condition);
        PageHelper.startPage(pageNum, 5);
        wiki.setTitle(condition);
        wiki.setContent(condition);
        List<Wiki> wikiList=wikiService.getQueryList(wiki);
        for (int i = 0; i < wikiList.size(); i++) {
            wikiList.get(i).setType(DictUtils.getDictLabel(wikiList.get(i).getType(), "GENDER"));
        }
        PageInfo<Wiki> wikiPageInfo = new PageInfo<>(wikiList);
        //得到分页中的条目对象
        List<Wiki> pageList = wikiPageInfo.getList();
        //将结果存入model进行传送
        model.addAttribute("pageInfo" , pageList);
        model.addAttribute("wikiList",wikiList);
        return "wiki/list";
    }


    @RequestMapping("/listByPage")
    private String listByPage(HttpServletRequest request, HttpSession httpSession, Wiki wiki, Model model) throws UnsupportedEncodingException {
        int pageNum=1;
        if(request.getParameter("pageNum")==null || "".equals(request.getParameter("page"))){
            pageNum=1;
        }
        else{
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        String condition=(String)httpSession.getAttribute("condition");
        PageHelper.startPage(pageNum, 5);
        wiki.setTitle(condition);
        wiki.setContent(condition);
        List<Wiki> wikiList=wikiService.getQueryList(wiki);
        for (int i = 0; i < wikiList.size(); i++) {
            wikiList.get(i).setType(DictUtils.getDictLabel(wikiList.get(i).getType(), "GENDER"));
        }
        PageInfo<Wiki> wikiPageInfo = new PageInfo<>(wikiList);
        //得到分页中的条目对象
        List<Wiki> pageList = wikiPageInfo.getList();
        //将结果存入model进行传送
        model.addAttribute("pageList",pageList);
        model.addAttribute("wikiList",wikiList);
        return "wiki/listBypage";
    }
}