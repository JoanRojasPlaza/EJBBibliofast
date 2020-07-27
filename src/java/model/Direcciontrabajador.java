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
@Table(name = "direcciontrabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcciontrabajador.findAll", query = "SELECT d FROM Direcciontrabajador d")
    , @NamedQuery(name = "Direcciontrabajador.findByCodDireccionTrabajador", query = "SELECT d FROM Direcciontrabajador d WHERE d.codDireccionTrabajador = :codDireccionTrabajador")
    , @NamedQuery(name = "Direcciontrabajador.findByNumero", query = "SELECT d FROM Direcciontrabajador d WHERE d.numero = :numero")
    , @NamedQuery(name = "Direcciontrabajador.findByCalle", query = "SELECT d FROM Direcciontrabajador d WHERE d.calle = :calle")})
public class Direcciontrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codDireccionTrabajador")
    private Integer codDireccionTrabajador;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 50)
    @Column(name = "calle")
    private String calle;
    @JoinColumn(name = "idTrabajador", referencedColumnName = "idTrabajador")
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public Direcciontrabajador() {
    }

    public Direcciontrabajador(Integer codDireccionTrabajador) {
        this.codDireccionTrabajador = codDireccionTrabajador;
    }

    public Integer getCodDireccionTrabajador() {
        return codDireccionTrabajador;
    }

    public void setCodDireccionTrabajador(Integer codDireccionTrabajador) {
        this.codDireccionTrabajador = codDireccionTrabajador;
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

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDireccionTrabajador != null ? codDireccionTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciontrabajador)) {
            return false;
        }
        Direcciontrabajador other = (Direcciontrabajador) object;
        if ((this.codDireccionTrabajador == null && other.codDireccionTrabajador != null) || (this.codDireccionTrabajador != null && !this.codDireccionTrabajador.equals(other.codDireccionTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Direcciontrabajador[ codDireccionTrabajador=" + codDireccionTrabajador + " ]";
    }
    
}
