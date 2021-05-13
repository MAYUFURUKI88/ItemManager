<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録画面</title>
</head>
<body>
<h1>商品登録画面</h1>
<hr>
<form action="/ItemManager/UserLoginServlet" method="post">
商品ID：<input type="text" name="item_id"><br>
商品名：<input type="text" name="item_name"><br>
単価：<input type="text" name="price"><br>
発売日：<input type="date" name="release_date"><br>
備考：<textarea name="comment" placeholder="入力してください。"></textarea></br>
<input type="submit" value="OK"><input type="submit" value="キャンセル">
</form>
</body>
</html>