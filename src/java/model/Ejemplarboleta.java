/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "ejemplarboleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejemplarboleta.findAll", query = "SELECT e FROM Ejemplarboleta e")
    , @NamedQuery(name = "Ejemplarboleta.findByNumEjemplar", query = "SELECT e FROM Ejemplarboleta e WHERE e.numEjemplar = :numEjemplar")
    , @NamedQuery(name = "Ejemplarboleta.findByDefault1", query = "SELECT e FROM Ejemplarboleta e WHERE e.default1 = :default1")
    , @NamedQuery(name = "Ejemplarboleta.findByCodEjemplarBoleta", query = "SELECT e FROM Ejemplarboleta e WHERE e.codEjemplarBoleta = :codEjemplarBoleta")
    , @NamedQuery(name = "Ejemplarboleta.findByCodBoleta", query = "SELECT e FROM Ejemplarboleta e WHERE e.codBoleta = :codBoleta")})
public class Ejemplarboleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numEjemplar")
    private int numEjemplar;
    @Size(max = 18)
    @Column(name = "_default_")
    private String default1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codEjemplarBoleta")
    private Integer codEjemplarBoleta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codBoleta")
    private int codBoleta;

    public Ejemplarboleta() {
    }

    public Ejemplarboleta(Integer codEjemplarBoleta) {
        this.codEjemplarBoleta = codEjemplarBoleta;
    }

    public Ejemplarboleta(Integer codEjemplarBoleta, int numEjemplar, int codBoleta) {
        this.codEjemplarBoleta = codEjemplarBoleta;
        this.numEjemplar = numEjemplar;
        this.codBoleta = codBoleta;
    }

    public int getNumEjemplar() {
        return numEjemplar;
    }

    public void setNumEjemplar(int numEjemplar) {
        this.numEjemplar = numEjemplar;
    }

    public String getDefault1() {
        return default1;
    }

    public void setDefault1(String default1) {
        this.default1 = default1;
    }

    public Integer getCodEjemplarBoleta() {
        return codEjemplarBoleta;
    }

    public void setCodEjemplarBoleta(Integer codEjemplarBoleta) {
        this.codEjemplarBoleta = codEjemplarBoleta;
    }

    public int getCodBoleta() {
        return codBoleta;
    }

    public void setCodBoleta(int codBoleta) {
        this.codBoleta = codBoleta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEjemplarBoleta != null ? codEjemplarBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejemplarboleta)) {
            return false;
        }
        Ejemplarboleta other = (Ejemplarboleta) object;
        if ((this.codEjemplarBoleta == null && other.codEjemplarBoleta != null) || (this.codEjemplarBoleta != null && !this.codEjemplarBoleta.equals(other.codEjemplarBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ejemplarboleta[ codEjemplarBoleta=" + codEjemplarBoleta + " ]";
    }
    
}
