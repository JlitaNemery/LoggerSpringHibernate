package logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Program {

	public static void main(String[] args) {
		SpringApplication.run(Program.class);
		
		System.out.println("Listening...");
	}
}
