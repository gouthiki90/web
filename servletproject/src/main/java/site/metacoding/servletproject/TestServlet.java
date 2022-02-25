package site.metacoding.servletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:80/index.jsp(URL)
// http://localhost:80/hello (URI)

@WebServlet("/test") // test들어오면 서블렛 하게 해줌
public class TestServlet extends HttpServlet {

	// 사용자에게 받은 body, header 정보를 req에 담고 응답될 빈 객체 resp를 만들어서 doget(req, resp);에 담아서 호출해준다.
	// req는 요청 소켓, resp는 응답 소켓 = 서블릿
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get요청됨");
		
		String name = "gaeun";
		
		PrintWriter out = resp.getWriter(); // Print Buffer, BW 사용해서 클라이언트와 연결된 소켓으로 응답해주기
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello EveryOne" + name + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
