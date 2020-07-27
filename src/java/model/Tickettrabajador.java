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
@Table(name = "tickettrabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tickettrabajador.findAll", query = "SELECT t FROM Tickettrabajador t")
    , @NamedQuery(name = "Tickettrabajador.findByIdTicket", query = "SELECT t FROM Tickettrabajador t WHERE t.idTicket = :idTicket")
    , @NamedQuery(name = "Tickettrabajador.findByIdTrabajador", query = "SELECT t FROM Tickettrabajador t WHERE t.idTrabajador = :idTrabajador")
    , @NamedQuery(name = "Tickettrabajador.findByCodTicketTrabajador", query = "SELECT t FROM Tickettrabajador t WHERE t.codTicketTrabajador = :codTicketTrabajador")})
public class Tickettrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTicket")
    private int idTicket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTrabajador")
    private int idTrabajador;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codTicketTrabajador")
    private Integer codTicketTrabajador;

    public Tickettrabajador() {
    }

    public Tickettrabajador(Integer codTicketTrabajador) {
        this.codTicketTrabajador = codTicketTrabajador;
    }

    public Tickettrabajador(Integer codTicketTrabajador, int idTicket, int idTrabajador) {
        this.codTicketTrabajador = codTicketTrabajador;
        this.idTicket = idTicket;
        this.idTrabajador = idTrabajador;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Integer getCodTicketTrabajador() {
        return codTicketTrabajador;
    }

    public void setCodTicketTrabajador(Integer codTicketTrabajador) {
        this.codTicketTrabajador = codTicketTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTicketTrabajador != null ? codTicketTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tickettrabajador)) {
            return false;
        }
        Tickettrabajador other = (Tickettrabajador) object;
        if ((this.codTicketTrabajador == null && other.codTicketTrabajador != null) || (this.codTicketTrabajador != null && !this.codTicketTrabajador.equals(other.codTicketTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tickettrabajador[ codTicketTrabajador=" + codTicketTrabajador + " ]";
    }
    
}
