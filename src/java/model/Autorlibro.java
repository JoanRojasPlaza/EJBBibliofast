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
@Table(name = "autorlibro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autorlibro.findAll", query = "SELECT a FROM Autorlibro a")
    , @NamedQuery(name = "Autorlibro.findByCodAutorLibro", query = "SELECT a FROM Autorlibro a WHERE a.codAutorLibro = :codAutorLibro")})
public class Autorlibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codAutorLibro")
    private Integer codAutorLibro;
    @JoinColumn(name = "numSerie", referencedColumnName = "numSerie")
    @ManyToOne(optional = false)
    private Libro numSerie;
    @JoinColumn(name = "idAutor", referencedColumnName = "idAutor")
    @ManyToOne(optional = false)
    private Autor idAutor;

    public Autorlibro() {
    }

    public Autorlibro(Integer codAutorLibro) {
        this.codAutorLibro = codAutorLibro;
    }

    public Integer getCodAutorLibro() {
        return codAutorLibro;
    }

    public void setCodAutorLibro(Integer codAutorLibro) {
        this.codAutorLibro = codAutorLibro;
    }

    public Libro getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Libro numSerie) {
        this.numSerie = numSerie;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAutorLibro != null ? codAutorLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autorlibro)) {
            return false;
        }
        Autorlibro other = (Autorlibro) object;
        if ((this.codAutorLibro == null && other.codAutorLibro != null) || (this.codAutorLibro != null && !this.codAutorLibro.equals(other.codAutorLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Autorlibro[ codAutorLibro=" + codAutorLibro + " ]";
    }
    
}
