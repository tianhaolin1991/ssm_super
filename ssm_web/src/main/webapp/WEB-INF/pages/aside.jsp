<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
<%--
  Created by IntelliJ IDEA.
  User: tianhaolin1991
  Date: 2019/2/24
  Time: 上午9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 导航侧栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- search form -->
        <!--<form action="#" method="get" class="sidebar-form">
    <div class="input-group">
        <input type="text" name="q" class="form-control" placeholder="搜索...">
        <span class="input-group-btn">
        <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
        </button>
      </span>
    </div>
</form>-->
        <!-- /.search form -->


        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <!-- 菜单 -->

            <!-- 系统管理 -->
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-gear"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li>
                        <a href="${pageContext.request.contextPath}/user/findAll.do">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/role/findAll.do">
                            <i class="fa fa-circle-o"></i> 角色管理
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/permission/findAll.do">
                            <i class="fa fa-circle-o"></i> 权限管理
                        </a>
                    </li>

                    <security:authorize access="hasRole('ROLE_ADMIN')">
                        <li>
                            <a href="${pageContext.request.contextPath}/sysLog/findAll.do">
                                <i class="fa fa-circle-o"></i> 日志管理
                            </a>
                        </li>
                    </security:authorize>


                </ul>
            </li>
            <!-- 系统管理/-->

            <!-- 基础数据 -->
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-cube"></i> <span>基础数据</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li>
                        <a href="${pageContext.request.contextPath}/product/findAll.do">
                            <i class="fa fa-circle-o"></i> 商品管理
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/order/findAll.do">
                            <i class="fa fa-circle-o"></i> 订单管理
                        </a>
                    </li>



                </ul>
            </li>
            <!-- 基础数据/-->


        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->
</body>
</html>
