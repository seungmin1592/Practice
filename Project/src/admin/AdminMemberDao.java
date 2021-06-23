package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminMemberDao {
	// 싱글톤 패턴 : 여러개의 인스턴스를 생성하지 못하도록 하는 코딩 스타일
		// 1. 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스를 생성하지 못하도록 처리
		private AdminMemberDao() {
			
		}
		
		// 2. 클래스 내부에서 인스턴스를 만들고
		static AdminMemberDao dao = new AdminMemberDao(); 
		
		// 3. 메소드를 통해서 반환하도록 처리
		public static AdminMemberDao getInstance() {
			return dao;
		}
		
		
		

		// 1. 전체 데이터 검색 기능
		// 반환 타입 List<Dept>
		// 매개변수 - Connection 객체 : Statement
		ArrayList<AdminMember> getMemberList(Connection conn) {

			ArrayList<AdminMember> list = null;

			// 데이터 베이스의 Member테이블 이용 select 결과를 -> list 저장
			Statement stmt = null;
			ResultSet rs = null;

			try {
				stmt = conn.createStatement();
				String sql = "select * from member order by idx";

				// 결과 받아오기
				rs = stmt.executeQuery(sql);

				list = new ArrayList<>();

				// 데이터를 Member 객체로 생성 -> list에 저장
				while (rs.next()) {
					
					AdminMember d = new AdminMember(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
					list.add(d);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

			return list;
		}
		
		
		// 2. AdminMember 테이블의 데이터를 삭제
		// 삭제된 행의 개수를 반환
		// 사용자로부터 idx 받아서 처리
		int changeMember(Connection conn,  int idx) {
			
			int result = 0;
			// 데이터 베이스 처리 sql
			PreparedStatement pstmt = null;
			
			try {
				
				String sql;
				
				switch(1) {
					case 1 :
						sql = "update member set id=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, change);
						
						//result = pstmt.executeUpdate();
					/*	
					case 2: 
						sql = "update member set pw=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, change);
						
						result = pstmt.executeUpdate();
						
					case 3 :
						sql = "update member set name=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, change);
						
						result = pstmt.executeUpdate();
						*/
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			return result;
		}

		

}
