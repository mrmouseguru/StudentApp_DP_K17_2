package vn.edu.giadinh;

import java.sql.SQLException;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.persistence.MockDBStudentListViewDAO;
import vn.edu.giadinh.persistence.MySQLStudentListViewDAO;
import vn.edu.giadinh.presentation.StudentListViewController;
import vn.edu.giadinh.presentation.StudentListViewUI;
import vn.edu.giadinh.presentation.StudentViewModel;

public class AppStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentListViewUI listViewUI = new StudentListViewUI();
		MySQLStudentListViewDAO listViewDAO = null;
		MockDBStudentListViewDAO mockDBStudentListViewDAO;
		StudentListViewUseCase listViewUseCase = null;
		StudentListViewController listViewController = null;
		StudentViewModel model = new StudentViewModel();
		listViewUI.setViewModel(model);
		try {
			
			listViewDAO = new MySQLStudentListViewDAO();
			mockDBStudentListViewDAO = new MockDBStudentListViewDAO();
			listViewUseCase = new StudentListViewUseCase(mockDBStudentListViewDAO);
			
			listViewController = new StudentListViewController(model, 
					listViewUseCase);
			listViewController.execute();
			listViewUI.setVisible(true);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listViewUI.setVisible(true);
		///listViewUI.showList(null);
	}

}
