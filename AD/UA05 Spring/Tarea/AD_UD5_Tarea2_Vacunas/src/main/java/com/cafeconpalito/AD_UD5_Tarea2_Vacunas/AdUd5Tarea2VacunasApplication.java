package com.cafeconpalito.AD_UD5_Tarea2_Vacunas;

import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.services.LaboratorioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AdUd5Tarea2VacunasApplication {

	public static void main(String[] args) {
                ApplicationContext context = SpringApplication.run(AdUd5Tarea2VacunasApplication.class, args);
                
                LaboratorioService ls = new LaboratorioService(context);
                ls.allLaboratorio();
	}

}
