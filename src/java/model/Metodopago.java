/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "metodopago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metodopago.findAll", query = "SELECT m FROM Metodopago m")
    , @NamedQuery(name = "Metodopago.findByCodFormaPago", query = "SELECT m FROM Metodopago m WHERE m.codFormaPago = :codFormaPago")
    , @NamedQuery(name = "Metodopago.findByNombreFormaPago", query = "SELECT m FROM Metodopago m WHERE m.nombreFormaPago = :nombreFormaPago")})
public class Metodopago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codFormaPago")
    private Integer codFormaPago;
    @Size(max = 50)
    @Column(name = "nombreFormaPago")
    private String nombreFormaPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFormaPago")
    private List<Factura> facturaList;
    @OneToMany(mappedBy = "codFormaPago")
    private List<Boleta> boletaList;

    public Metodopago() {
    }

    public Metodopago(Integer codFormaPago) {
        this.codFormaPago = codFormaPago;
    }

    public Integer getCodFormaPago() {
        return codFormaPago;
    }

    public void setCodFormaPago(Integer codFormaPago) {
        this.codFormaPago = codFormaPago;
    }

    public String getNombreFormaPago() {
        return nombreFormaPago;
    }

    public void setNombreFormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<Boleta> getBoletaList() {
        return boletaList;
    }

    public void setBoletaList(List<Boleta> boletaList) {
        this.boletaList = boletaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFormaPago != null ? codFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metodopago)) {
            return false;
        }
        Metodopago other = (Metodopago) object;
        if ((this.codFormaPago == null && other.codFormaPago != null) || (this.codFormaPago != null && !this.codFormaPago.equals(other.codFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Metodopago[ codFormaPago=" + codFormaPago + " ]";
    }
    
}
