package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import cn.itcast.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByName(username);
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getStatus() == 1?true:false, true, true, true,
                getAuthorities(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void add(UserInfo user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.add(user);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public UserInfo findUserWithOtherRoles(String id) {
        UserInfo user = userDao.findById(id);
        List<Role> roles = userDao.findOtherRoles(id);
        user.setRoles(roles);
        return user;
    }

    @Override
    public void addRoleToUser(String uid, List<String> roleIds) {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(uid,roleId);
        }
    }
}
