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
			// 따로 프로젝트에 context.xml을 사용하지 않고 
			// 서버에 있는 context.xml에 디비 정보를 넣어서 여러 프로젝트에 공유하였다.
			Context init = new InitialContext();
			// 저는 mySQL을 사용해보았습니다.
			ds = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB 연결 실패: " + e);
			return;
		}
	}
	
	private void closeAll() {
		if (rs!=null) try { rs.close(); } catch (SQLException ex) {}
		if (pstmt!=null) try { pstmt.close(); } catch (SQLException ex) {}
		if (conn!=null) try { conn.close(); } catch (SQLException ex) {}
	}
	
	// 회원이 있는지 여부를 검사한다.
	public int isMember(String id, String password) {
		String sql = "select Member_pw from Member where Member_ID=?";
		int result = -1;	// 아이디 존재하지 않음 
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("member_pw").equals(password))
					result = 1;		// 일치 
				else
					result = 0;		// 불일치 
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("joinMember Error: " + e);
		} finally {
			closeAll();
		}
		
		return result;
	}
	
	// 회원 가입 통과시 DB에 정보 삽입
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
			result = pstmt.executeUpdate();		// row가 하나 이상 존재하면 1을, 하나도 없으면 0을 반환

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
	
	// 로그인이 성공했을시에 로그인 결과에 회원 정보를 뿌려주기 위한 메서드 
	public MemberBean getMember(String id) {
		// 아이디에 따른 회원 정보를 모두 가져와서 Bean객체에 담는다.
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
