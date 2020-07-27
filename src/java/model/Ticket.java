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
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByIdTicket", query = "SELECT t FROM Ticket t WHERE t.idTicket = :idTicket")
    , @NamedQuery(name = "Ticket.findByTotal", query = "SELECT t FROM Ticket t WHERE t.total = :total")
    , @NamedQuery(name = "Ticket.findByFechaArriendo", query = "SELECT t FROM Ticket t WHERE t.fechaArriendo = :fechaArriendo")
    , @NamedQuery(name = "Ticket.findByFechaDevolucion", query = "SELECT t FROM Ticket t WHERE t.fechaDevolucion = :fechaDevolucion")
    , @NamedQuery(name = "Ticket.findByFechaEntrega", query = "SELECT t FROM Ticket t WHERE t.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Ticket.findByDiasRetraso", query = "SELECT t FROM Ticket t WHERE t.diasRetraso = :diasRetraso")
    , @NamedQuery(name = "Ticket.findByMulta", query = "SELECT t FROM Ticket t WHERE t.multa = :multa")
    , @NamedQuery(name = "Ticket.findByCostoArriendo", query = "SELECT t FROM Ticket t WHERE t.costoArriendo = :costoArriendo")
    , @NamedQuery(name = "Ticket.findByCodFormaPago", query = "SELECT t FROM Ticket t WHERE t.codFormaPago = :codFormaPago")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTicket")
    private Integer idTicket;
    @Column(name = "total")
    private Integer total;
    @Column(name = "fechaArriendo")
    @Temporal(TemporalType.DATE)
    private Date fechaArriendo;
    @Column(name = "fechaDevolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column(name = "diasRetraso")
    private Integer diasRetraso;
    @Column(name = "multa")
    private Integer multa;
    @Column(name = "costoArriendo")
    private Integer costoArriendo;
    @Column(name = "codFormaPago")
    private Integer codFormaPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTicket")
    private List<Ejemplarticket> ejemplarticketList;

    public Ticket() {
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Date fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getDiasRetraso() {
        return diasRetraso;
    }

    public void setDiasRetraso(Integer diasRetraso) {
        this.diasRetraso = diasRetraso;
    }

    public Integer getMulta() {
        return multa;
    }

    public void setMulta(Integer multa) {
        this.multa = multa;
    }

    public Integer getCostoArriendo() {
        return costoArriendo;
    }

    public void setCostoArriendo(Integer costoArriendo) {
        this.costoArriendo = costoArriendo;
    }

    public Integer getCodFormaPago() {
        return codFormaPago;
    }

    public void setCodFormaPago(Integer codFormaPago) {
        this.codFormaPago = codFormaPago;
    }

    @XmlTransient
    public List<Ejemplarticket> getEjemplarticketList() {
        return ejemplarticketList;
    }

    public void setEjemplarticketList(List<Ejemplarticket> ejemplarticketList) {
        this.ejemplarticketList = ejemplarticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ticket[ idTicket=" + idTicket + " ]";
    }
    
}
