package com.cafeconpalito.jpa;

import com.cafeconpalito.jpa.services.LaboratorioService;
import com.cafeconpalito.jpa.services.MedicamentoService;
import com.cafeconpalito.jpa.services.PersonaService;
import com.cafeconpalito.jpa.services.TratamientoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JpaApplication {

    public static void main(String[] args) {
        
        //Made by Cafe Con Palito®
        //with love ♡");
        
        ApplicationContext context = SpringApplication.run(JpaApplication.class, args);

        MedicamentoService ms = new MedicamentoService(context);
        LaboratorioService ls = new LaboratorioService(context);
        PersonaService ps = new PersonaService(context);
        TratamientoService ts = new TratamientoService(context);

        System.out.println("\nConsulta A");
        ms.allMedicamento();

        System.out.println("\nConsulta B");
        ps.findByID(1);

        System.out.println("\nConsulta C");
        ps.findAllWhitTreatment();

        System.out.println("\nConsulta D");
        ms.findByPersonID(1);

        System.out.println("\nConsulta E");
        ls.laboratoriesWhitStock();

        System.out.println("\nConsulta F");
        ts.addTratamiento(2, 20); //IDS DE MEDICAMENTO 10 - 20 - 30

    }

}
