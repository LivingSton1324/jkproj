<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������ ������</title>
</head>
<body>
<form name='joinForm' action='./joinAction.do' method='post'>
	<center>
		<table border='1'>
			<tr>
				<td colspan='2' align='center'>
					<b><font size='5'>ȸ������ ������</font></b>
				</td>
			</tr>
			<tr>
				<td>���̵�: </td>
				<td><input type="text" name="member_id"/></td>	
			</tr>
			<tr>
				<td>��й�ȣ: </td>
				<td><input type="password" name="member_pw"/></td>	
			</tr>
			<tr>
				<td>�̸�: </td>
				<td><input type="name" name="member_name"/></td>	
			</tr>
			<tr>
				<td>����: </td>
				<td><input type="text" name="member_age"/></td>	
			</tr>
			<tr>
				<td>����: </td>
				<td>
					<input type="radio" name="member_gender" value='����' chekced/>����
					<input type="radio" name="member_gender" value='����'/>����
				</td>	
			</tr>
			<tr>
				<td>�̸��� �ּ�: </td>
				<td><input type="text" name="member_email"/></td>	
			</tr>
			<tr>
				<td colspan='2' align='center'>
					<input type='submit' value='ȸ������'>&nbsp;&nbsp;
					<input type='reset' value='�ٽ� �ۼ�'>
					<a href='loginForm.do'>���ư���</a>
				</td>
			</tr>
		</table>
	</center>
</form>
</body>
</html>