package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MemberManager {

	private MemberDao dao;  //의존성을 낮추기위해 여기서 바로 인스턴스를 생성하면 안된다. 선언만 
	private Scanner sc;
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";
	List<Member> mlist;


	public MemberManager(MemberDao dao) { //생성자
		this.dao = dao;
		sc= new Scanner(System.in);
		mlist = new ArrayList<>();
	}

	//회원가입
	void MemberJoin() {//회원 가입
		Connection con = null;
		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("회원가입 시작합니다.");
			
			idchk();//아이디확인
			
			System.out.print("비밀번호를 입력하세요 : ");
			String password = sc.nextLine().trim();
			System.out.print("이름를 입력하세요 :  ");
			String name = sc.nextLine().trim();
			System.out.print("주소를 입력하세요 : ");
			String address = sc.nextLine().trim();
			System.out.print("전화번호를 입력하세요 : ");
			String phonenum = sc.nextLine().trim();
				
//			}
//			System.out.println("비밀번호를 입력해주세요.");
//			String password = getStrInput("password : ");
//			String password2 = getStrInput("password confirm : ");
//			String name = getStrInput("name : ");
//			String email = getStrInput("email : ");
//			String phonenum = getStrInput("phonenum : ");
//
//
//			if(idCheck(id)) {
//				System.out.println("중복된 id입니다.");
//			} else if (password.equals(password2)) {
//				Member mem = new Member( id , password, name, email, phonenum);
//				mlist.add(mem);
//				int result = dao.joinMember(con, mem);
//
//				if(result > 0) {
//					System.out.println("입력되었습니다.");
//				} else {
//					System.out.println("입력 실패하였습니다.");
//				}
//				System.out.println(id + "님 가입을 축하드립니다.");
//			} else {
//				System.out.println("비밀번호를 확인해주세요.");
//			}
//
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		
		
	}

	
	void idchk () {
		while(true) {
			
			System.out.println("아이디를 입력해주세요 (영문 또는 숫자만 허용)");
			String id = sc.nextLine();
			id = id.trim();
			
			try {
				if(!(id.length()==0)){
					char chk = 0;
					for(int i =0; i<id.length(); i++) {
						chk = id.toLowerCase().charAt(i);
					}
					if(!(chk>='a'&&chk<='z'  || chk>='A'&&chk<='Z'|| chk>='0' && chk<='9')){
						throw new Exception("아이디는 숫자나 영문만 가능합니다.");
					}else {
						System.out.println("아이디는 "+ id+"입니다.");
					}
				}else 
					System.out.println("빈칸을 입력하셨습니다.");
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}

	}
	
	




}