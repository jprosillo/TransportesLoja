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
@Table(name = "transporte_mercancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransporteMercancia.findAll", query = "SELECT t FROM TransporteMercancia t"),
    @NamedQuery(name = "TransporteMercancia.findByIdTm", query = "SELECT t FROM TransporteMercancia t WHERE t.idTm = :idTm"),
    @NamedQuery(name = "TransporteMercancia.findByTipoMercancia", query = "SELECT t FROM TransporteMercancia t WHERE t.tipoMercancia = :tipoMercancia"),
    @NamedQuery(name = "TransporteMercancia.findByToneladas", query = "SELECT t FROM TransporteMercancia t WHERE t.toneladas = :toneladas")})
public class TransporteMercancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tm")
    private Integer idTm;
    @Basic(optional = false)
    @Column(name = "tipo_mercancia")
    private String tipoMercancia;
    @Basic(optional = false)
    @Column(name = "toneladas")
    private int toneladas;

    public TransporteMercancia() {
    }

    public TransporteMercancia(Integer idTm) {
        this.idTm = idTm;
    }

    public TransporteMercancia(Integer idTm, String tipoMercancia, int toneladas) {
        this.idTm = idTm;
        this.tipoMercancia = tipoMercancia;
        this.toneladas = toneladas;
    }
    public TransporteMercancia(String tipoMercancia, int toneladas) {
        this.idTm = idTm;
        this.tipoMercancia = tipoMercancia;
        this.toneladas = toneladas;
    }
   

    public Integer getIdTm() {
        return idTm;
    }

    public void setIdTm(Integer idTm) {
        this.idTm = idTm;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }

    public int getToneladas() {
        return toneladas;
    }

    public void setToneladas(int toneladas) {
        this.toneladas = toneladas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTm != null ? idTm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransporteMercancia)) {
            return false;
        }
        TransporteMercancia other = (TransporteMercancia) object;
        if ((this.idTm == null && other.idTm != null) || (this.idTm != null && !this.idTm.equals(other.idTm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capaDatos.TransporteMercancia[ idTm=" + idTm + " ]";
    }
    
}
