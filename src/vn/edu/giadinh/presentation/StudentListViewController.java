package vn.edu.giadinh.presentation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.business.StudentViewDTO;

public class StudentListViewController {
	private StudentViewModel model;
	private StudentListViewUseCase listViewUseCase;

	public StudentListViewController(StudentViewModel model, StudentListViewUseCase listViewUseCase) {
		this.model = model;
		this.listViewUseCase = listViewUseCase;
	}

	public void execute() {
		// model.?????()
		// gửi thông điệp đến StudentListViewUseCase
		List<StudentViewDTO> newList = listViewUseCase.execute();

		// convert DTO sang ViewItem (Present)
		List<StudentViewItem> listPresent = this.convertToPresent(newList);

		model.listItem = listPresent;// gửi thông điệp cho model
		// vi phạm mvc
		// listViewUI.showList(model);
		// notify đến subscribers
		model.notifySubscribers();

	}

	private List<StudentViewItem> convertToPresent(List<StudentViewDTO> listDTO) {
		List<StudentViewItem> list = new ArrayList<StudentViewItem>();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		int stt = 1;
		for (StudentViewDTO dto : listDTO) {
			StudentViewItem item = new StudentViewItem();
			item.stt = stt++;
			item.id = dto.id;
			item.name = dto.name;
			item.birthDate = fmt.format(dto.birthDate);
			item.major = dto.major;
			item.gpa = String.format("%.2f", dto.gpa);
			item.academicRank = dto.academicRank;
			list.add(item);
		}

		return list;

	}

}
