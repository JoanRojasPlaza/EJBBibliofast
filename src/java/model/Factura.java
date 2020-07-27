/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "Factura.findByPrecioNeto", query = "SELECT f FROM Factura f WHERE f.precioNeto = :precioNeto")
    , @NamedQuery(name = "Factura.findByPrecioMasIva", query = "SELECT f FROM Factura f WHERE f.precioMasIva = :precioMasIva")
    , @NamedQuery(name = "Factura.findByValorIva", query = "SELECT f FROM Factura f WHERE f.valorIva = :valorIva")
    , @NamedQuery(name = "Factura.findByFechaCompra", query = "SELECT f FROM Factura f WHERE f.fechaCompra = :fechaCompra")
    , @NamedQuery(name = "Factura.findByHoraCompra", query = "SELECT f FROM Factura f WHERE f.horaCompra = :horaCompra")
    , @NamedQuery(name = "Factura.findByFolio", query = "SELECT f FROM Factura f WHERE f.folio = :folio")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFactura")
    private Integer idFactura;
    @Column(name = "precioNeto")
    private Integer precioNeto;
    @Column(name = "precioMasIva")
    private Integer precioMasIva;
    @Column(name = "valorIva")
    private Integer valorIva;
    @Column(name = "fechaCompra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Column(name = "horaCompra")
    @Temporal(TemporalType.TIME)
    private Date horaCompra;
    @Column(name = "folio")
    private Integer folio;
    @JoinColumn(name = "idDistribuidor", referencedColumnName = "idDistribuidor")
    @ManyToOne(optional = false)
    private Distribuidor idDistribuidor;
    @JoinColumn(name = "codFormaPago", referencedColumnName = "codFormaPago")
    @ManyToOne(optional = false)
    private Metodopago codFormaPago;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
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

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(Date horaCompra) {
        this.horaCompra = horaCompra;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Distribuidor getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(Distribuidor idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
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
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
