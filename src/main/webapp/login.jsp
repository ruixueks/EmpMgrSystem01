<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="./scripts/jquery-3.2.1.js"></script>
<script type="text/javascript">
</script>
<title>登录页面</title>
</head>
<body>
	<div class="msg">
	<table>
		<tr><tb>会话的状态:</tb><tb><%=session.isNew() ? "新的会话":"旧的会话" %></tb></tr><br />
		<tr><tb>会话ID:</tb><tb><%=session.getId() %></tb></tr><br />
		<tr><tb>创建时间:</tb><tb><%=session.getCreationTime() %></tb></tr><br />
		<tr><tb>上次访问的时间:</tb><tb><%=session.getLastAccessedTime() %></tb></tr><br />
		<tr><tb>最大不活动时间间隔(s):</tb><tb><%=session.getMaxInactiveInterval() %></tb></tr><br />
	</table>
	</div>
	<div class="container">
		<div id="msg"></div>
		<form action="servlet/login" method="post">
			<input type="text" id="username" name="username" placeholder="请输入用户名" /><br />
			<input type="password" id="password" name="password"
				placeholder="请输入密码" /><br />
			<input type="reset" value="重填" /><span>&nbsp;&nbsp;</span> <input
				type="submit" value="登录" />
		</form>
	</div>
</body>
</html>