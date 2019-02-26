package cn.itcast.dao;

import cn.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {


    @Select("SELECT * FROM users WHERE username=#{username}")
    @Results(id="userMap",value={
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "roles",column = "id", many=@Many(select = "cn.itcast.dao.RoleDao.findByUserId"))
    })
    UserInfo findByName(String username);

}
