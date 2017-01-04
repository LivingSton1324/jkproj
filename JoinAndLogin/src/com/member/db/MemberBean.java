package com.member.db;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

// 회원 정보를 담은 빈 클래
public class MemberBean {
	private String member_ID;		// 회원 아이디
	private String member_Pw;		// 회원 비밀번호 
	private String member_Name;		// 회원 이름 
	private int member_Age;			// 회원 나이 
	private String member_Gender;	// 회원의 성별 
	private String member_Email;	// 회원의 이메일주소 
	
	// 기본 생성자를 정의
	public MemberBean() {
		// TODO Auto-generated constructor stub
	}

	// DAO에서 객체 정보를 한꺼번에 가져와서 빈 객체에 담을 때 편리하게 쓰기 위한 생성자 
	public MemberBean(String member_ID, String member_Pw, String member_Name, int member_Age, String member_Gender,
			String member_Email) {
		this.member_ID = member_ID;
		this.member_Pw = member_Pw;
		this.member_Name = member_Name;
		this.member_Age = member_Age;
		this.member_Gender = member_Gender;
		this.member_Email = member_Email;
	}

	// obj 에는 Request객체와 ResultSet가 올 수 있다.
	public static MemberBean getAfterSetMemberBeanBy(Object obj) throws Exception {
		String member_ID;
		String member_Pw;
		String member_Name;
		int member_Age;
		String member_Gender;
		String member_Email;
		
		if (obj instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest)obj;
			member_ID = request.getParameter("member_id");
			member_Pw = request.getParameter("member_pw");
			member_Name = request.getParameter("member_name");
			member_Age = Integer.parseInt(request.getParameter("member_age"));
			member_Gender = request.getParameter("member_gender");
			member_Email = request.getParameter("member_email");
			return new MemberBean(member_ID, member_Pw, member_Name, member_Age, member_Gender, member_Email);
		} else if (obj instanceof ResultSet) {
			ResultSet rs = (ResultSet)obj;
			member_ID = rs.getString("member_id");
			member_Pw = rs.getString("member_pw");
			member_Name = rs.getString("member_name");
			member_Age = rs.getInt("member_age");
			member_Gender = rs.getString("member_gender");
			member_Email = rs.getString("member_email");
			return new MemberBean(member_ID, member_Pw, member_Name, member_Age, member_Gender, member_Email);
		}
		return null;
	}
	// Getter와 Setter들
	public String getMember_ID() {
		return member_ID;
	}

	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}

	public String getMember_Pw() {
		return member_Pw;
	}

	public void setMember_Pw(String member_Pw) {
		this.member_Pw = member_Pw;
	}

	public String getMember_Name() {
		return member_Name;
	}

	public void setMember_Name(String member_Name) {
		this.member_Name = member_Name;
	}

	public int getMember_Age() {
		return member_Age;
	}

	public void setMember_Age(int member_Age) {
		this.member_Age = member_Age;
	}

	public String getMember_Gender() {
		return member_Gender;
	}

	public void setMember_Gender(String member_Gender) {
		this.member_Gender = member_Gender;
	}

	public String getMember_Email() {
		return member_Email;
	}

	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}
	
	
}
