package com.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		try {
			// ���� ������Ʈ�� context.xml�� ������� �ʰ� 
			// ������ �ִ� context.xml�� ��� ������ �־ ���� ������Ʈ�� �����Ͽ���.
			Context init = new InitialContext();
			// ���� mySQL�� ����غ��ҽ��ϴ�.
			ds = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB ���� ����: " + e);
			return;
		}
	}
	
	private void closeAll() {
		if (rs!=null) try { rs.close(); } catch (SQLException ex) {}
		if (pstmt!=null) try { pstmt.close(); } catch (SQLException ex) {}
		if (conn!=null) try { conn.close(); } catch (SQLException ex) {}
	}
	
	// ȸ���� �ִ��� ���θ� �˻��Ѵ�.
	public int isMember(String id, String password) {
		String sql = "select Member_pw from Member where Member_ID=?";
		int result = -1;	// ���̵� �������� ���� 
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("member_pw").equals(password))
					result = 1;		// ��ġ 
				else
					result = 0;		// ����ġ 
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("joinMember Error: " + e);
		} finally {
			closeAll();
		}
		
		return result;
	}
	
	// ȸ�� ���� ����� DB�� ���� ����
	public boolean joinMember(MemberBean member) {
		String sql = "insert into Member values(?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMember_ID());
			pstmt.setString(2, member.getMember_Pw());
			pstmt.setString(3, member.getMember_Name());
			pstmt.setInt(4, member.getMember_Age());
			pstmt.setString(5, member.getMember_Gender());
			pstmt.setString(6, member.getMember_Email());
			result = pstmt.executeUpdate();		// row�� �ϳ� �̻� �����ϸ� 1��, �ϳ��� ������ 0�� ��ȯ

			if (result != 0) 
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("joinMember Error: " + e);
		} finally {
			closeAll();
		}
		
		return false;
	}
	
	// �α����� ���������ÿ� �α��� ����� ȸ�� ������ �ѷ��ֱ� ���� �޼��� 
	public MemberBean getMember(String id) {
		// ���̵� ���� ȸ�� ������ ��� �����ͼ� Bean��ü�� ��´�.
		String sql = "select * from Member where Member_ID=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			
			MemberBean mb = MemberBean.getAfterSetMemberBeanBy(rs);
			
			return mb;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getMember Error: " + e);
		} finally {
			closeAll();
		}
		
		return null;
	}
}
