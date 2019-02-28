package cn.itcast.controller;

import cn.itcast.domain.UserInfo;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfoList = userService.findAll();
        modelAndView.addObject("userInfoList",userInfoList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "forward:/WEB-INF/pages/user-add.jsp";
    }

    @RequestMapping("/add")
    public String add(UserInfo user){
        userService.add(user);
        return "redirect:/user/findAll.do";
    }

    @RequestMapping("/findById")
    public ModelAndView toDetail(String id){
        UserInfo userInfo = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInfo",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("/findUserByIdWithOtherRoles")
    public ModelAndView findUserByIdAndAllRole(String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo user = userService.findUserWithOtherRoles(id);
        modelAndView.addObject("userWithOtherRoles",user);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/addRole")
    public String addRoleToUser(String uid, @RequestParam(name="ids")List<String> roleIds){
        userService.addRoleToUser(uid,roleIds);
        return "redirect:/user/findAll.do";
    }

}
