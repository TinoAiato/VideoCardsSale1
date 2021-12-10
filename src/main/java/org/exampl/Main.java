package org.exampl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        //       final NvidiaJdbc jdbc = new NvidiaJdbc("jdbc:postgresql://localhost:5432/db?user=app&password=pass");
        SpringApplication.run(Main.class, args);
    }
}

