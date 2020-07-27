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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "editorial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editorial.findAll", query = "SELECT e FROM Editorial e")
    , @NamedQuery(name = "Editorial.findByIdEdit", query = "SELECT e FROM Editorial e WHERE e.idEdit = :idEdit")
    , @NamedQuery(name = "Editorial.findByNombreEdit", query = "SELECT e FROM Editorial e WHERE e.nombreEdit = :nombreEdit")})
public class Editorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEdit")
    private Integer idEdit;
    @Size(max = 50)
    @Column(name = "nombreEdit")
    private String nombreEdit;

    public Editorial() {
    }

    public Editorial(Integer idEdit) {
        this.idEdit = idEdit;
    }

    public Integer getIdEdit() {
        return idEdit;
    }

    public void setIdEdit(Integer idEdit) {
        this.idEdit = idEdit;
    }

    public String getNombreEdit() {
        return nombreEdit;
    }

    public void setNombreEdit(String nombreEdit) {
        this.nombreEdit = nombreEdit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEdit != null ? idEdit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editorial)) {
            return false;
        }
        Editorial other = (Editorial) object;
        if ((this.idEdit == null && other.idEdit != null) || (this.idEdit != null && !this.idEdit.equals(other.idEdit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Editorial[ idEdit=" + idEdit + " ]";
    }
    
}
