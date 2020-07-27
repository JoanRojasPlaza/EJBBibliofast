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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "telefonodistribuidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefonodistribuidor.findAll", query = "SELECT t FROM Telefonodistribuidor t")
    , @NamedQuery(name = "Telefonodistribuidor.findByCodFono", query = "SELECT t FROM Telefonodistribuidor t WHERE t.codFono = :codFono")
    , @NamedQuery(name = "Telefonodistribuidor.findByNumero", query = "SELECT t FROM Telefonodistribuidor t WHERE t.numero = :numero")
    , @NamedQuery(name = "Telefonodistribuidor.findByIdDistribuidor", query = "SELECT t FROM Telefonodistribuidor t WHERE t.idDistribuidor = :idDistribuidor")})
public class Telefonodistribuidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codFono")
    private Integer codFono;
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDistribuidor")
    private int idDistribuidor;

    public Telefonodistribuidor() {
    }

    public Telefonodistribuidor(Integer codFono) {
        this.codFono = codFono;
    }

    public Telefonodistribuidor(Integer codFono, int idDistribuidor) {
        this.codFono = codFono;
        this.idDistribuidor = idDistribuidor;
    }

    public Integer getCodFono() {
        return codFono;
    }

    public void setCodFono(Integer codFono) {
        this.codFono = codFono;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFono != null ? codFono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefonodistribuidor)) {
            return false;
        }
        Telefonodistribuidor other = (Telefonodistribuidor) object;
        if ((this.codFono == null && other.codFono != null) || (this.codFono != null && !this.codFono.equals(other.codFono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Telefonodistribuidor[ codFono=" + codFono + " ]";
    }
    
}
