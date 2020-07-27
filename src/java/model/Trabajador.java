/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t")
    , @NamedQuery(name = "Trabajador.findByIdTrabajador", query = "SELECT t FROM Trabajador t WHERE t.idTrabajador = :idTrabajador")
    , @NamedQuery(name = "Trabajador.findByNombreTrabajador", query = "SELECT t FROM Trabajador t WHERE t.nombreTrabajador = :nombreTrabajador")
    , @NamedQuery(name = "Trabajador.findByApePaternoTrabajador", query = "SELECT t FROM Trabajador t WHERE t.apePaternoTrabajador = :apePaternoTrabajador")
    , @NamedQuery(name = "Trabajador.findByApeMaternoTrabajador", query = "SELECT t FROM Trabajador t WHERE t.apeMaternoTrabajador = :apeMaternoTrabajador")
    , @NamedQuery(name = "Trabajador.findByRutTrabajador", query = "SELECT t FROM Trabajador t WHERE t.rutTrabajador = :rutTrabajador")
    , @NamedQuery(name = "Trabajador.findByFechaInicioContrato", query = "SELECT t FROM Trabajador t WHERE t.fechaInicioContrato = :fechaInicioContrato")})
public class Trabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrabajador")
    private Integer idTrabajador;
    @Size(max = 50)
    @Column(name = "nombreTrabajador")
    private String nombreTrabajador;
    @Size(max = 50)
    @Column(name = "apePaternoTrabajador")
    private String apePaternoTrabajador;
    @Size(max = 50)
    @Column(name = "apeMaternoTrabajador")
    private String apeMaternoTrabajador;
    @Size(max = 50)
    @Column(name = "rutTrabajador")
    private String rutTrabajador;
    @Column(name = "fechaInicioContrato")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioContrato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<Direcciontrabajador> direcciontrabajadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<Emailtrabajador> emailtrabajadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<Boletatrabajador> boletatrabajadorList;

    public Trabajador() {
    }

    public Trabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getApePaternoTrabajador() {
        return apePaternoTrabajador;
    }

    public void setApePaternoTrabajador(String apePaternoTrabajador) {
        this.apePaternoTrabajador = apePaternoTrabajador;
    }

    public String getApeMaternoTrabajador() {
        return apeMaternoTrabajador;
    }

    public void setApeMaternoTrabajador(String apeMaternoTrabajador) {
        this.apeMaternoTrabajador = apeMaternoTrabajador;
    }

    public String getRutTrabajador() {
        return rutTrabajador;
    }

    public void setRutTrabajador(String rutTrabajador) {
        this.rutTrabajador = rutTrabajador;
    }

    public Date getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(Date fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    @XmlTransient
    public List<Direcciontrabajador> getDirecciontrabajadorList() {
        return direcciontrabajadorList;
    }

    public void setDirecciontrabajadorList(List<Direcciontrabajador> direcciontrabajadorList) {
        this.direcciontrabajadorList = direcciontrabajadorList;
    }

    @XmlTransient
    public List<Emailtrabajador> getEmailtrabajadorList() {
        return emailtrabajadorList;
    }

    public void setEmailtrabajadorList(List<Emailtrabajador> emailtrabajadorList) {
        this.emailtrabajadorList = emailtrabajadorList;
    }

    @XmlTransient
    public List<Boletatrabajador> getBoletatrabajadorList() {
        return boletatrabajadorList;
    }

    public void setBoletatrabajadorList(List<Boletatrabajador> boletatrabajadorList) {
        this.boletatrabajadorList = boletatrabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajador != null ? idTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.idTrabajador == null && other.idTrabajador != null) || (this.idTrabajador != null && !this.idTrabajador.equals(other.idTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Trabajador[ idTrabajador=" + idTrabajador + " ]";
    }
    
}
