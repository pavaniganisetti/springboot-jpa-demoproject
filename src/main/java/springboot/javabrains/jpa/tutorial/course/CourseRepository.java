package springboot.javabrains.jpa.tutorial.course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	//1st arg:entity class 2nd: id type 
	/*
	 * most of the time crud operations are all same. like getAllTopics(),
	 * getTopic(String id), addTopic(String id), deleteTopic(string id) 
	 * So spring data jpa team created these king of standard methods.
	 * so we don't need to implement it. So you just need a interface
	 * which uses spring data jpa and provides a class.
	 * One common repository is CrudRepository.
	 */
}
