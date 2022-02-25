package site.metacoding.mvc.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.web.domain.MyUSerRepository;
import site.metacoding.mvc.web.domain.MyUser;

import java.util.List;

// 회원 관련 요청만 컨트롤한다.
// MyUSer 테이블과 관련된 것들만 컨트롤한다.
public class MyUserController {
	HttpServletRequest request;
	HttpServletResponse response;
	private MyUSerRepository repo; // 레퍼에 의존한다.
	
	public MyUserController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		repo = new MyUSerRepository();
	}
	
	// Get: http://localhost:8080/myuser
	public void getAll() {
		System.out.println("getAll 호출 됨");
		repo.selectAll();
		List<MyUser> myUsers = repo.selectAll();
		System.out.println("myUsers : " + myUsers.get(1).getEmail());
		request.setAttribute("myUsers", myUsers);
		
		try {
			//response.sendRedirect("/userInfo.jsp"); I.O가 함
			RequestDispatcher dis = request.getRequestDispatcher("/user.jsp");
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Get: http://localhost:8080/myuser?id=1
	public void getOne(int id) { // id만 받아야 함
		System.out.println("getOne 호출 됨");
		repo.selectById(1);
		MyUser myUser = repo.selectById(id);
		System.out.println("myUser : " + myUser.getUsername());
		request.setAttribute("myUser", myUser); // 키 값으로 값을 저장함 리퀘스트 유지
		try {
			//response.sendRedirect("/userInfo.jsp"); I.O가 함
			RequestDispatcher dis = request.getRequestDispatcher("/userInfo.jsp");
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
