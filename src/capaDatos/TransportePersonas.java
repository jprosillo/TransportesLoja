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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "transporte_personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransportePersonas.findAll", query = "SELECT t FROM TransportePersonas t"),
    @NamedQuery(name = "TransportePersonas.findByIdTp", query = "SELECT t FROM TransportePersonas t WHERE t.idTp = :idTp"),
    @NamedQuery(name = "TransportePersonas.findByTipoTp", query = "SELECT t FROM TransportePersonas t WHERE t.tipoTp = :tipoTp"),
    @NamedQuery(name = "TransportePersonas.findByNumP", query = "SELECT t FROM TransportePersonas t WHERE t.numP = :numP"),
    @NamedQuery(name = "TransportePersonas.findByCCedula", query = "SELECT t FROM TransportePersonas t WHERE t.cCedula = :cCedula")})
public class TransportePersonas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tp")
    private Integer idTp;
    @Basic(optional = false)
    @Column(name = "tipo_tp")
    private String tipoTp;
    @Basic(optional = false)
    @Column(name = "num_p")
    private int numP;
    @Column(name = "c_cedula")
    private Integer cCedula;

    public TransportePersonas() {
    }

    public TransportePersonas(Integer idTp) {
        this.idTp = idTp;
    }

    public TransportePersonas(Integer idTp, String tipoTp, int numP) {
        this.idTp = idTp;
        this.tipoTp = tipoTp;
        this.numP = numP;
    }
    public TransportePersonas(String tipoTp, int numP) {
        this.idTp = idTp;
        this.tipoTp = tipoTp;
        this.numP = numP;
    }

    public Integer getIdTp() {
        return idTp;
    }

    public void setIdTp(Integer idTp) {
        this.idTp = idTp;
    }

    public String getTipoTp() {
        return tipoTp;
    }

    public void setTipoTp(String tipoTp) {
        this.tipoTp = tipoTp;
    }

    public int getNumP() {
        return numP;
    }

    public void setNumP(int numP) {
        this.numP = numP;
    }

    public Integer getCCedula() {
        return cCedula;
    }

    public void setCCedula(Integer cCedula) {
        this.cCedula = cCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTp != null ? idTp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransportePersonas)) {
            return false;
        }
        TransportePersonas other = (TransportePersonas) object;
        if ((this.idTp == null && other.idTp != null) || (this.idTp != null && !this.idTp.equals(other.idTp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capaDatos.TransportePersonas[ idTp=" + idTp + " ]";
    }
    
}
