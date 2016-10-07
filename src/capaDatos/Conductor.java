/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDatos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "conductor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c"),
    @NamedQuery(name = "Conductor.findByCId", query = "SELECT c FROM Conductor c WHERE c.cId = :cId"),
    @NamedQuery(name = "Conductor.findByCCedula", query = "SELECT c FROM Conductor c WHERE c.cCedula = :cCedula"),
    @NamedQuery(name = "Conductor.findByCHoras", query = "SELECT c FROM Conductor c WHERE c.cHoras = :cHoras"),
    @NamedQuery(name = "Conductor.findBySueldo", query = "SELECT c FROM Conductor c WHERE c.sueldo = :sueldo")})
public class Conductor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_id")
    private Integer cId;
    @Basic(optional = false)
    @Column(name = "c_cedula")
    private int cCedula;
    @Basic(optional = false)
    @Lob
    @Column(name = "c_nombres")
    private String cNombres;
    @Basic(optional = false)
    @Lob
    @Column(name = "c_apellido")
    private String cApellido;
    @Basic(optional = false)
    @Column(name = "c_horas")
    private int cHoras;
    @Basic(optional = false)
    @Column(name = "sueldo")
    private int sueldo;

    public Conductor() {
    }

    public Conductor(Integer cId) {
        this.cId = cId;
    }

    public Conductor(Integer cId, int cCedula, String cNombres, String cApellido, int cHoras, int sueldo) {
        this.cId = cId;
        this.cCedula = cCedula;
        this.cNombres = cNombres;
        this.cApellido = cApellido;
        this.cHoras = cHoras;
        this.sueldo = sueldo;
    }
    
        public Conductor(int cCedula, String cNombres, String cApellido, int cHoras, int sueldo) {
        this.cId = cId;
        this.cCedula = cCedula;
        this.cNombres = cNombres;
        this.cApellido = cApellido;
        this.cHoras = cHoras;
        this.sueldo = sueldo;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public int getCCedula() {
        return cCedula;
    }

    public void setCCedula(int cCedula) {
        this.cCedula = cCedula;
    }

    public String getCNombres() {
        return cNombres;
    }

    public void setCNombres(String cNombres) {
        this.cNombres = cNombres;
    }

    public String getCApellido() {
        return cApellido;
    }

    public void setCApellido(String cApellido) {
        this.cApellido = cApellido;
    }

    public int getCHoras() {
        return cHoras;
    }

    public void setCHoras(int cHoras) {
        this.cHoras = cHoras;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capaDatos.Conductor[ cId=" + cId + " ]";
    }
    
}
