package ertu.app.recordModify.kafka;

import ertu.app.recordModify.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	private static final String TOPIC_NAME ="topic10";
	private static KafkaTemplate<String, Employee> kafkaTemplate;
	public static KafkaProducerService instance;
	
	public static KafkaProducerService getInstance() {
		if (instance == null) 
			instance = new KafkaProducerService(kafkaTemplate);
		
		return instance;
	}
	
	@Autowired
	public KafkaProducerService(KafkaTemplate<String, Employee> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(Employee transactionSendEvent){
		kafkaTemplate.send(TOPIC_NAME,transactionSendEvent);
	}
}
