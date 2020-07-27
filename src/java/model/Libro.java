/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByNumSerie", query = "SELECT l FROM Libro l WHERE l.numSerie = :numSerie")
    , @NamedQuery(name = "Libro.findByIsbn", query = "SELECT l FROM Libro l WHERE l.isbn = :isbn")
    , @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Libro.findByNumPags", query = "SELECT l FROM Libro l WHERE l.numPags = :numPags")
    , @NamedQuery(name = "Libro.findByPrecioRef", query = "SELECT l FROM Libro l WHERE l.precioRef = :precioRef")
    , @NamedQuery(name = "Libro.findByAnioPublic", query = "SELECT l FROM Libro l WHERE l.anioPublic = :anioPublic")
    , @NamedQuery(name = "Libro.findByPublicacion", query = "SELECT l FROM Libro l WHERE l.publicacion = :publicacion")
    , @NamedQuery(name = "Libro.findByIdFactura", query = "SELECT l FROM Libro l WHERE l.idFactura = :idFactura")
    , @NamedQuery(name = "Libro.findByIdEdit", query = "SELECT l FROM Libro l WHERE l.idEdit = :idEdit")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numSerie")
    private Integer numSerie;
    @Size(max = 50)
    @Column(name = "isbn")
    private String isbn;
    @Size(max = 50)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "numPags")
    private Integer numPags;
    @Column(name = "precioRef")
    private Integer precioRef;
    @Column(name = "anioPublic")
    private Integer anioPublic;
    @Column(name = "publicacion")
    private Integer publicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFactura")
    private int idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEdit")
    private int idEdit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numSerie")
    private List<Ejemplar> ejemplarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numSerie")
    private List<Categorialibro> categorialibroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numSerie")
    private List<Autorlibro> autorlibroList;

    public Libro() {
    }

    public Libro(Integer numSerie) {
        this.numSerie = numSerie;
    }

    public Libro(Integer numSerie, int idFactura, int idEdit) {
        this.numSerie = numSerie;
        this.idFactura = idFactura;
        this.idEdit = idEdit;
    }

    public Integer getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumPags() {
        return numPags;
    }

    public void setNumPags(Integer numPags) {
        this.numPags = numPags;
    }

    public Integer getPrecioRef() {
        return precioRef;
    }

    public void setPrecioRef(Integer precioRef) {
        this.precioRef = precioRef;
    }

    public Integer getAnioPublic() {
        return anioPublic;
    }

    public void setAnioPublic(Integer anioPublic) {
        this.anioPublic = anioPublic;
    }

    public Integer getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Integer publicacion) {
        this.publicacion = publicacion;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdEdit() {
        return idEdit;
    }

    public void setIdEdit(int idEdit) {
        this.idEdit = idEdit;
    }

    @XmlTransient
    public List<Ejemplar> getEjemplarList() {
        return ejemplarList;
    }

    public void setEjemplarList(List<Ejemplar> ejemplarList) {
        this.ejemplarList = ejemplarList;
    }

    @XmlTransient
    public List<Categorialibro> getCategorialibroList() {
        return categorialibroList;
    }

    public void setCategorialibroList(List<Categorialibro> categorialibroList) {
        this.categorialibroList = categorialibroList;
    }

    @XmlTransient
    public List<Autorlibro> getAutorlibroList() {
        return autorlibroList;
    }

    public void setAutorlibroList(List<Autorlibro> autorlibroList) {
        this.autorlibroList = autorlibroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSerie != null ? numSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.numSerie == null && other.numSerie != null) || (this.numSerie != null && !this.numSerie.equals(other.numSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Libro[ numSerie=" + numSerie + " ]";
    }
    
}
