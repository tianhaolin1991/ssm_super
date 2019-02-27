package cn.itcast.service;

import cn.itcast.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void add(UserInfo user);

    UserInfo findById(String id);

    UserInfo findUserWithOtherRoles(String id);

    void addRoleToUser(String uid, List<String> roleIds);
}

