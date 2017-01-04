<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% response.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 페이지</title>
</head>
<body>
	<form name='loginForm' action='./loginAction.do' method='post'>
		<center>
			<table border='1'>
				<tr>
					<td colspan='2' align='center'>
						<b><font size='5'>로그인 페이지</font></b>
					</td>		
				</tr>
				<tr>
					<td>아이디: </td><td><input type='text' name='member_id'></td>
				</tr>				
				<tr>
					<td>비밀번호: </td><td><input type='password' name='member_pw'></td>
				</tr>
				<tr>
					<td align='center'>
						<a href="joinForm.do">회원가입</a>
					</td>
					<td align='right'>
						<input type='submit' value="로그인">
					</td>
				</tr>
			</table>
		</center>	
	</form>
</body>
</html>