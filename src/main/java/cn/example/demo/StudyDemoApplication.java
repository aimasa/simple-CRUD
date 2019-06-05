package cn.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"cn.exercise.demo"})
@SpringBootApplication
public class StudyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyDemoApplication.class, args);
	}

}
