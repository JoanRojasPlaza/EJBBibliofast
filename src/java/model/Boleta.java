/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "boleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b")
    , @NamedQuery(name = "Boleta.findByFolioBoleta", query = "SELECT b FROM Boleta b WHERE b.folioBoleta = :folioBoleta")
    , @NamedQuery(name = "Boleta.findByPrecioNeto", query = "SELECT b FROM Boleta b WHERE b.precioNeto = :precioNeto")
    , @NamedQuery(name = "Boleta.findByPrecioMasIva", query = "SELECT b FROM Boleta b WHERE b.precioMasIva = :precioMasIva")
    , @NamedQuery(name = "Boleta.findByValorIva", query = "SELECT b FROM Boleta b WHERE b.valorIva = :valorIva")
    , @NamedQuery(name = "Boleta.findByFechaVenta", query = "SELECT b FROM Boleta b WHERE b.fechaVenta = :fechaVenta")
    , @NamedQuery(name = "Boleta.findByHoraVenta", query = "SELECT b FROM Boleta b WHERE b.horaVenta = :horaVenta")
    , @NamedQuery(name = "Boleta.findByCodBoleta", query = "SELECT b FROM Boleta b WHERE b.codBoleta = :codBoleta")})
public class Boleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "folioBoleta")
    private Integer folioBoleta;
    @Column(name = "precioNeto")
    private Integer precioNeto;
    @Column(name = "precioMasIva")
    private Integer precioMasIva;
    @Column(name = "valorIva")
    private Integer valorIva;
    @Column(name = "fechaVenta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Column(name = "horaVenta")
    @Temporal(TemporalType.TIME)
    private Date horaVenta;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codBoleta")
    private Integer codBoleta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codBoleta")
    private List<Boletatrabajador> boletatrabajadorList;
    @JoinColumn(name = "codFormaPago", referencedColumnName = "codFormaPago")
    @ManyToOne
    private Metodopago codFormaPago;

    public Boleta() {
    }

    public Boleta(Integer codBoleta) {
        this.codBoleta = codBoleta;
    }

    public Integer getFolioBoleta() {
        return folioBoleta;
    }

    public void setFolioBoleta(Integer folioBoleta) {
        this.folioBoleta = folioBoleta;
    }

    public Integer getPrecioNeto() {
        return precioNeto;
    }

    public void setPrecioNeto(Integer precioNeto) {
        this.precioNeto = precioNeto;
    }

    public Integer getPrecioMasIva() {
        return precioMasIva;
    }

    public void setPrecioMasIva(Integer precioMasIva) {
        this.precioMasIva = precioMasIva;
    }

    public Integer getValorIva() {
        return valorIva;
    }

    public void setValorIva(Integer valorIva) {
        this.valorIva = valorIva;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(Date horaVenta) {
        this.horaVenta = horaVenta;
    }

    public Integer getCodBoleta() {
        return codBoleta;
    }

    public void setCodBoleta(Integer codBoleta) {
        this.codBoleta = codBoleta;
    }

    @XmlTransient
    public List<Boletatrabajador> getBoletatrabajadorList() {
        return boletatrabajadorList;
    }

    public void setBoletatrabajadorList(List<Boletatrabajador> boletatrabajadorList) {
        this.boletatrabajadorList = boletatrabajadorList;
    }

    public Metodopago getCodFormaPago() {
        return codFormaPago;
    }

    public void setCodFormaPago(Metodopago codFormaPago) {
        this.codFormaPago = codFormaPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBoleta != null ? codBoleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.codBoleta == null && other.codBoleta != null) || (this.codBoleta != null && !this.codBoleta.equals(other.codBoleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Boleta[ codBoleta=" + codBoleta + " ]";
    }
    
}
