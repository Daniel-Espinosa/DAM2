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
        ApplicationContext context = SpringApplication.run(JpaApplication.class, args);

        MedicamentoService ms = new MedicamentoService(context);
        LaboratorioService ls = new LaboratorioService(context);
        PersonaService ps = new PersonaService(context);
        TratamientoService ts = new TratamientoService(context);

        System.out.println("\nConsulta 1");
        ms.allMedicamento();

        System.out.println("\nConsulta 2");
        ps.findByID(1);

        System.out.println("\nConsulta 3");
        ps.findAllWhitTreatment();

        System.out.println("\nConsulta 4");
        ms.findByPersonID(1);

        System.out.println("\nConsulta 5");
        ls.laboratoriesWhitStock();

        System.out.println("\nConsulta 6");
        ts.addTratamiento(2, 20); //IDS DE MEDICAMENTO 10 - 20 - 30

    }

}
