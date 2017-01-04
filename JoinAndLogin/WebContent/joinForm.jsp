<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입 페이지</title>
</head>
<body>
<form name='joinForm' action='./joinAction.do' method='post'>
	<center>
		<table border='1'>
			<tr>
				<td colspan='2' align='center'>
					<b><font size='5'>회원가입 페이지</font></b>
				</td>
			</tr>
			<tr>
				<td>아이디: </td>
				<td><input type="text" name="member_id"/></td>	
			</tr>
			<tr>
				<td>비밀번호: </td>
				<td><input type="password" name="member_pw"/></td>	
			</tr>
			<tr>
				<td>이름: </td>
				<td><input type="name" name="member_name"/></td>	
			</tr>
			<tr>
				<td>나이: </td>
				<td><input type="text" name="member_age"/></td>	
			</tr>
			<tr>
				<td>성별: </td>
				<td>
					<input type="radio" name="member_gender" value='남자' chekced/>남자
					<input type="radio" name="member_gender" value='여자'/>여자
				</td>	
			</tr>
			<tr>
				<td>이메일 주소: </td>
				<td><input type="text" name="member_email"/></td>	
			</tr>
			<tr>
				<td colspan='2' align='center'>
					<input type='submit' value='회원가입'>&nbsp;&nbsp;
					<input type='reset' value='다시 작성'>
					<a href='loginForm.do'>돌아가기</a>
				</td>
			</tr>
		</table>
	</center>
</form>
</body>
</html>