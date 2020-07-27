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
@Table(name = "trabajadorcliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajadorcliente.findAll", query = "SELECT t FROM Trabajadorcliente t")
    , @NamedQuery(name = "Trabajadorcliente.findByIdTrabajador", query = "SELECT t FROM Trabajadorcliente t WHERE t.idTrabajador = :idTrabajador")
    , @NamedQuery(name = "Trabajadorcliente.findByIdCliente", query = "SELECT t FROM Trabajadorcliente t WHERE t.idCliente = :idCliente")
    , @NamedQuery(name = "Trabajadorcliente.findByCodTrabajadorCliente", query = "SELECT t FROM Trabajadorcliente t WHERE t.codTrabajadorCliente = :codTrabajadorCliente")})
public class Trabajadorcliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTrabajador")
    private int idTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private int idCliente;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codTrabajadorCliente")
    private Integer codTrabajadorCliente;

    public Trabajadorcliente() {
    }

    public Trabajadorcliente(Integer codTrabajadorCliente) {
        this.codTrabajadorCliente = codTrabajadorCliente;
    }

    public Trabajadorcliente(Integer codTrabajadorCliente, int idTrabajador, int idCliente) {
        this.codTrabajadorCliente = codTrabajadorCliente;
        this.idTrabajador = idTrabajador;
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getCodTrabajadorCliente() {
        return codTrabajadorCliente;
    }

    public void setCodTrabajadorCliente(Integer codTrabajadorCliente) {
        this.codTrabajadorCliente = codTrabajadorCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTrabajadorCliente != null ? codTrabajadorCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajadorcliente)) {
            return false;
        }
        Trabajadorcliente other = (Trabajadorcliente) object;
        if ((this.codTrabajadorCliente == null && other.codTrabajadorCliente != null) || (this.codTrabajadorCliente != null && !this.codTrabajadorCliente.equals(other.codTrabajadorCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Trabajadorcliente[ codTrabajadorCliente=" + codTrabajadorCliente + " ]";
    }
    
}
