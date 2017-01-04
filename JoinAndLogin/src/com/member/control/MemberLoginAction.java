package com.member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.db.MemberBean;
import com.member.db.MemberDAO;

public class MemberLoginAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Ŀ�ǵ� Ŭ�������� ���μ����� ���� �޶����� forward ��θ�
		// FrontController�� �����ִ� ������ �Ѵ�.
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO memberDAO = new MemberDAO();

		// ���̵� �´� ȸ�� ���� ����
		// -1 : ȸ�� ����, 0: ȸ�� ������ �н���Ʈ Ʋ��, 1: ȸ���� �ְ� �н����嵵 ����
		int result = -1;

		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
		result = memberDAO.isMember(id, pw);

		if (result == 0 || result == -1) {
			if (result == 0)
				ActionForward.redirectAfterAlert(response, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "loginForm.jsp");
			else
				ActionForward.redirectAfterAlert(response, "���̵� �������� �ʽ��ϴ�.", "loginForm.jsp");

			return null;
		}

		// �α��� ����
		MemberBean member = memberDAO.getMember(id);
		session.setAttribute("member", member);

		forward.setRedirect(false);
		forward.setPath("./loginResult.jsp");
		return forward;
	}
}
