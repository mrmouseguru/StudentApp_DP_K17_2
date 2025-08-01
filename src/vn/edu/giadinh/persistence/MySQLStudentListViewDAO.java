package vn.edu.giadinh.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.edu.giadinh.business.EconomicsStudent;
import vn.edu.giadinh.business.SoftwareStudent;
import vn.edu.giadinh.business.Student;

public class MySQLStudentListViewDAO implements StudentListViewDAOGateway {

	private Connection conn;

	public MySQLStudentListViewDAO() throws ClassNotFoundException, SQLException {
		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		String username = "root";
		String password = "12345678";
		String url = "jdbc:mysql://localhost:3306/students?useSSL=false&serverTimezone=UTC";
		conn = DriverManager.getConnection(url, username, password);
		System.out.println("Connected!!!");
	}

	public List<StudentDTO> getAll() {
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select id, name, birthday, major, javaScore," + "htmlScore, cssScore, marketing, salesScore "
				+ "from student";
		// tạo đối tượng statement để thực thi câu query trong java
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// thực thi câu query

		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

		// duyệt từng sv trong rs
		try {
			while (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.id = rs.getString("id");
				dto.name = rs.getString("name");
				dto.birthDate = fmt.parse(rs.getString("birthday"));
				dto.major = rs.getString("major");
				dto.javaScore = rs.getDouble("javaScore");
				dto.htmlScore = rs.getDouble("htmlScore");
				dto.cssScore = rs.getDouble("cssScore");
				dto.marketingScore = rs.getDouble("marketing");
				dto.salesScore = rs.getDouble("salesScore");
				list.add(dto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public static void main(String[] args) {
		try {
			new MySQLStudentListViewDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
