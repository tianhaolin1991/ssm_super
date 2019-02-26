package cn.itcast.service;

import cn.itcast.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();

    void add(Permission permission);
}
