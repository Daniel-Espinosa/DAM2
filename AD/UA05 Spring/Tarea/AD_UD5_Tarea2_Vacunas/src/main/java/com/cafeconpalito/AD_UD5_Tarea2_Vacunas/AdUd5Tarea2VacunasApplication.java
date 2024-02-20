package com.cafeconpalito.AD_UD5_Tarea2_Vacunas;

import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.controller.LaboratorioRestController;
import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.controller.PersonaRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AdUd5Tarea2VacunasApplication {

    public static void main(String[] args) {

        //SWAGGER para acceder a los EndPoints accede a esta URL
        
        //Made by Cafe Con Palito®
        //with love ♡
        
        //http://localhost:8080/swagger-ui/index.html
        
        ApplicationContext context = SpringApplication.run(AdUd5Tarea2VacunasApplication.class, args);

        LaboratorioRestController lrc = new LaboratorioRestController(context);
        PersonaRestController prc = new PersonaRestController(context);

    }

}
