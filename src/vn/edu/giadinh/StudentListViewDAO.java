package vn.edu.giadinh;

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

public class StudentListViewDAO {
	
	private Connection conn;
	
	public StudentListViewDAO() throws ClassNotFoundException, SQLException {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		String username = "root";
		String password = "12345678";
		String url = "jdbc:mysql://localhost:3306/students?useSSL=false&serverTimezone=UTC";
		conn = DriverManager.getConnection(url, username, password);
		System.out.println("Connected!!!");
	}
	
	public List<Student> getAll() throws SQLException, ParseException{
		List<Student> list = new ArrayList<Student>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select id, name, birthday, major, javaScore,"
		+ "htmlScore, cssScore, marketing, salesScore "
		+ "from student";
		//tạo đối tượng statement để thực thi câu query trong java
		stmt = conn.createStatement();
		//thực thi câu query
		rs = stmt.executeQuery(sql);
		
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

		//duyệt từng sv trong rs
		while(rs.next()) {
			String id = rs.getString("id");
            String name = rs.getString("name");
            Date dob = fmt.parse(rs.getString("birthday"));
            String major = rs.getString("major");
            
            //
            Student s = null;
            if ("Software".equalsIgnoreCase(major)) {
                double j = rs.getDouble("javaScore");
                double h = rs.getDouble("htmlScore");
                double c = rs.getDouble("cssScore");
                s = new SoftwareStudent(id, name, dob, j, h, c);
                
            } else if ("Economics".equalsIgnoreCase(major)) {
                double m = rs.getDouble("marketing");
                double sa = rs.getDouble("salesScore");
                s = new EconomicsStudent(id, name, dob, m, sa);
            }
            
            list.add(s);
		}
		rs.close();
		stmt.close();
		conn.close();
		return list;
	}
	
	public static void main(String[] args) {
		try {
			new StudentListViewDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
