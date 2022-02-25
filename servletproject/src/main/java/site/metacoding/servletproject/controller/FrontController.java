package site.metacoding.servletproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/front
@WebServlet("/front")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FrontController() {
		System.out.println("메모리에 있음"); // 한 번만 뜬다.
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 요청에서 삭제코드를 짤 수 있지만 프로토콜에 맞지 않음
		System.out.println("font 컨트롤러 요청");
		
		//1. 라우터 만들기 
		String path = request.getParameter("path"); // 쿼리스트링 읽어서 path에 담기
		System.out.println("path : " + path);
		
		if(path.equals("login")) {
			response.sendRedirect("/login.jsp"); // web_lap에서 옴
			// 리다이렉션 코드
			
//			PrintWriter out = response.getWriter();
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<meta charset='UTF-8'>");
//			out.println("<title>Insert title here</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<h1>login</h1>");
//			out.println("</body>");
//			out.println("</html>");
			} else if(path.equals("join")) {
				response.sendRedirect("/join.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
