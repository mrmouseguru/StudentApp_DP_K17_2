package vn.edu.giadinh.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDBStudentListViewDAO implements StudentListViewDAOGateway {
	Map<Integer, StudentDTO> mockDB = new HashMap<Integer, StudentDTO>();
	@Override
	public List<StudentDTO> getAll() {
		StudentDTO std1 = new StudentDTO();
		std1.id = "111";
		std1.name = "Tèo 111";
		std1.birthDate = new Date();
		std1.major = "Software";
		std1.javaScore = 5.0;
		std1.htmlScore = 5.0;
		std1.cssScore = 5.0;
		
		StudentDTO std2 = new StudentDTO();
		std2.name = "Tèo 222";
		mockDB.put(1111, std1);
		//mockDB.put(2222, std2);
		
		List<StudentDTO> list = new ArrayList<StudentDTO>(mockDB.values());
		return list;
	}

}
