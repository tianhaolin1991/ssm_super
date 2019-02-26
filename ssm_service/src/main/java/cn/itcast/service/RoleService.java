package cn.itcast.service;

import cn.itcast.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void add(Role role);
}
