<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<form name="Form2" action="<%=path%>/student/saveMaterial" method="post"  enctype="multipart/form-data">
	<h1>使用spring mvc提供的类的方法上传文件</h1>
	<input type="file" name="file">
	<input  type="submit" value="upload"/>
	<input type="text" value="1" name="studentno" id="st">
	<input type="text" value="2" name=conditionid>
	<p>${studentno}</p>
	</form>
	
	<form name="Form1" action="<%=path%>/student/test" method="post">
	 内容<textarea rows="2" cols="3" name="context"></textarea>
	 <input  type="submit" value="提交内容"/>
	</form>
	
	<div class="context"></div>
</body>
</html>

