package ozyegin.schoolapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ozyegin.schoolapp.dto.StudentDTO;
import ozyegin.schoolapp.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

	@Mapping(source = "department", target = "program")
	@Mapping(source = "name", target = "fullName")
	@Mapping(source = "id", target = "studentId")
    StudentDTO studentToDTO(Student student); 
	
}



