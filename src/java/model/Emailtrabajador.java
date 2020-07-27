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
@Table(name = "emailtrabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emailtrabajador.findAll", query = "SELECT e FROM Emailtrabajador e")
    , @NamedQuery(name = "Emailtrabajador.findByCodEmailTrabajador", query = "SELECT e FROM Emailtrabajador e WHERE e.codEmailTrabajador = :codEmailTrabajador")
    , @NamedQuery(name = "Emailtrabajador.findByEmailTrabajador", query = "SELECT e FROM Emailtrabajador e WHERE e.emailTrabajador = :emailTrabajador")})
public class Emailtrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codEmailTrabajador")
    private Integer codEmailTrabajador;
    @Size(max = 50)
    @Column(name = "emailTrabajador")
    private String emailTrabajador;
    @JoinColumn(name = "idTrabajador", referencedColumnName = "idTrabajador")
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public Emailtrabajador() {
    }

    public Emailtrabajador(Integer codEmailTrabajador) {
        this.codEmailTrabajador = codEmailTrabajador;
    }

    public Integer getCodEmailTrabajador() {
        return codEmailTrabajador;
    }

    public void setCodEmailTrabajador(Integer codEmailTrabajador) {
        this.codEmailTrabajador = codEmailTrabajador;
    }

    public String getEmailTrabajador() {
        return emailTrabajador;
    }

    public void setEmailTrabajador(String emailTrabajador) {
        this.emailTrabajador = emailTrabajador;
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
        hash += (codEmailTrabajador != null ? codEmailTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emailtrabajador)) {
            return false;
        }
        Emailtrabajador other = (Emailtrabajador) object;
        if ((this.codEmailTrabajador == null && other.codEmailTrabajador != null) || (this.codEmailTrabajador != null && !this.codEmailTrabajador.equals(other.codEmailTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Emailtrabajador[ codEmailTrabajador=" + codEmailTrabajador + " ]";
    }
    
}
