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
@Table(name = "emailcliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emailcliente.findAll", query = "SELECT e FROM Emailcliente e")
    , @NamedQuery(name = "Emailcliente.findByCodEmail", query = "SELECT e FROM Emailcliente e WHERE e.codEmail = :codEmail")
    , @NamedQuery(name = "Emailcliente.findByEmailCliente", query = "SELECT e FROM Emailcliente e WHERE e.emailCliente = :emailCliente")})
public class Emailcliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codEmail")
    private Integer codEmail;
    @Size(max = 50)
    @Column(name = "emailCliente")
    private String emailCliente;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public Emailcliente() {
    }

    public Emailcliente(Integer codEmail) {
        this.codEmail = codEmail;
    }

    public Integer getCodEmail() {
        return codEmail;
    }

    public void setCodEmail(Integer codEmail) {
        this.codEmail = codEmail;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmail != null ? codEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emailcliente)) {
            return false;
        }
        Emailcliente other = (Emailcliente) object;
        if ((this.codEmail == null && other.codEmail != null) || (this.codEmail != null && !this.codEmail.equals(other.codEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Emailcliente[ codEmail=" + codEmail + " ]";
    }
    
}
