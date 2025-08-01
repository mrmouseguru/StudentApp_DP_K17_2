package vn.edu.giadinh.presentation;

import java.util.List;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.business.StudentViewItem;
import vn.edu.giadinh.business.StudentViewModel;

public class StudentListViewController {
	private StudentViewModel model;
	private StudentListViewUseCase listViewUseCase;
	
	
	
	public StudentListViewController(StudentViewModel model, 
			StudentListViewUseCase listViewUseCase
			) {
		this.model = model;
		this.listViewUseCase = listViewUseCase;
	}



	public void execute() {
		//model.?????()
		//gửi thông điệp đến StudentListViewUseCase
		List<StudentViewItem> newList = listViewUseCase.execute();
		model.listItem = newList;//gửi thông điệp cho model
		//vi phạm mvc
		//listViewUI.showList(model);
		//notify đến subscribers
		model.notifySubscribers();
		
		
	}

}
