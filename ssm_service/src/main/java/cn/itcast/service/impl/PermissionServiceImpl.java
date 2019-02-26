package cn.itcast.service.impl;

import cn.itcast.dao.PermissionDao;
import cn.itcast.domain.Permission;
import cn.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
       return permissionDao.findAll();
    }

    @Override
    public void add(Permission permission) {
        permissionDao.save(permission);
    }
}
