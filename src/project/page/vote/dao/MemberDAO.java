package project.page.vote.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import project.page.vote.dto.MemberDTO;


public class MemberDAO {
	private DataSource dataSource;
	public MemberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public List<MemberDTO> memberList(){
		List<MemberDTO> dtoMList = new ArrayList<MemberDTO>();
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rsMember = null;
		
		try {
			String query = "SELECT M.m_no as 후보번호, "
					+ "M.m_name as 성명, P.p_name as 소속정당, S.S_GRADE as 학력, "
					+ "substr(M.m_jumin,1,6)||  '-' ||substr(M.m_jumin,7) as 주민번호, "
					+ "M.m_city as 지역구,"
					+ " substr(P.p_tel1,1,2)|| '-' ||P.p_tel2|| '-' || (substr(P.p_tel3,4) || substr(P.p_tel3,4) || substr(P.p_tel3,4) || substr(P.p_tel3,4)) as 대표번호"
					+ " FROM tbl_member_202005 M, tbl_party_202005 P, TBL_SCHOOL_202005 S WHERE M.p_code = P.p_code AND M.P_SCHOOL = S.P_SCHOOL";
			
			con = dataSource.getConnection();
			st = con.prepareStatement(query);
			rsMember = st.executeQuery();

			
			while (rsMember.next()) {
				String m_no = rsMember.getString("후보번호");
				String m_name = rsMember.getString("성명");
				String p_code = rsMember.getString("소속정당");
				String p_school = rsMember.getString("학력");
				String m_jumin = rsMember.getString("주민번호");
				String m_city = rsMember.getString("지역구");
				String phone = rsMember.getString("대표번호");
				
				MemberDTO dto = new MemberDTO(m_no, m_name, p_code, p_school, m_jumin, m_city, phone);
				dtoMList.add(dto);
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rsMember != null) {
					rsMember.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtoMList;
		
	}
	
	
	
}
