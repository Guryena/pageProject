package project.page.vote.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import project.page.vote.dto.RankingDTO;


public class RankingDAO {
	private DataSource dataSourece;
	public RankingDAO() {
		try {
			Context context = new InitialContext();
			dataSourece = (DataSource)context.lookup("java:comp/env/jdbc/oracle1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public List<RankingDTO> rankingList(){
		List<RankingDTO> dtoRList = new ArrayList<RankingDTO>();
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rsMember = null;
		
		try {
			String rankSQL = "SELECT RANK() OVER (ORDER BY COUNT(V.M_NO) DESC) as 순위, M.M_NO as 후보번호, "
					+ "M.M_NAME as 성명, M.P_CODE as 소속정당, M.M_CITY as 지역구, COUNT(V.M_NO) as 득표수,"
					+ " ROUND((RATIO_TO_REPORT(COUNT(V.M_NO)) OVER()*100),2)||'%' as 득표율"
					+ " FROM TBL_MEMBER_202005 M, TBL_VOTE_202005 V "
					+ "WHERE M.M_NO = V.M_NO GROUP BY M.M_NO, M.M_NAME, M.P_CODE, M.M_CITY";
			
			con = dataSourece.getConnection();
			st = con.prepareStatement(rankSQL);
			rsMember = st.executeQuery();
			
			while (rsMember.next()) {
				String rank = rsMember.getString("순위");
				String m_no = rsMember.getString("후보번호");
				String m_name = rsMember.getString("성명");
				String p_code = rsMember.getString("소속정당");
				String m_city = rsMember.getString("지역구");
				String m_getVote = rsMember.getString("득표수");
				String m_per = rsMember.getString("득표율");
				
				RankingDTO dto = new RankingDTO(rank, m_no, m_name, p_code, m_city, m_getVote, m_per);
				dtoRList.add(dto);
				
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
		
		return dtoRList;
		
	}
	
	
	
	
	
}
