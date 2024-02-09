package com.cafeconpalito.JDBC;

import com.cafeconpalito.JDBC.entity.Empleado;
import com.cafeconpalito.JDBC.repository.IEmpleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class JdbcApplication {

    @Autowired
    private IEmpleado empleadodao;

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @EventListener ({ApplicationReadyEvent.class})
    public void pruebaConsultas( ){
    
        try{
           List<Empleado> lista = (List<Empleado>) empleadodao.findAll();
            for (Empleado e : lista) {
                System.out.println(e.getPkempleado() + "-" + e.getNombre() + "-" + e.getNombre());
            }
        }catch (IllegalArgumentException ex){
            System.err.println("Error: " + ex.getMessage() );
        }
        
        System.exit(0);
    }

}
