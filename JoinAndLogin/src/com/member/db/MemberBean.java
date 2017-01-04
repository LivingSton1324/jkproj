package com.member.db;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

// ȸ�� ������ ���� �� Ŭ��
public class MemberBean {
	private String member_ID;		// ȸ�� ���̵�
	private String member_Pw;		// ȸ�� ��й�ȣ 
	private String member_Name;		// ȸ�� �̸� 
	private int member_Age;			// ȸ�� ���� 
	private String member_Gender;	// ȸ���� ���� 
	private String member_Email;	// ȸ���� �̸����ּ� 
	
	// �⺻ �����ڸ� ����
	public MemberBean() {
		// TODO Auto-generated constructor stub
	}

	// DAO���� ��ü ������ �Ѳ����� �����ͼ� �� ��ü�� ���� �� ���ϰ� ���� ���� ������ 
	public MemberBean(String member_ID, String member_Pw, String member_Name, int member_Age, String member_Gender,
			String member_Email) {
		this.member_ID = member_ID;
		this.member_Pw = member_Pw;
		this.member_Name = member_Name;
		this.member_Age = member_Age;
		this.member_Gender = member_Gender;
		this.member_Email = member_Email;
	}

	// obj ���� Request��ü�� ResultSet�� �� �� �ִ�.
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
	// Getter�� Setter��
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
