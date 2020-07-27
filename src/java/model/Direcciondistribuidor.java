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
@Table(name = "direcciondistribuidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcciondistribuidor.findAll", query = "SELECT d FROM Direcciondistribuidor d")
    , @NamedQuery(name = "Direcciondistribuidor.findByCodDireccion", query = "SELECT d FROM Direcciondistribuidor d WHERE d.codDireccion = :codDireccion")
    , @NamedQuery(name = "Direcciondistribuidor.findByCalle", query = "SELECT d FROM Direcciondistribuidor d WHERE d.calle = :calle")
    , @NamedQuery(name = "Direcciondistribuidor.findByNumero", query = "SELECT d FROM Direcciondistribuidor d WHERE d.numero = :numero")})
public class Direcciondistribuidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codDireccion")
    private Integer codDireccion;
    @Size(max = 50)
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @JoinColumn(name = "idDistribuidor", referencedColumnName = "idDistribuidor")
    @ManyToOne(optional = false)
    private Distribuidor idDistribuidor;

    public Direcciondistribuidor() {
    }

    public Direcciondistribuidor(Integer codDireccion) {
        this.codDireccion = codDireccion;
    }

    public Integer getCodDireccion() {
        return codDireccion;
    }

    public void setCodDireccion(Integer codDireccion) {
        this.codDireccion = codDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Distribuidor getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(Distribuidor idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDireccion != null ? codDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciondistribuidor)) {
            return false;
        }
        Direcciondistribuidor other = (Direcciondistribuidor) object;
        if ((this.codDireccion == null && other.codDireccion != null) || (this.codDireccion != null && !this.codDireccion.equals(other.codDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Direcciondistribuidor[ codDireccion=" + codDireccion + " ]";
    }
    
}
