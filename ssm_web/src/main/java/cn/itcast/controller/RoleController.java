package cn.itcast.controller;

import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Role> roles = roleService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList",roles);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "forward:/WEB-INF/pages/role-add.jsp";
    }

    @RequestMapping("/add")
    public String add(Role role){
        roleService.add(role);
        return "redirect:/role/findAll.do";
    }
}
