package ertu.app.recordModify.kafka;

import ertu.app.recordModify.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	
	@KafkaListener(topics = "topic10",containerFactory = "kafkaListenerContainerFactory")
	public void consume(Employee employee){
		System.out.println("Coming : " + employee.toString());
	}
	
}
