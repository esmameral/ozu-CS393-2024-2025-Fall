package ozyegin.schoolapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ozyegin.schoolapp.dto.CourseDTO;
import ozyegin.schoolapp.service.CourseService;

@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {
	@Autowired
	CourseService courseService;
	
	
	@Operation(	summary = "Find course by courseCode", 
			description = "Returns a single course info" 
			)
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "successful operation",
	            content = @Content(schema = @Schema(implementation = CourseDTO.class)))
	    }
	)
	@RequestMapping(value="/{code}", method = RequestMethod.GET)
	public ResponseEntity<CourseDTO> getCourse(@PathVariable("code") String courseCode) {
		CourseDTO newCourse=courseService.getCourse(courseCode);
		return ResponseEntity.status(HttpStatus.FOUND).body(newCourse);
	}
	
	@GetMapping
	public List<CourseDTO> getCourses() {
		return courseService.getCourses();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary = "Creates a new course", 
		description = "Save new course's info into database")
	public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) {
		return courseService.saveCourse(courseDTO);
	}
	
	
	
}
