package cn.itcast.dao;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository("roleDao")
public interface RoleDao {

    @Select("SELECT r.* " +
            "FROM role r JOIN users_role ur ON ur.roleId = r.id " +
            "WHERE ur.userId = #{userId}")
    @Results(id="roleMap",value={
            @Result(id=true,property="id",column="id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column="id",
            many=@Many(select="cn.itcast.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findByUserId(String userId);

    @Select("SELECT * FROM role")
    @ResultMap("roleMap")
    List<Role> findAll();


    @Insert("INSERT INTO role(roleName,roleDesc) VALUES(#{roleName},#{roleDesc})")
    void add(Role role);

    @Select("SELECT * FROM role WHERE id = #{roleId}")
    Role findById(String roleId);

    @Select("SELECT * FROM permission WHERE id NOT IN"+
            "(SELECT permissionId FROM role_permission WHERE roleId=#{roleId})")
    List<Permission> findOtherPermissions(String id);


    void addPermissionToRole(@Param("pid")String pid, @Param("rid")String rid);

}
