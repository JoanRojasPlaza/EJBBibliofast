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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "direccioncliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccioncliente.findAll", query = "SELECT d FROM Direccioncliente d")
    , @NamedQuery(name = "Direccioncliente.findByCodDireccionCliente", query = "SELECT d FROM Direccioncliente d WHERE d.codDireccionCliente = :codDireccionCliente")
    , @NamedQuery(name = "Direccioncliente.findByNumero", query = "SELECT d FROM Direccioncliente d WHERE d.numero = :numero")
    , @NamedQuery(name = "Direccioncliente.findByCalle", query = "SELECT d FROM Direccioncliente d WHERE d.calle = :calle")})
public class Direccioncliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codDireccionCliente")
    private Integer codDireccionCliente;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 50)
    @Column(name = "calle")
    private String calle;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public Direccioncliente() {
    }

    public Direccioncliente(Integer codDireccionCliente) {
        this.codDireccionCliente = codDireccionCliente;
    }

    public Integer getCodDireccionCliente() {
        return codDireccionCliente;
    }

    public void setCodDireccionCliente(Integer codDireccionCliente) {
        this.codDireccionCliente = codDireccionCliente;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDireccionCliente != null ? codDireccionCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccioncliente)) {
            return false;
        }
        Direccioncliente other = (Direccioncliente) object;
        if ((this.codDireccionCliente == null && other.codDireccionCliente != null) || (this.codDireccionCliente != null && !this.codDireccionCliente.equals(other.codDireccionCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Direccioncliente[ codDireccionCliente=" + codDireccionCliente + " ]";
    }
    
}
