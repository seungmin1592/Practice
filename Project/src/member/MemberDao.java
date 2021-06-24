package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {

	// 1. 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스를 생성하지 못하도록 처리.
	private MemberDao(){   //생성자에 프라이빗 붙인다. 외부에서 생성자 호출 불가능.외부에서 인스턴스 호출이 불가능해진다.

	}
	// 2. 클래스 내부에서 인스턴스를 만들고 
	static private MemberDao dao= new MemberDao() ;  //스테틱붙여줌. 생성자호출이 가능하다. 수정하지못하도록 private 사용// 스테틱은 프로그램 시작할때 메모리에 올라가기때문에 바로 인스턴스생성됨.


	// 3. 메소드를 통해서 반환하도록 처리 
	public static MemberDao getInstance() { // 요것도 스테틱. // 클래스 내부에서 만든 인스턴스를 반환함. //외부에서 DeptDao 인스턴스를 쓰고 싶으면 이 메소드를 통해서만 사용가능하다. 새로 만들진 못한다. 하나만 생성
		return dao;
	}

	//회원가입
	int joinMember(Connection con, Member member) {

		int result = 0;

		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO MEMBER VALUES (member_idx_seq.nextval, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhonenum());
			pstmt.setString(5, member.getEmail());


			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}


}