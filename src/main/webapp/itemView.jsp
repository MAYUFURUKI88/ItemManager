<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.rapideact.model.entity.ItemDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
ArrayList<ItemDto> list = (ArrayList<ItemDto>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品一覧画面</title>
</head>
<body>
	<h1>商品一覧画面</h1>
	<h1>
		ユーザ名：
		<c:out value="${user_name}" />
	</h1>
	<a href="http://localhost:8080/ItemManager/UserLogout"><button
			type="button">ログアウト</button></a>

	<hr>

	
<form method="post" action="/ItemManager/ItemCrudServlet">
		<input type="submit" name="add" value="新規登録">
	</form>


	<p>
		商品名検索：<input type="text">
	</p>
	<input type="submit" value="検索">
	<input type="submit" value="クリア">


	<!-- テーブル -->
	<table>
		<tr>
			<th>商品ID</th>
			<th>商品名</th>
			<th>単価</th>
			<th>発売日</th>
			<th>備考</th>
			<th>操作</th>
		</tr>
		<%
		for (ItemDto ud : list) {
		%>
		<tr>
			<td><%=ud.getItem_id()%></td>
			<td><%=ud.getItem_name()%></td>
			<td><%=ud.getPrice()%></td>
			<td><%=ud.getRelease_date()%></td>
			<td><%=ud.getComment()%></td>

			<td><form method="post" action="/ItemManager/ItemCrudServlet?id="+ <% ud.getItem_id()%> + "\">
					<input type="submit" name="upd" value="更新">
					<input type="submit" name="del" value="削除">
				</form></td>

		</tr>
		<%
		}
		%>
	</table>
	<br>
</body>
</html>