package org.almansa.springtest.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.junit.Test;
import org.springframework.web.servlet.DispatcherServlet;

public class HttpServletTest {

	@Test
	public void service_method() throws ServletException, IOException {
		// DispatcherServlet은 Http요청 Controller들의 중앙 디스페쳐이다. 
		HttpServlet ds = new DispatcherServlet();
		
		// 서블릿요청, 결과의 최상위 인터페이스
		// 재밋는 것은 이 인터페이스들에 대한 구현체가 
		// HttpServletRequestWrapper라는 래퍼 클래스 제외하고는 존재하지 않는다.
		ServletRequest request = null;
		ServletResponse response = null;
		
		// HttpServlet service 메소드는 request를 분석해 내부의 protected 메소드인
		// doGet, doPost, doDelete등 doxxx메소드 처리를 위임한다.
		// 보통의 경우 자식 구현체에서 service 메소드를 재정의하는 경우는 없다.
		ds.service(request, response);
	}
}
