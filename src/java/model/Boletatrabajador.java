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
@Table(name = "boletatrabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boletatrabajador.findAll", query = "SELECT b FROM Boletatrabajador b")
    , @NamedQuery(name = "Boletatrabajador.findByDefault1", query = "SELECT b FROM Boletatrabajador b WHERE b.default1 = :default1")
    , @NamedQuery(name = "Boletatrabajador.findByCodBoletaTrabajador", query = "SELECT b FROM Boletatrabajador b WHERE b.codBoletaTrabajador = :codBoletaTrabajador")})
public class Boletatrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 18)
    @Column(name = "_default_")
    private String default1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codBoletaTrabajador")
    private Integer codBoletaTrabajador;
    @JoinColumn(name = "codBoleta", referencedColumnName = "codBoleta")
    @ManyToOne(optional = false)
    private Boleta codBoleta;
    @JoinColumn(name = "idTrabajador", referencedColumnName = "idTrabajador")
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public Boletatrabajador() {
    }

    public Boletatrabajador(Integer codBoletaTrabajador) {
        this.codBoletaTrabajador = codBoletaTrabajador;
    }

    public String getDefault1() {
        return default1;
    }

    public void setDefault1(String default1) {
        this.default1 = default1;
    }

    public Integer getCodBoletaTrabajador() {
        return codBoletaTrabajador;
    }

    public void setCodBoletaTrabajador(Integer codBoletaTrabajador) {
        this.codBoletaTrabajador = codBoletaTrabajador;
    }

    public Boleta getCodBoleta() {
        return codBoleta;
    }

    public void setCodBoleta(Boleta codBoleta) {
        this.codBoleta = codBoleta;
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
        hash += (codBoletaTrabajador != null ? codBoletaTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boletatrabajador)) {
            return false;
        }
        Boletatrabajador other = (Boletatrabajador) object;
        if ((this.codBoletaTrabajador == null && other.codBoletaTrabajador != null) || (this.codBoletaTrabajador != null && !this.codBoletaTrabajador.equals(other.codBoletaTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Boletatrabajador[ codBoletaTrabajador=" + codBoletaTrabajador + " ]";
    }
    
}
