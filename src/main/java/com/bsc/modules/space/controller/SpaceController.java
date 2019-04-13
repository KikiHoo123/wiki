package com.bsc.modules.space.controller;
import com.bsc.common.utils.DictUtils;
import com.bsc.modules.space.dao.SpaceMapper;
import com.bsc.modules.space.entity.Space;
import com.bsc.modules.space.service.SpaceService;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.user.service.UserService;
import com.bsc.modules.wiki.entity.Wiki;
import com.bsc.modules.wiki.service.WikiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author YangRui
 */
@Controller
@RequestMapping("space")
public class SpaceController {
    @Autowired    //创建实体后直接能使用getset
    private SpaceService spaceService;
    @Autowired
    private SpaceMapper spaceMapper;
	@Autowired
    private UserService userService;
	@Autowired
    private WikiService wikiService;
	@Autowired
    private HttpSession session;
    @RequestMapping(value = {"/list", "/", ""})
    private String list(HttpServletRequest request, Model model, Space space) {
        int pageNum=1;
        if(request.getParameter("pageNum")==null || "".equals(request.getParameter("page"))){
            pageNum=1;
        }
        else{
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum, 5);
        space.setType("2");//team space
        List<Space> spaceList=spaceService.findList(space);
        for (int i = 0; i < spaceList.size(); i++) {
            spaceList.get(i).setType(DictUtils.getDictLabel(spaceList.get(i).getType(), "SPACE"));
        }
        PageInfo<Space> spacePageInfo = new PageInfo<>(spaceList);//得到分页中的space条目对象
        List<Space> pageList = spacePageInfo.getList();
        model.addAttribute("pageInfo" , pageList); //将结果存入model进行传送
        model.addAttribute("spaceList",spaceList);
        return "space/list";
    }


    /**
     * 查询
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    private String get(Model model, @PathVariable Integer id) {
        Space space = spaceService.get(id);
        model.addAttribute("space", space);
		Wiki wiki=new Wiki();
        wiki.setSpace(spaceService.get(id));
        List<Wiki> wikiList=wikiService.findList(wiki);
        model.addAttribute("wikiList",wikiList);
        return "space/view";
    }
	
	/**
     *根据当前用户id获取空间
    */
     @RequestMapping("/person/{id}")
     private String person(Model model, @PathVariable Integer id){
         Space space =new Space();
         space.setCreator(userService.get(id));
         space.setType("1");
       //  space.setName(userService.get(id).getName()+"的主页");
         /*if(space.getId()==null){
             Date date=new Date();
             Timestamp timestamp=new Timestamp(date.getTime());
             space.setTime(timestamp.toString().substring(0,19));
             spaceService.insert(space);
         }*/
         space=spaceService.getT(space);
         model.addAttribute("space", space);
         Wiki wiki=new Wiki();
         wiki.setSpace(space);
         List<Wiki> wikiList=wikiService.findList(wiki);
         model.addAttribute("wikiList",wikiList);
         return "space/view";
     }
    /**
     * 删除
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/del/{id}")
    private String del(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String msg = "删除失败";
        int successNum = spaceService.delete(id);
        if(successNum > 0) {
            msg = "成功删除" + successNum + "条记录";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/space/list";
    }
    /**
     * 编辑（添加或修改）
     * @param model
     * @param space
     * @return
     */
    @RequestMapping("/edit/{id}")
    private String edit(@PathVariable Integer id,Model model, Space space) {
        if (id != null) {
            space = spaceService.get(id);
        }
        model.addAttribute("space", space);
        return "space/edit";
    }
    @RequestMapping("/add")
    public String add(Model model, Space space){
        space=new Space();
        model.addAttribute("space",space);
        return "space/edit";
    }
    /**
     * 保存（添加或修改）
     * @param space
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = {"/save","/save/{id}"})
    private String save(Space space,RedirectAttributes redirectAttributes ) {
        String msg = "保存失败";
        int successNum = 0;
        if (space.getId() == null) {
            Date date=new Date();
            Timestamp timestamp=new Timestamp(date.getTime());
            space.setTime(timestamp.toString().substring(0,19));
            space.setType("2");
            space.setCreator((User)session.getAttribute("user"));
            successNum = spaceService.insert(space);
        } else {
            successNum = spaceService.update(space);
        }
        if (successNum > 0) {
            msg = "保存成功";
        }
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/space/list";
    }

    @RequestMapping("/queryList")
    private String query(HttpServletRequest request, HttpSession httpSession, Space space, Model model) throws UnsupportedEncodingException {
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
        space.setName(condition);
        space.setIntro(condition);
        List<Space> spaceList=spaceService.getQueryList(space);
        for (int i = 0; i < spaceList.size(); i++) {
            spaceList.get(i).setType(DictUtils.getDictLabel(spaceList.get(i).getType(), "SPACE"));
        }
        PageInfo<Space> spacePageInfo = new PageInfo<>(spaceList);  //得到分页中的space条目对象
        List<Space> pageList = spacePageInfo.getList(); //将结果存入model进行传送
        model.addAttribute("pageInfo" , pageList);
        model.addAttribute("spaceList",spaceList);
        return "space/list";
    }


    @RequestMapping("/listByPage")
    private String listByPage(HttpServletRequest request, HttpSession httpSession, Space space,Model model) throws UnsupportedEncodingException {
        int pageNum=1;
        if(request.getParameter("pageNum")==null || "".equals(request.getParameter("page"))){
            pageNum=1;
        }
        else{
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        String condition=(String)httpSession.getAttribute("condition");
        PageHelper.startPage(pageNum, 5);
        space.setName(condition);
        space.setIntro(condition);
        List<Space> spaceList=spaceService.getQueryList(space);
        for (int i = 0; i < spaceList.size(); i++) {
            spaceList.get(i).setType(DictUtils.getDictLabel(spaceList.get(i).getType(), "SPACE"));
        }
        PageInfo<Space> spacePageInfo = new PageInfo<>(spaceList);//得到分页中的space条目对象
        List<Space> pageList = spacePageInfo.getList();
        model.addAttribute("pageInfo" , pageList); //将结果存入model进行传送
        model.addAttribute("spaceList",spaceList);
        return "space/listBypage";
    }
}
