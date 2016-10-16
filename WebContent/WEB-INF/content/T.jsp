<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
</head>
<body>
<!--  
<s:iterator value="%{au}">
	${authorID}
	${name}
	${age}
	${country}

</s:iterator>
-->
<br>
<center>
<table cellpadding="0" cellspacing="0" border="1" width="30%">
<s:iterator value="%{bo}">
	<tr align="center" height="30">
	<td>
		${title}
	</td>
 	<td>
 		<form action="detail" method="post">
 			<input type="submit" value="查询" style="width:40px"/>
 			<input type="hidden" value="${title}" name="title"/>
 		</form>	
 	</td>
</s:iterator>
</table>
</center>

<br>
<center>
    <form action="return">
    	<input type="submit" style="width:80px" value="返回"/>
    </form>
</center>
</body>
</html>