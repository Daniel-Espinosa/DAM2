/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal;

import com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos.HashTool;
import com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos.PasswordValidator;
import com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos.SecretKeyManagerAES;

/**
 *
 * @author damt207
 */
public class PSP_Tema5_Tarea3_TrabajoFinal {

    public static void main(String[] args) {

        String pass = "1asnasd12easdDADZX1aeAS23D$";
        System.out.println(PasswordValidator.validate(pass));
       
        System.out.println(HashTool.enHexadecimal(SecretKeyManagerAES.generateKeyAES(pass, 256).getEncoded()));
        

//        File f = new File("pom.xml");
//        String absolutePath = f.getAbsolutePath();
//       
//        
//        Path p = Paths.get(absolutePath);
//        String encripName = p.getFileName().toString().replaceFirst("."+com.google.common.io.Files.getFileExtension(p.getFileName().toString()), ".rsa");
//        String encripPath = p.getParent()+FileSystems.getDefault().getSeparator()+"encripted_"+encripName;
//        p = Paths.get(encripPath);
//        
//        System.out.println(encripPath);
//        System.out.println(p);
//        
//        try {
//            InputStream is = Files.newInputStream(new File(absolutePath).toPath());
//        } catch (IOException ex) {
//            Logger.getLogger(PSP_Tema5_Tarea3_TrabajoFinal.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
