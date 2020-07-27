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
@Table(name = "idiomalibro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idiomalibro.findAll", query = "SELECT i FROM Idiomalibro i")
    , @NamedQuery(name = "Idiomalibro.findByIdIdioma", query = "SELECT i FROM Idiomalibro i WHERE i.idIdioma = :idIdioma")
    , @NamedQuery(name = "Idiomalibro.findByNumSerie", query = "SELECT i FROM Idiomalibro i WHERE i.numSerie = :numSerie")
    , @NamedQuery(name = "Idiomalibro.findByCodIdiomaLibro", query = "SELECT i FROM Idiomalibro i WHERE i.codIdiomaLibro = :codIdiomaLibro")})
public class Idiomalibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idIdioma")
    private int idIdioma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numSerie")
    private int numSerie;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codIdiomaLibro")
    private Integer codIdiomaLibro;

    public Idiomalibro() {
    }

    public Idiomalibro(Integer codIdiomaLibro) {
        this.codIdiomaLibro = codIdiomaLibro;
    }

    public Idiomalibro(Integer codIdiomaLibro, int idIdioma, int numSerie) {
        this.codIdiomaLibro = codIdiomaLibro;
        this.idIdioma = idIdioma;
        this.numSerie = numSerie;
    }

    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public Integer getCodIdiomaLibro() {
        return codIdiomaLibro;
    }

    public void setCodIdiomaLibro(Integer codIdiomaLibro) {
        this.codIdiomaLibro = codIdiomaLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIdiomaLibro != null ? codIdiomaLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idiomalibro)) {
            return false;
        }
        Idiomalibro other = (Idiomalibro) object;
        if ((this.codIdiomaLibro == null && other.codIdiomaLibro != null) || (this.codIdiomaLibro != null && !this.codIdiomaLibro.equals(other.codIdiomaLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Idiomalibro[ codIdiomaLibro=" + codIdiomaLibro + " ]";
    }
    
}
