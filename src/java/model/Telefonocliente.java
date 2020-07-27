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
@Table(name = "telefonocliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefonocliente.findAll", query = "SELECT t FROM Telefonocliente t")
    , @NamedQuery(name = "Telefonocliente.findByCodTelefonoCliente", query = "SELECT t FROM Telefonocliente t WHERE t.codTelefonoCliente = :codTelefonoCliente")
    , @NamedQuery(name = "Telefonocliente.findByNumeroCliente", query = "SELECT t FROM Telefonocliente t WHERE t.numeroCliente = :numeroCliente")
    , @NamedQuery(name = "Telefonocliente.findByIdCliente", query = "SELECT t FROM Telefonocliente t WHERE t.idCliente = :idCliente")})
public class Telefonocliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codTelefonoCliente")
    private Integer codTelefonoCliente;
    @Column(name = "numeroCliente")
    private Integer numeroCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private int idCliente;

    public Telefonocliente() {
    }

    public Telefonocliente(Integer codTelefonoCliente) {
        this.codTelefonoCliente = codTelefonoCliente;
    }

    public Telefonocliente(Integer codTelefonoCliente, int idCliente) {
        this.codTelefonoCliente = codTelefonoCliente;
        this.idCliente = idCliente;
    }

    public Integer getCodTelefonoCliente() {
        return codTelefonoCliente;
    }

    public void setCodTelefonoCliente(Integer codTelefonoCliente) {
        this.codTelefonoCliente = codTelefonoCliente;
    }

    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTelefonoCliente != null ? codTelefonoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefonocliente)) {
            return false;
        }
        Telefonocliente other = (Telefonocliente) object;
        if ((this.codTelefonoCliente == null && other.codTelefonoCliente != null) || (this.codTelefonoCliente != null && !this.codTelefonoCliente.equals(other.codTelefonoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Telefonocliente[ codTelefonoCliente=" + codTelefonoCliente + " ]";
    }
    
}
