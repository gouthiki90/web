package site.metacoding.mvc.web.domain;

// 데이터 베이스 테이블을 자바세상에 모델링하는 것이다.
public class MyUser {
	// 모델링한 것들
	private int id;
	private String username;
	private String password;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public MyUser() { // 기본 생성자
		
	}
	public MyUser(int id, String username, String password, String email) { // 풀 생성자
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
}
