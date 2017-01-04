package com.member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberBean;
import com.member.db.MemberDAO;

public class MemberLoginAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 커맨드 클래스에서 프로세스에 따라 달라지는 forward 경로를
		// FrontController로 전해주는 역할을 한다.
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO memberDAO = new MemberDAO();

		// 아이디에 맞는 회원 존재 여부
		// -1 : 회원 없음, 0: 회원 있지만 패스워트 틀림, 1: 회원도 있고 패스워드도 맞음
		int result = -1;

		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
		result = memberDAO.isMember(id, pw);

		if (result == 0 || result == -1) {
			if (result == 0)
				ActionForward.redirectAfterAlert(response, "비밀번호가 일치하지 않습니다.", "loginForm.jsp");
			else
				ActionForward.redirectAfterAlert(response, "아이디가 존재하지 않습니다.", "loginForm.jsp");

			return null;
		}

		// 로그인 성공
		MemberBean member = memberDAO.getMember(id);
		session.setAttribute("member", member);

		forward.setRedirect(false);
		forward.setPath("./loginResult.jsp");
		return forward;
	}
}
