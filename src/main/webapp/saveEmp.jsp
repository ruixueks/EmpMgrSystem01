<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>插入页面</title>
</head>
<body>
	<div align="center">
		<form action="servlet/addEmpServlet" method="get">
			<table>
				<tr>
					<td>empno:<input type="text" name="empno" ><td>			
				</tr>
				<tr>
					<td>ename:<input type="text" name="ename" ><td>
				</tr>
				<tr>
					<td>job:<input type="text" name="job" ><td>
				</tr>
				<!-- <tr>
					<td>hiredate:<input type="text" name="hiredate" ><td>
				</tr> -->
				<tr>
					<td>sal:<input type="text" name="sal" ><td>
				</tr>
			</table>
			<input type="submit" name="submit" value="插入">
		</form>
	
	</div>
	
</body>
</html>