package com.cafeconpalito.Ejemplo1Runtime;

import java.io.IOException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ejemplo1RuntimeApplication {

    public static void main(String[] args) {
        //SpringApplication.run(Ejemplo1RuntimeApplication.class, args);

        try {
            
            Runtime rt = Runtime.getRuntime();
            String  [] comando ={"calc.exe"};
            
            rt.exec(comando);

        } catch (IOException e) {
            System.err.println("IOException");
        }
    }

}
