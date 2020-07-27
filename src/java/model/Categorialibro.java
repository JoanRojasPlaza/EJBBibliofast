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
@Table(name = "categorialibro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorialibro.findAll", query = "SELECT c FROM Categorialibro c")
    , @NamedQuery(name = "Categorialibro.findByCodCategoriaLibro", query = "SELECT c FROM Categorialibro c WHERE c.codCategoriaLibro = :codCategoriaLibro")})
public class Categorialibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codCategoriaLibro")
    private Integer codCategoriaLibro;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "numSerie", referencedColumnName = "numSerie")
    @ManyToOne(optional = false)
    private Libro numSerie;

    public Categorialibro() {
    }

    public Categorialibro(Integer codCategoriaLibro) {
        this.codCategoriaLibro = codCategoriaLibro;
    }

    public Integer getCodCategoriaLibro() {
        return codCategoriaLibro;
    }

    public void setCodCategoriaLibro(Integer codCategoriaLibro) {
        this.codCategoriaLibro = codCategoriaLibro;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Libro getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Libro numSerie) {
        this.numSerie = numSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCategoriaLibro != null ? codCategoriaLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorialibro)) {
            return false;
        }
        Categorialibro other = (Categorialibro) object;
        if ((this.codCategoriaLibro == null && other.codCategoriaLibro != null) || (this.codCategoriaLibro != null && !this.codCategoriaLibro.equals(other.codCategoriaLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Categorialibro[ codCategoriaLibro=" + codCategoriaLibro + " ]";
    }
    
}
