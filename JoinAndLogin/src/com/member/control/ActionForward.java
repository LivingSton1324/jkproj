package com.member.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

// FrontController에서 해당하는 커맨드 수행시에 
// 리디렉션 여부와 포워드 및 리디렉션 주소를 담은 클래스 
public class ActionForward {
	private boolean isRedirect = false;
	private String path = null;

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public static void redirectAfterAlert(HttpServletResponse response, String alertWords, String path) throws Exception {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+ alertWords +"');");
		out.println("location.href='./" + path + "'");
		out.println("</script>");
		out.close();
	}
}
