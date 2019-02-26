package cn.itcast.dao;

import cn.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository("userDao")
public interface UserDao {


    @Select("SELECT * FROM users WHERE username=#{username}")
    @Results(id="userMap",value={
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "roles",column = "id", many=@Many(select = "cn.itcast.dao.RoleDao.findByUserId"))
    })
    UserInfo findByName(String username);

    @Select("SELECT * FROM users")
    List<UserInfo> findAll();

    @Insert("INSERT INTO users(email,username,password,phoneNum,status) VALUES(#{email},#{username},#{password},#{phoneNum},#{status})")
    void add(UserInfo user);

    @Select("SELECT * FROM users WHERE id=#{id}")
    @ResultMap("userMap")
    UserInfo findById(String id);
}
