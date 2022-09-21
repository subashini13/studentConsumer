package com.microservices.studentConsumer;

import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservices.student.Student;
/**
 * Consumes the messages on topic student-detail. topic details configured in application.properties
 * @author User
 *
 */
@Configuration
public class StudentKafkaConsumer {
	
	
	@Bean
	public Consumer<KStream<Integer,Student>>  consumeStudentDetails(){
		
		return kstream -> kstream.foreach((key,student) -> {
			System.out.println(String.format("Message Received [%s] [%s]", key,student.getName()));
		});
		
	}

}
