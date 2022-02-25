package site.metacoding.mvc.web.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import site.metacoding.mvc.config.DBConn;

// 목적은 insert, delete, update, select하는 메서드를 만들어서 재사용한다.
public class MyUSerRepository {
	private Connection conn;
	
	public MyUSerRepository() {
		conn = DBConn.getConnection();
	}
	
	// SELECT * FROM myUser
	public List<MyUser> selectAll() {
		MyUser myUser = null;
		List<MyUser> myUsers = new ArrayList<>();
		try {
 			String sql = "SELECT * FROM myUser";
 			PreparedStatement pstmt = conn.prepareStatement(sql);
 			ResultSet rs = pstmt.executeQuery();
 			
 			while(rs.next()) {
 				myUser = new MyUser(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"));
 				myUsers.add(myUser);
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return myUsers;
	}
	
	// SELECT * FROM myUser WHERE id = ?
	public  MyUser selectById(int id) { // 한 건을 삭제하는 게 제일 기본적인 것
		MyUser myUser = null; // 
		
		try {
 			String sql = "SELECT * FROM myUser WHERE id = ?";
 			PreparedStatement pstmt = conn.prepareStatement(sql);
 			ResultSet rs = pstmt.executeQuery();
 			
 			if(rs.next()) { // 한 건만 부를 테니까 If 문으로
 				myUser = new MyUser(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"));
 				// 모델에다가 옮김, 컨트롤러에 옮기다는 듯 
 			}
 			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return myUser;
	}
	
	// INSERT INTO myUser(username, password, email) VALUES(?, ?, ?)
 	public int insert(String username, String password, String email) { // 한 건 인서트
		int result = 0; // 변수 초기화
		
		
 		return -1;
	}
 	
 	// DELETE FROM myUser WHERE id =?
 	public int deleteById(int id) {
 		int result = 0;
 		
 		try {
 			String sql = "DELETE FROM myUser WHERE id =?";
 			PreparedStatement pstmt = conn.prepareStatement(sql);
 			
		} catch (Exception e) {
			e.printStackTrace();
		}
 		
 		
 		return result;
 	}
 	
 	// UPDATE myUser SET username = ?, password = ?, email = ? WHERE id = ?
 	public int update(int id, String username, String password, String email) {
 		int result = 0;
 		
 		return result;
 	}
}
