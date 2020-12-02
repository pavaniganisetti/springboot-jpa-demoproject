package springboot.javabrains.jpa.tutorial.course;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.javabrains.jpa.tutorial.topic.Topic;

@RestController //spring mvc annotation
public class CourseController {

	@Autowired //declares as it needs Dependency injection
	private CourseService courseService; //private member variable
	
	@RequestMapping("/topics/{id}/courses") //spring mvc annotation
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(value ="/topics/{topicId}/courses",method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(value ="/topics/{topicId}/courses/{id}",method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(value ="/topics/{topicId}/courses/{id}",method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
}
