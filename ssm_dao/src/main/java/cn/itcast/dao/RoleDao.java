package cn.itcast.dao;

import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public interface RoleDao {

    @Select("SELECT r.* " +
            "FROM role r JOIN users_role ur ON ur.roleId = r.id " +
            "WHERE ur.userId = #{userId}")
    List<Role> findByUserId(String userId);
}
