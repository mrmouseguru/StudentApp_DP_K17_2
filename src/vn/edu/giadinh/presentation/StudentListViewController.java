package vn.edu.giadinh.presentation;

import java.util.List;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.business.StudentViewItem;
import vn.edu.giadinh.business.StudentViewModel;

public class StudentListViewController {
	private StudentViewModel model;
	private StudentListViewUseCase listViewUseCase;
	private StudentListViewUI listViewUI;
	
	
	
	public StudentListViewController(StudentViewModel model, StudentListViewUseCase listViewUseCase,
			StudentListViewUI listViewUI) {
		super();
		this.model = model;
		this.listViewUseCase = listViewUseCase;
		this.listViewUI = listViewUI;
	}



	public void execute() {
		//model.?????()
		//gửi thông điệp đến StudentListViewUseCase
		List<StudentViewItem> newList = listViewUseCase.execute();
		model.listItem = newList;//gửi thông điệp cho model
		//
		listViewUI.showList(model);
		
		
	}

}
