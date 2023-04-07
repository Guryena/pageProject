package project.page.vote.dao;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class VoteDoDAO {
	private DataSource dataSourece;

	public VoteDoDAO() {
		try {
			Context context = new InitialContext();
			dataSourece = (DataSource) context.lookup("java:comp/env/jdbc/oracle1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int voteDo(String v_jumin, String v_name, String m_no, String v_time, String v_area, String v_confirm) {
		
		Connection con = null;
		PreparedStatement st = null;
		int rsVote = 0;

		try {
			String voteSQL = "INSERT INTO VOTE.TBL_VOTE_202005 VALUES(?, ?, ?, ?, ?, ?)";

			con = dataSourece.getConnection();
			st = con.prepareStatement(voteSQL);
			st.setString(1, v_jumin);
			st.setString(2, v_name);
			st.setString(3, m_no);
			st.setString(4, v_time);
			st.setString(5, v_area);
			st.setString(6, v_confirm);

			rsVote = st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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

		return rsVote;

	}


}
