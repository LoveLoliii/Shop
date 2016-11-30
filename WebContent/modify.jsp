<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modify</title>
</head>
<body>
<div>
<p>welcome dear.<b>${sessionScope.user.username }</b></p><!-- 取值具体  就近取值 -->
</div>
<form action="update" method ="post">
<table>
<tr>
	<td>编号</td>
	<td><input type="text" value = "${g.id}"  name = "id"  readonly="readonly"/></td>
</tr>
<tr>
	<td>名称</td>
	<td><input type="text" value = "${g.goodsName }" name ="goodsName"  /></td>
</tr>
<tr>
	<td>单位</td>
	<td><input type="text" value = "${g.type }"  name = "type"/></td>
</tr>
<tr>
	<td>库存</td>
	<td><input type="text" value = "${g.stock }"  name = "stock"></td>
</tr>
<tr>
	<td>单价</td>
	<td><input type="text" value = "${g.price }"  name = "price"/></td>
</tr>
<tr>
	<td colspan ="2"> <button type="submit">修改</button> </td>
</tr>

</table>
</form>
</body>
</html>