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
	<button onclick="location='login?acount=12345&password=123456&role=1'">dianji</button>

	<form  action="login" method="post"
		>
		<!-- <h1>采用流的方式上传文件</h1>
		<input type="file" name="file"> -->
		<input type="text" name="account" />
		<input type="text" name="password" />
		<input type="text" name="role" />
		 <input type="submit" />
	</form>
</body>
</html>
