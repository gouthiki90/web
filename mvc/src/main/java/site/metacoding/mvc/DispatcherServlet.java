package site.metacoding.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.web.MyUserController;

// http://localhost:8080/ 모든 요청이 이쪽으로 다 들어온다.
// http://localhost:8080/hello
// http://localhost:8080/myuser 파싱해서 리디렉션 하기
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String domain = request.getRequestURI();
		// String domain2 = request.getRequestURL().toString(); 스트링 버퍼 타입이라 문자열로 받기
		
		if(domain.equals("/myuser")) { // myuser했을 때 컨트롤러 부르기
			MyUserController controller = new MyUserController(request, response);
			// 리퀘스트를 해야 뷰를 응답해줌
			
			String idstr = request.getParameter("id");
			
			if(idstr == null) {
				controller.getAll(); //쿼리스트링 없을 때
			}else {
				int id = Integer.parseInt(idstr); // integer로 바꾸고
				controller.getOne(id); // 쿼리스트링 있을 때
				// id 넣기
			}
		}
		System.out.println("URI" + domain);
		// System.out.println("URL" + domain2);
		
	} // 디스패처 서블릿이 종료, 스레드가 종료되는 것 1. 클라이언트에게 연결된 리스펀스 선 짤림 stateless, 2. 리퀘스트 메모리 영역 삭제됨, DB connection 반납

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	} // 디스패처 서블릿이 종료, 스레드가 종료되는 것

}
