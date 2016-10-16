<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>书籍及作者详细信息</title>
</head>
<body>

	<center>
		<font size="10">
			书籍详细信息
		</font>
	</center>

	<table cellpadding="0" cellspacing="0" border="1" width="100%">

		<tr align="center" height="30">
		<td>ISBN</td><td>书名</td><td>作者编号</td><td>出版社</td><td>出版日期</td><td>价格</td><td>操作</td>
		<tr align="center" height="30">
		<s:iterator value="%{book}">
		<td>${ISBN}</td>
		<td>${title}</td>
		<td>${authorID}</td>
		<td>${publisher}</td>
		<td>${publishDate}</td>
		<td>${price}</td>
		<td>
			<form action="delete" method="post">
  			  	<input type="submit" value="删除"/>
  			  	<input type="hidden" name="ISBN" value="${ISBN}"/>
			</form>
		</td>
		</s:iterator>
	</table>
	<br><br>
		<font size="5">
			作者详细信息
		</font>
	<br>

	<table cellpadding="0" cellspacing="0" border="1" width="80%">
		<tr align="center" height="20">
		<td>作者编号</td><td>姓名</td><td>年龄</td><td>国家</td>
		<tr align="center" height="20">
		<s:iterator value="%{auth}">
		<td>${authorID}</td>
		<td>${name}</td>
		<td>${age}</td>
		<td>${country}</td>
		</s:iterator>
	</table>		
	<br>
	
		<form action="return">
			<input type="submit" style="width: 80px" value="返回" />
		</form>
</body>
</html>