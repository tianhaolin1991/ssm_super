package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServcieImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return  roleDao.findAll();
    }

    @Override
    public void add(Role role) {
         roleDao.add(role);
    }
}
