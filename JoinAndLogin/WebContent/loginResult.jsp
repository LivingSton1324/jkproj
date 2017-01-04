<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 결과 페이지</title>
</head>
<body>
<center>
	<h2>로그인 결과 정보</h2>
	<hr/>
	<p>	아이디: ${ member.member_ID } <br/>
		이름: ${ member.member_Name } <br/>
		나이: ${ member.member_Age } <br/>
		성별: ${ member.member_Gender } <br/>
		이메일: ${ member.member_Email }
	</p>	
	<hr/>
</center>
</body>
</html>