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
@Table(name = "telefonotrabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefonotrabajador.findAll", query = "SELECT t FROM Telefonotrabajador t")
    , @NamedQuery(name = "Telefonotrabajador.findByCodFonoTrabajador", query = "SELECT t FROM Telefonotrabajador t WHERE t.codFonoTrabajador = :codFonoTrabajador")
    , @NamedQuery(name = "Telefonotrabajador.findByNumero", query = "SELECT t FROM Telefonotrabajador t WHERE t.numero = :numero")
    , @NamedQuery(name = "Telefonotrabajador.findByIdTrabajador", query = "SELECT t FROM Telefonotrabajador t WHERE t.idTrabajador = :idTrabajador")})
public class Telefonotrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codFonoTrabajador")
    private Integer codFonoTrabajador;
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTrabajador")
    private int idTrabajador;

    public Telefonotrabajador() {
    }

    public Telefonotrabajador(Integer codFonoTrabajador) {
        this.codFonoTrabajador = codFonoTrabajador;
    }

    public Telefonotrabajador(Integer codFonoTrabajador, int idTrabajador) {
        this.codFonoTrabajador = codFonoTrabajador;
        this.idTrabajador = idTrabajador;
    }

    public Integer getCodFonoTrabajador() {
        return codFonoTrabajador;
    }

    public void setCodFonoTrabajador(Integer codFonoTrabajador) {
        this.codFonoTrabajador = codFonoTrabajador;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFonoTrabajador != null ? codFonoTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefonotrabajador)) {
            return false;
        }
        Telefonotrabajador other = (Telefonotrabajador) object;
        if ((this.codFonoTrabajador == null && other.codFonoTrabajador != null) || (this.codFonoTrabajador != null && !this.codFonoTrabajador.equals(other.codFonoTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Telefonotrabajador[ codFonoTrabajador=" + codFonoTrabajador + " ]";
    }
    
}
