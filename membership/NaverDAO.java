package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.db.DBConn;

public class NaverDAO {
	
	// 아이디 중복 체크
	

	
	
	
	
	
	// insert
	public int insertData(NaverDTO dto){
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = "insert into NaverMember(id,pw,name,gender,birth,email,tel,address,nick)";
			sql += "values (?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getTel());
			pstmt.setString(8, dto.getAddress());
			pstmt.setString(9, dto.getNick());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//업데이트
	public int updateData(NaverDTO dto) {
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = "update naverMember set pw=?, email=?, tel=? ,address=?, nick=?";
			sql+= "where id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getNick());
			pstmt.setString(6, dto.getId());

			result = pstmt.executeUpdate();
			
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
		}
	
	// 삭제
	public int deleteDate(String id, String pw) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = "delete naverMember where id=? and pw=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			result = pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
		}
	
	// select
	
	public List<NaverDTO> getList() {
		List<NaverDTO> lists = new ArrayList<NaverDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql = "select id,pw,name,gender,birth,email,tel,address,nick ";
			sql+= "from NAVERMEMBER order by name";
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()){
				NaverDTO dto = new NaverDTO();

				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setNick(rs.getString("nick"));
			
				lists.add(dto);
		}
		rs.close();
		pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}
	
	// 아이디 검색
public List<NaverDTO> getList(String id){

		List<NaverDTO> lists = new ArrayList<NaverDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try{
			sql = "select id,pw,name,gender,birth,email,tel,address,nick ";
			sql+= "from NAVERMEMBER where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				NaverDTO dto = new NaverDTO();

				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setNick(rs.getString("nick"));

				lists.add(dto);
					
			}
			rs.close();
			pstmt.close();

		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}
}
	

