package com.member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.db.MemberBean;
import com.member.db.MemberDAO;

public class MemberJoinAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// �ѱ� ó��
		request.setCharacterEncoding("euc-kr");

		// Ŀ�ǵ� Ŭ�������� ���μ����� ���� �޶����� forward ��θ�
		// FrontController�� �����ִ� ������ �Ѵ�.
		ActionForward forward = new ActionForward();
		MemberDAO memberDAO = new MemberDAO();
		MemberBean member;

		boolean result = false;
		
		// getParameter�� ���ؼ� Form���� �޾ƿ� ������ �� ��ü�� �ְ�
		// DAO�� �� ��ü�� ���ؼ� ���μ����� ó���Ѵ�.
		member = MemberBean.getAfterSetMemberBeanBy(request);

		// -1�� �Ǹ� ���̵� �������� �������� �Ѿ�� -1�� �ƴϸ� ���̵� �̹� �����ϱ�
		// ȸ�������� �����ȴ�.
		if (memberDAO.isMember(member.getMember_Name(), member.getMember_Pw()) != -1) 
		{
			ActionForward.redirectAfterAlert(response, "���̵� �̹� �����մϴ�!", "joinForm.jsp");
			return null;
		}	
		
		// ���� �������θ� result ������ �־��ش�.
		result = memberDAO.joinMember(member);
				
		if (result == false) {
			System.out.println("ȸ������ ����...");
			return null;
		}

		// ȸ������ ����!
		forward.setRedirect(true);
		forward.setPath("./loginForm.do");
		return forward;
	}
}
