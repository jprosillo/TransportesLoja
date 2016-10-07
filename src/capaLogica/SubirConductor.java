/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaDatos.Conductor;
import capaDatos.TransporteMercancia;
import capaDatos.controllers.ConductorJpaController;
import capaDatos.controllers.TransporteMercanciaJpaController;
import capaDatos.controllers.TransportePersonasJpaController;
import capaUsuario.interfazGUI;
import com.sun.javafx.css.SubCssMetaData;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author USUARIO
 */
public class SubirConductor extends Sueldo{
  
    EntityManagerFactory loja;//Persistence.createEntityManagerFactory("TransportesLojaPU");
    ConductorJpaController cd;//new ConductorJpaController(loja);
    TransporteMercanciaJpaController tm;
    TransportePersonasJpaController tp;
    Sueldo s;

    public SubirConductor() {
        loja = Persistence.createEntityManagerFactory("TransportesLojaPU");;
        cd = new ConductorJpaController(loja);
        tm = new TransporteMercanciaJpaController(loja);
        tp = new TransportePersonasJpaController(loja);
        s=new Sueldo();
    }
    

    public void ingresarCon (int c, String n, String a, int h){
      cd.create(new Conductor(c, n, a, h,s.sueldoT));
      
    }
    
}
