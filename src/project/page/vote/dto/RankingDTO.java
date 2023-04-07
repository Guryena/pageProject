package project.page.vote.dto;

public class RankingDTO {
	private String rank;
	private String m_no;
	private String m_name;
	private String p_code;
	private String m_city;
	private String m_getVote;
	private String m_per;
	
	public RankingDTO(String rank, String m_no, String m_name, String p_code, String m_city, String m_getVote, String m_per) {
		this.rank = rank;
		this.m_no = m_no;
		this.m_name = m_name;
		this.p_code = p_code;
		this.m_city = m_city;
		this.m_getVote = m_getVote;
		this.m_per = m_per;
		
	}

	public String getRank() {
		return rank;
	}

	public void setRanking(String rank) {
		this.rank = rank;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getM_city() {
		return m_city;
	}

	public void setM_city(String m_city) {
		this.m_city = m_city;
	}

	public String getM_getVote() {
		return m_getVote;
	}

	public void setM_getVote(String m_getVote) {
		this.m_getVote = m_getVote;
	}

	public String getM_per() {
		return m_per;
	}

	public void setM_per(String m_per) {
		this.m_per = m_per;
	}
	
}
