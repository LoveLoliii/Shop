<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
</head>
<body>
<div>
<p>welcome dear.<b>${sessionScope.user.username }</b></p><!-- 取值具体  就近取值 -->
<p> <a href="logOff">注销 </a></p>
</div>
	<div>
		<table border="1px gray dashed" cellspacing ="0"><!--  	‘定义虚线。在大多数浏览器中呈现为实线。 ’ 有点意思-->
			<tr>
				<th>序号</th>
				<th>编号</th>
				<th>名称</th>
				<th>单位</th>
				<th>库存</th>
				<th>单价</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${goodsList }" var="goods" varStatus="i">
				<tr <c:if test="${(i.index+1)%2==0 }"> style ="background-color:lightgray; "</c:if>  >
					<td>${i.index+1 }</td>
					<td>${goods.id }</td>
					<td>${goods.goodsName }</td>
					<td>${goods.type }</td>
					<td>${goods.stock }</td>
					<td>${goods.price }</td>
					<td><a href="delete?id=${goods.id }">删除</a>&nbsp; <a href="modifyRedirect?id=${goods.id }">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>