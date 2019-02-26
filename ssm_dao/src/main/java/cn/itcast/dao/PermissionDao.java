package cn.itcast.dao;

import cn.itcast.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {


    @Select("SELECT * FROM permission WHERE id IN " +
            "(SELECT permissionId FROM ROLE_PERMISSION WHERE roleId = #{roleId})")
    List<Permission> findByRoleId(String roleId);

    @Select("SELECT * FROM permission")
    List<Permission> findAll();

    @Insert("INSERT INTO permission(permissionName,url) VALUES(#{permissionName},#{url})")
    void save(Permission permission);
}
