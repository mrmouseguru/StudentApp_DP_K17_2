package vn.edu.giadinh.business.OpenAddStudentForm;

import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.persistence.OpenAddStudentForm.MajorDTO;
import vn.edu.giadinh.persistence.OpenAddStudentForm.OpenAddStudentFormGateway;

public class OpenAddStudentFormUseCase {
	private OpenAddStudentFormGateway gateway;

	public OpenAddStudentFormUseCase(OpenAddStudentFormGateway gateway) {
		super();
		this.gateway = gateway;
	}
	
	public List<ResMajorDTO> execute() {
		List<MajorDTO> listDTO = null;
		listDTO = gateway.getAll();
		
		return convertToResMajorDTO(listDTO);
		
	}

	private List<ResMajorDTO> convertToResMajorDTO(List<MajorDTO> listDTO) {
		// TODO Auto-generated method stub
		List<ResMajorDTO> list = new ArrayList<ResMajorDTO>();
		for (MajorDTO majorDTO : listDTO) {
			ResMajorDTO resDTO = new ResMajorDTO();
			resDTO.id = majorDTO.id;
			resDTO.name = majorDTO.name;
			resDTO.description = majorDTO.description;
			
			list.add(resDTO);
			
		}
		
		return list;
	}
	

}
