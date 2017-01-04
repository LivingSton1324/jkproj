package com.member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// FrontController에서 호출할 메서드를 1개의 양식으로 통일하기위한 인터페이스
public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
