<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=utf-8">
<title>发送推荐</title>
</head>
<body>
    <form action="ApplyServlet" method="post"  enctype="multipart/form-data">
    标语 ：<input type="text" name="slogan" />
     <br>
     时间 ： <input type="date" name="time" />
   <br>
     价格 ： <input type="text" name="price" />
   <br>
     选择图片 ： <input type="file" name="picture" />
    <br>
    <input type="submit" value="发送">
    </form>
</body>
</html>