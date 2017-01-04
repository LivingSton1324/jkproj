package com.member.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

// FrontController���� �ش��ϴ� Ŀ�ǵ� ����ÿ� 
// ���𷺼� ���ο� ������ �� ���𷺼� �ּҸ� ���� Ŭ���� 
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
