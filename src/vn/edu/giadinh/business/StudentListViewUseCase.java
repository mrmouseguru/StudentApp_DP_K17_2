package vn.edu.giadinh.business;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.persistence.StudentDTO;
import vn.edu.giadinh.persistence.StudentListViewDAO;
import vn.edu.giadinh.presentation.StudentListViewUI;

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
		List<StudentDTO> listDTO = null;
		StudentViewModel viewModel = null;
		try {
			listDTO = studentListViewDAO.getAll();//chỉ chưa thông tin và điểm
			//không chứa business rules
			//chuyển dto student => student business rules
			list = this.convertToBusinessObjects(listDTO);
			//chuyển student business rule => ViewModel
			viewModel = this.convertToViewModel(list);
			
			studentListViewUI.showList(viewModel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private List<Student> convertToBusinessObjects(List<StudentDTO> dtos) {
		List<Student> students = new ArrayList<>();
		for (StudentDTO dto : dtos) {
			if ("Software".equalsIgnoreCase(dto.major)) {
				students.add(new SoftwareStudent(
					dto.id, dto.name, dto.birthDate,
					dto.javaScore != null ? dto.javaScore : 0,
					dto.htmlScore != null ? dto.htmlScore : 0,
					dto.cssScore != null ? dto.cssScore : 0
				));
			} else if ("Economics".equalsIgnoreCase(dto.major)) {
				students.add(new EconomicsStudent(
					dto.id, dto.name, dto.birthDate,
					dto.marketingScore != null ? dto.marketingScore : 0,
					dto.salesScore != null ? dto.salesScore : 0
				));
			}
		}
		return students;
	}
	
	private StudentViewModel convertToViewModel(List<Student> students) {
		StudentViewModel viewModel = new StudentViewModel();
		List<StudentViewItem> listItem = new ArrayList<StudentViewItem>();
	    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

		int stt = 1;
		for (Student st : students) {
			StudentViewItem item = new StudentViewItem();
			item.stt = stt++;
			item.id = st.getId();
			item.name = st.getName();
			item.birthDate = fmt.format(st.getBirthDate());
			item.major = st.getMajor();
			item.gpa = String.format("%.2f", st.calculateGPA());
			item.academicRank = st.classifyAcademic();
			listItem.add(item);
		}
		viewModel.listItem = listItem;
		return viewModel;
	}
	
	
}
