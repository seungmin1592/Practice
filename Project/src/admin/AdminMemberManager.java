package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminMemberManager {
	private AdminMemberDao dao;
	private Scanner sc;

	public AdminMemberManager(AdminMemberDao dao) {
		this.dao = dao;
		sc = new Scanner(System.in);
	}

	// 회원 정보 리스트
	// 전체 리스트 출력 메소드
	// AdminMember 에서 데이터 리스트를 받고 출력 처리
	void AdminMemberList() {

		// Connection 객체 생성 -> 트렌젝션 처리
		Connection conn = null;

		// 2. 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			List<AdminMember> list = dao.getMemberList(conn);
			System.out.println("==============================");
			System.out.println("회원 정보 리스트");
			System.out.println("-----------------------------");
			System.out.println("회원번호 \t 아이디 \t 비밀번호 \t 이름 \t 연락처 \t 이메일");
			System.out.println("-----------------------------");

			for (AdminMember adminMember : list) {
				System.out.printf("%d \t %s \t %s \t %s \t %s \t %s \n", adminMember.getIdx(), adminMember.getId(), adminMember.getPw(), adminMember.getName(), adminMember.getPhonenum(), adminMember.getEmail());
			}

			System.out.println("-----------------------------");
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 회원 정보 리스트 출력
	// 삭제할 데이터의 회원번호 입력 
	// 해당 회원번호의 데이터 delete
	void AdminMemberDel() {
		// Connection 객체 생성 -> 트렌젝션 처리
		Connection conn = null;

		// 2. 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			
			AdminMemberList();
			System.out.println("삭제를 원하시는 회원번호를 입력해주세요.");
			int idx = Integer.parseInt(sc.nextLine());
			
			int result = dao.deleteMember(conn, idx);
			
			if(result>0) {
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("해당 부서의 정보가 없습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
