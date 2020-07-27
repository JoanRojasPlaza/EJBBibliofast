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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "ejemplarticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejemplarticket.findAll", query = "SELECT e FROM Ejemplarticket e")
    , @NamedQuery(name = "Ejemplarticket.findByCodEjemplarTicket", query = "SELECT e FROM Ejemplarticket e WHERE e.codEjemplarTicket = :codEjemplarTicket")})
public class Ejemplarticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codEjemplarTicket")
    private Integer codEjemplarTicket;
    @JoinColumn(name = "numEjemplar", referencedColumnName = "numEjemplar")
    @ManyToOne(optional = false)
    private Ejemplar numEjemplar;
    @JoinColumn(name = "idTicket", referencedColumnName = "idTicket")
    @ManyToOne(optional = false)
    private Ticket idTicket;

    public Ejemplarticket() {
    }

    public Ejemplarticket(Integer codEjemplarTicket) {
        this.codEjemplarTicket = codEjemplarTicket;
    }

    public Integer getCodEjemplarTicket() {
        return codEjemplarTicket;
    }

    public void setCodEjemplarTicket(Integer codEjemplarTicket) {
        this.codEjemplarTicket = codEjemplarTicket;
    }

    public Ejemplar getNumEjemplar() {
        return numEjemplar;
    }

    public void setNumEjemplar(Ejemplar numEjemplar) {
        this.numEjemplar = numEjemplar;
    }

    public Ticket getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Ticket idTicket) {
        this.idTicket = idTicket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEjemplarTicket != null ? codEjemplarTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejemplarticket)) {
            return false;
        }
        Ejemplarticket other = (Ejemplarticket) object;
        if ((this.codEjemplarTicket == null && other.codEjemplarTicket != null) || (this.codEjemplarTicket != null && !this.codEjemplarTicket.equals(other.codEjemplarTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ejemplarticket[ codEjemplarTicket=" + codEjemplarTicket + " ]";
    }
    
}
