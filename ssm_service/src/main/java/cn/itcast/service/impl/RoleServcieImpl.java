package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Permission;
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

    @Override
    public Role findRoleWithOtherPermissions(String roleId) {
        Role role = roleDao.findById(roleId);
        List<Permission> permissions = roleDao.findOtherPermissions(roleId);
        role.setPermissions(permissions);
        return role;
    }

    @Override
    public void addPermission(String rid, List<String> pids) {
        for (String pid : pids) {
            roleDao.addPermissionToRole(pid,rid);
        }
    }
}
