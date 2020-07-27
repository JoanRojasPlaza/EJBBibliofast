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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "ejemplar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejemplar.findAll", query = "SELECT e FROM Ejemplar e")
    , @NamedQuery(name = "Ejemplar.findByNumEjemplar", query = "SELECT e FROM Ejemplar e WHERE e.numEjemplar = :numEjemplar")
    , @NamedQuery(name = "Ejemplar.findByNombreEjemplar", query = "SELECT e FROM Ejemplar e WHERE e.nombreEjemplar = :nombreEjemplar")})
public class Ejemplar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numEjemplar")
    private Integer numEjemplar;
    @Size(max = 50)
    @Column(name = "nombreEjemplar")
    private String nombreEjemplar;
    @JoinColumn(name = "numSerie", referencedColumnName = "numSerie")
    @ManyToOne(optional = false)
    private Libro numSerie;
    @JoinColumn(name = "codEstado", referencedColumnName = "codEstado")
    @ManyToOne
    private Estado codEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numEjemplar")
    private List<Ejemplarticket> ejemplarticketList;

    public Ejemplar() {
    }

    public Ejemplar(Integer numEjemplar) {
        this.numEjemplar = numEjemplar;
    }

    public Integer getNumEjemplar() {
        return numEjemplar;
    }

    public void setNumEjemplar(Integer numEjemplar) {
        this.numEjemplar = numEjemplar;
    }

    public String getNombreEjemplar() {
        return nombreEjemplar;
    }

    public void setNombreEjemplar(String nombreEjemplar) {
        this.nombreEjemplar = nombreEjemplar;
    }

    public Libro getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Libro numSerie) {
        this.numSerie = numSerie;
    }

    public Estado getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Estado codEstado) {
        this.codEstado = codEstado;
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
        hash += (numEjemplar != null ? numEjemplar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejemplar)) {
            return false;
        }
        Ejemplar other = (Ejemplar) object;
        if ((this.numEjemplar == null && other.numEjemplar != null) || (this.numEjemplar != null && !this.numEjemplar.equals(other.numEjemplar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ejemplar[ numEjemplar=" + numEjemplar + " ]";
    }
    
}
