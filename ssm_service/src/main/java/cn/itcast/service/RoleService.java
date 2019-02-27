package cn.itcast.service;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void add(Role role);

    Role findRoleWithOtherPermissions(String roleId);

    void addPermission(String rid, List<String> pids);
}
