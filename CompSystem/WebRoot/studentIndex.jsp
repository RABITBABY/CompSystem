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
	<form name="Form2"  id="form2" method="post"  enctype="multipart/form-data">
	<h1>使用spring mvc提供的类的方法上传文件</h1>
	<input type="file" name="file">
	<input type="text" value="11" name="studentno" id="st">
	<input type="text" value="2" name=conditionid>
	<input  type="submit" value="upload"/>
	<p>${studentno}</p>
	</form>
	
	<form name="Form1" action="<%=path%>/student/test" method="post">
	 内容<textarea rows="2" cols="3" name="context"></textarea>
	 <input  type="submit" value="提交内容"/>
	</form>
	
	<!-- 提交多个对象 -->
	<form name="Form3" action="<%=path%>/teacher/addComp" method="post">
	 <input  type="text" name="competition.comname" value="蓝桥杯"/>
	 <input  type="text" name="budgets[0].subject" value="车费"/>
	 <input  type="text" name="budgets[1].subject" value="午餐"/>
	 <input  type="submit" value="提交内容"/>
	</form>
	
	<!-- 下载awards -->
	<form name="Form4" action="<%=path%>/student/downloadAwards" method="post">
	 <input  type="text" name="awardsimg" value="1.jpg"/>
	 <input  type="submit" value="下载"/>
	</form>
	
	<!-- 更新student -->
	<form name="Form5" action="<%=path%>/student/updateInfo" method="post">
	 <input  type="text" name="studentno" value="1"/>
	 <input  type="text" name="studentname" value="慌欢"/>
	 <input  type="text" name="phone" value="1"/>
	 <input  type="text" name="email" value="888888"/>
	 <input  type="submit" value="修改"/>
	</form>
	<!-- 更新teacher -->
	<form name="Form6" action="<%=path%>/teacher/updateTeacherInfo" method="post">
	 <input  type="text" name="teacherno" value="1"/>
	 <input  type="text" name="teachername" value="邱邱"/>
	 <input  type="text" name="birth" value="2017-2-2"/>
	 <input  type="submit" value="修改"/>
	</form>
	
	<form name="Form7"  method="post" id="mInfo"  enctype="multipart/form-data">
	<h1>使用spring mvc提供的类的方法上传文件异步提交</h1>
	<input type="file" name="file">
	<input type="text" value="10" name="studentno" id="st">
	<input type="text" value="2" name=conditionid>
	<input  type="button" value="upload" id="add"/>
	</form>
	
	<a id="btn">btn</a>
	<img alt="" src="fileUpload/material/173839471.jpg">
	
	<form name="Form8"  id="dowInfo">
	<h1>下载申报表</h1>
	<input  type="button" value="dowload" id="dowload"/>
	</form>
</body>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<script type="text/javascript">
  $(function(){
  
  
    $("#add").click(function(){
       $.ajax({
                type: "POST",
                url:"student/saveMaterial",
                data:{comId:1},// 你的formid
                async: false,
                error: function() {
                   
                },
                success: function() {
                   
                }
            });
    });
    
    $("#dowload").click(function(){
       console.log("ss");
        window.location.href='http://localhost:8080/CompSystem/teacher/getAprroveTable?comId=32';

    });
    
    
  });
</script>
</html>

