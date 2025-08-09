package vn.edu.giadinh.presentation.OpenAddStudentForm;

import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.business.OpenAddStudentForm.OpenAddStudentFormUseCase;
import vn.edu.giadinh.business.OpenAddStudentForm.ResMajorDTO;

public class OpenAddStudentFormController {
	private OpenAddStudentFormUseCase useCase;
	private OpenAddStudentFormModel model;
	
	public OpenAddStudentFormController(OpenAddStudentFormUseCase useCase, OpenAddStudentFormModel model) {
		super();
		this.useCase = useCase;
		this.model = model;
	}
	
	public void execute() {
		List<ResMajorDTO> majorDTOs =  useCase.execute();
		
		model.listItem = this.convertToMajoritem(majorDTOs);
		model.notifySubscribers();
	}
	
	private List<MajorItem> convertToMajoritem
	(List<ResMajorDTO>  majorDTOs){
		List<MajorItem> list = new ArrayList<MajorItem>();

		for (ResMajorDTO resMajorDTO : majorDTOs) {
			MajorItem item = new MajorItem();
			item.id = String.valueOf(resMajorDTO.id);
			item.name = resMajorDTO.name;
		}
		
		return list;
	}
	
	

}
