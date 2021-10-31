package ertu.app.recordModify;

import ertu.app.recordModify.kafka.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(path = "/") 
public class EmployeeController {
	
	@Autowired	
	private EmployeeRepository employeeRepository;
	
	@PostMapping(path = "/add") 
	public @ResponseBody
	String addNewEmployee(@RequestBody Employee employee) {
		
		employeeRepository.save(employee);
		KafkaProducerService.getInstance().send(employee);
		return "Saved";
	}
	
	@PostMapping(path = "/delete")
	public @ResponseBody
	String deleteEmployee(@RequestBody Employee employee) {
		
		employeeRepository.delete(employee);
		return "Deleted";
	}
	
	@PostMapping(path = "/update") // Map ONLY POST Requests
	public @ResponseBody
	String updateNewEmployee(@RequestBody Employee employee) {
		
		employeeRepository.save(employee);
		return "Updated";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<Employee> getAllEmployees() {
		// This returns a JSON or XML with the users
		return employeeRepository.findAll();
	}
}
