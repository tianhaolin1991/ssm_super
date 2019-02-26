package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Permission> permissions = permissionService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissionList",permissions);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "forward:/WEB-INF/pages/permission-add.jsp";
    }

    @RequestMapping("/add")
    public String add(Permission permission) {
        permissionService.add(permission);
        return "redirect:/permission/findAll.do";
    }
}
