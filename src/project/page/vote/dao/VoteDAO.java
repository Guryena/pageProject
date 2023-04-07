package project.page.vote.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import project.page.vote.dto.VoteDTO;

public class VoteDAO {
	private DataSource dataSourece;

	public VoteDAO() {
		try {
			Context context = new InitialContext();
			dataSourece = (DataSource) context.lookup("java:comp/env/jdbc/oracle1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<VoteDTO> voteList() {
		List<VoteDTO> dtoVList = new ArrayList<VoteDTO>();
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rsVote = null;

		try {
			String voteSQL = "SELECT substr(v_jumin,1,6) || '-' ||substr(v_jumin,7) as 주민번호 , "
					+ "v_name as 성명, "
					+ "'19'||substr(v_jumin,1,2)|| '년' ||substr(v_jumin,3,2) || '월'||substr(v_jumin,5,2) || '일생' as 생년월일, "
					+ "'만 '||(to_number(to_char(sysdate,'yyyy')) - to_number('19'||substr(v_jumin,1,2)))||'세' as 나이, "
					+ "DECODE(substr(v_jumin,7,1),'1','남','여') as 성별, "
					+ "m_no as 투표번호, "
					+ "substr(v_time,1,2)||':'||substr(v_time,3,2) as 투표시간, "
					+ "v_area as 투표장소, "
					+ "DECODE(v_confirm,'Y','확인','미확인') as 유권자확인 "
					+ "FROM tbl_vote_202005";

			con = dataSourece.getConnection();
			st = con.prepareStatement(voteSQL);
			rsVote = st.executeQuery();

			while (rsVote.next()) {
				String v_jumin = rsVote.getString("주민번호");
				String v_name = rsVote.getString("성명");
				String v_birth = rsVote.getString("생년월일");
				String v_age = rsVote.getString("나이");
				String v_gender = rsVote.getString("성별");
				String m_no = rsVote.getString("투표번호");
				String v_time = rsVote.getString("투표시간");
				String v_area = rsVote.getString("투표장소");
				String v_confirm = rsVote.getString("유권자확인");

				VoteDTO dto = new VoteDTO(v_jumin, v_name, v_birth, v_age, v_gender, m_no, v_time, v_area, v_confirm);
				dtoVList.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rsVote != null) {
					rsVote.close();
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

		return dtoVList;

	}

	public void voteDo(String v_jumin, String v_name, String m_no, String v_time, String v_area, String v_confirm) {
		// TODO Auto-generated method stub
		
	}

}
