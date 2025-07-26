package vn.edu.giadinh;

import java.sql.SQLException;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.business.StudentViewModel;
import vn.edu.giadinh.persistence.StudentListViewDAO;
import vn.edu.giadinh.presentation.StudentListViewController;
import vn.edu.giadinh.presentation.StudentListViewUI;

public class AppStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentListViewUI listViewUI = new StudentListViewUI();
		StudentListViewDAO listViewDAO = null;
		StudentListViewUseCase listViewUseCase = null;
		StudentListViewController listViewController = null;
		StudentViewModel model = new StudentViewModel();
		try {
			
			listViewDAO = new StudentListViewDAO();
			listViewUseCase = new StudentListViewUseCase(listViewDAO);
			
			listViewController = new StudentListViewController(model, 
					listViewUseCase,
					listViewUI);
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
