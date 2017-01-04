package com.member.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("/MemberFrontController")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("member");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		// �ѱ� ó��
		request.setCharacterEncoding("euc-kr");

		// �α��� ���� ȸ������ ���� ó���ؾ��� Ŀ�ǵ�(�׼�)�� ���� ������
		// �ܼ��� ���� ���������� ����ּҸ� �����ش�.
		if (command.equals("/loginForm.do")) {
			// �α��� �� ������
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./loginForm.jsp");
		} else if (command.equals("/joinForm.do")) {
			// ȸ������ �� ������
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./joinForm.jsp");
		} else if (command.equals("/loginAction.do")) {
			// �α��� ������ �α��� ��ư Ŭ���� �߻��ϴ� Ŀ�ǵ�(�׼�)
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/joinAction.do")) {
			// ȸ������ ������ ȸ������ ��ư�� Ŭ���ÿ� �߻��ϴ� Ŀ�ǵ�(�׼�)
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// �α��� �׼�(Ŀ�ǵ�)���� �α��� ���н� forward ��ü�� �ƹ��͵� �ѱ��� �ʾƼ�
		// forward�� null �����̴�. �װ��� �����ϰ� Ŀ�ǵ忡�� ������ ��ΰ� ����Ʈ ���ο� ����
		// ����Ʈ �� �������Ѵ�.
		if (forward != null) {
			if (forward.isRedirect() == true) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
