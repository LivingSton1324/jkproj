package com.member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.db.MemberBean;
import com.member.db.MemberDAO;

public class MemberJoinAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 한글 처리
		request.setCharacterEncoding("euc-kr");

		// 커맨드 클래스에서 프로세스에 따라 달라지는 forward 경로를
		// FrontController로 전해주는 역할을 한다.
		ActionForward forward = new ActionForward();
		MemberDAO memberDAO = new MemberDAO();
		MemberBean member;

		boolean result = false;
		
		// getParameter를 통해서 Form에서 받아온 정보를 빈 객체에 넣고
		// DAO에 빈 객체를 전해서 프로세스를 처리한다.
		member = MemberBean.getAfterSetMemberBeanBy(request);

		// -1이 되면 아이디가 존재하지 않음으로 넘어가고 -1이 아니면 아이디가 이미 있으니까
		// 회원가입이 거절된다.
		if (memberDAO.isMember(member.getMember_Name(), member.getMember_Pw()) != -1) 
		{
			ActionForward.redirectAfterAlert(response, "아이디가 이미 존재합니다!", "joinForm.jsp");
			return null;
		}	
		
		// 가입 성공여부를 result 변수에 넣어준다.
		result = memberDAO.joinMember(member);
				
		if (result == false) {
			System.out.println("회원가입 실패...");
			return null;
		}

		// 회원가입 성공!
		forward.setRedirect(true);
		forward.setPath("./loginForm.do");
		return forward;
	}
}
