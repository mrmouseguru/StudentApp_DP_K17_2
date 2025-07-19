package vn.edu.giadinh.business;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import vn.edu.giadinh.StudentListViewDAO;
import vn.edu.giadinh.StudentListViewUI;

public class StudentListViewUseCase {
	private StudentListViewDAO studentListViewDAO;
	private StudentListViewUI studentListViewUI;
	
	
	public StudentListViewUseCase(StudentListViewDAO studentListViewDAO, 
			StudentListViewUI studentListViewUI) {
		this.studentListViewDAO = studentListViewDAO;
		this.studentListViewUI = studentListViewUI;
	}


	public void execute() {
		List<Student> list = null;
		try {
			list = studentListViewDAO.getAll();
			studentListViewUI.showList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
