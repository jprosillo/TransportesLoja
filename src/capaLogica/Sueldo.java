/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaDatos.Conductor;
import capaDatos.controllers.ConductorJpaController;
import capaDatos.controllers.TransporteMercanciaJpaController;
import capaDatos.controllers.TransportePersonasJpaController;
import capaUsuario.interfazGUI;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
public class Sueldo {
    
    EntityManagerFactory loja;
    ConductorJpaController cd;//new ConductorJpaController(loja);
    TransporteMercanciaJpaController tm;
    TransportePersonasJpaController tp;
    int sueldoT;
    
    public Sueldo() {
        loja = Persistence.createEntityManagerFactory("TransportesLojaPU");;
        cd = new ConductorJpaController(loja);
        tm = new TransporteMercanciaJpaController(loja);
        tp = new TransportePersonasJpaController(loja);
        sueldoT=420;
         
    }

    public Sueldo(int sueldoT) {
        this.sueldoT = sueldoT;
    }

    public int getSueldoT() {
        return sueldoT;
    }

    public void setSueldoT(int sueldoT) {
        this.sueldoT = sueldoT;
    }
    
    
    public List presentarS(){   
        return cd.findConductorEntities(true,1,2);
    }  
    
    public List<String> sueldos(){
       List<Conductor> conductores = cd.findConductorEntities();
       List <String>datos=new ArrayList<>();
        for (Conductor e : conductores) {
             datos.add("\t"+e.getCNombres()+"\t"+e.getCApellido()+"\t"+e.getSueldo()+"\n");
        }
        return datos;
    }
    public int calcularSueldo(int h, String tmercaderia, int np){
        //Transporte persona
        SubirTransporte st=new SubirTransporte();
       if(np>9){
           sueldoT=sueldoT+(h*10);
           System.out.println(sueldoT);
           setSueldoT(sueldoT);
       } 
       else{
           sueldoT=sueldoT+(h*5);
           System.out.println(sueldoT);
           setSueldoT(sueldoT);
       }
       return sueldoT;
    }
}
