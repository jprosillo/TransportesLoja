/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaDatos.Conductor;
import capaDatos.TransporteMercancia;
import capaDatos.TransportePersonas;
import capaDatos.controllers.ConductorJpaController;
import capaDatos.controllers.TransporteMercanciaJpaController;
import capaDatos.controllers.TransportePersonasJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class SubirTransporte {

    EntityManagerFactory loja;//Persistence.createEntityManagerFactory("TransportesLojaPU");
    TransporteMercanciaJpaController tm;
    TransportePersonasJpaController tp;
    //EntityManager em = loja.createEntityManager();
    String tipot;

    public SubirTransporte() {
        loja = Persistence.createEntityManagerFactory("TransportesLojaPU");;
        tm = new TransporteMercanciaJpaController(loja);
        tp = new TransportePersonasJpaController(loja);
        tipot = null;
    }

    //Ingresará datos de trasporte
    public void ingresarT(int n, String tpp, int c, String t) {
        if (n != 0) {
            if (n > 9) {
                tpp = "Colectivo";
                tipot = tpp;
                tp.create(new TransportePersonas(tpp, n));
            } else {
                tpp = "No Colectivo";
                tp.create(new TransportePersonas(tpp, n));
                tipot = tpp;
            }
            JOptionPane.showMessageDialog(null, "Guardado Correctamente", "Advertencia", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public void carga(int t) {
        String tipo=null;
        if (t != 0) {
            if (t > 9) {
                tipo = "peligroso";
                tm.create(new TransporteMercancia(tipo,t));
            } else {
                tipo = "normal";
                tm.create(new TransporteMercancia(tipo,t));
            }
            JOptionPane.showMessageDialog(null, "Guardado Correctamente", "Advertencia", JOptionPane.INFORMATION_MESSAGE);

        }
        
        JOptionPane.showMessageDialog(null, "Guardado Correctamente", "Advertencia", JOptionPane.INFORMATION_MESSAGE);

    }

    public List<String> maqPeligrosa() {
        List<TransporteMercancia> list = tm.findTransporteMercanciaEntities();
        List<String> datos = new ArrayList<>();
        for (TransporteMercancia e : list) {
            if(e.getToneladas()>9){
            datos.add("\t"+e.getIdTm()+"\t"+e.getTipoMercancia()+"\n");
            }
        }
        return datos;
    }

    //Mostrará lista de trasporte peligroso 
//    public void mostrarTP() {
//     TypedQuery<TransporteMercancia> query=em.createNamedQuery("TransporteMercancia.findByTipoMercancia",
//             TransporteMercancia.class); 
//     List<TransporteMercancia> t=(List<TransporteMercancia>) query.getResultList();
//     
//     for (TransporteMercancia e : t) {
//         System.out.println(e);
//     }
//    }
}
