<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
    pageContext.setAttribute("basePath",basePath);    
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC Demo 首页</title>
</head>
<body>

<h1>这里是SpringMVC Demo首页</h1>
<h3>出现此页面，说明配置成功。</h3>
<a href="<%=basePath%>admin/users">SpringMVC 博客系统-用户管理</a>
<br><br>
<a href="<%=basePath%>admin/blogs">SpringMVC 博客系统-博客管理</a>

</body>
</html>