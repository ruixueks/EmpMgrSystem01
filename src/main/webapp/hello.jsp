<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<div class="msg">
	<table>
		<tr><tb>会话的状态:</tb><tb><%=session.isNew() ? "新的会话":"旧的会话" %></tb></tr><br/>
		<tr><tb>会话ID:</tb><tb><%=session.getId() %></tb></tr><br/>
		<tr><tb>创建时间:</tb><tb><%=session.getCreationTime() %></tb></tr><br/>
		<tr><tb>上次访问的时间:</tb><tb><%=session.getLastAccessedTime() %></tb></tr><br/>
		<tr><tb>最大不活动时间间隔(s):</tb><tb><%=session.getMaxInactiveInterval() %></tb></tr><br/>
	</table>
	<div class="container">
		欢迎您，${user.username} <br/>
		 <a href="login.jsp">重新登录</a>  <a href="servlet/loginOutServlet">注销</a>  
	</div>
</body>
</html>