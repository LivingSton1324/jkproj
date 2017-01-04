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

		// 한글 처리
		request.setCharacterEncoding("euc-kr");

		// 로그인 폼과 회원가입 폼은 처리해야할 커맨드(액션)이 없기 때문에
		// 단순히 어디로 포워드할지 경로주소만 정해준다.
		if (command.equals("/loginForm.do")) {
			// 로그인 폼 페이지
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./loginForm.jsp");
		} else if (command.equals("/joinForm.do")) {
			// 회원가입 폼 페이지
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./joinForm.jsp");
		} else if (command.equals("/loginAction.do")) {
			// 로그인 폼에서 로그인 버튼 클릭시 발생하는 커맨드(액션)
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/joinAction.do")) {
			// 회원가입 폼에서 회원가입 버튼을 클릭시에 발생하는 커맨드(액션)
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 로그인 액션(커맨드)에서 로그인 실패시 forward 객체에 아무것도 넘기지 않아서
		// forward가 null 상태이다. 그것을 제외하고 커맨드에서 보내는 경로가 리디렉트 여부에 따라
		// 리디렉트 및 포워딩한다.
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
