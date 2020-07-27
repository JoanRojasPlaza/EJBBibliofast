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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 56982
 */
@Entity
@Table(name = "distribuidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribuidor.findAll", query = "SELECT d FROM Distribuidor d")
    , @NamedQuery(name = "Distribuidor.findByIdDistribuidor", query = "SELECT d FROM Distribuidor d WHERE d.idDistribuidor = :idDistribuidor")
    , @NamedQuery(name = "Distribuidor.findByRutEmpresa", query = "SELECT d FROM Distribuidor d WHERE d.rutEmpresa = :rutEmpresa")
    , @NamedQuery(name = "Distribuidor.findByAnioInicioVentas", query = "SELECT d FROM Distribuidor d WHERE d.anioInicioVentas = :anioInicioVentas")
    , @NamedQuery(name = "Distribuidor.findByNombreEmpresa", query = "SELECT d FROM Distribuidor d WHERE d.nombreEmpresa = :nombreEmpresa")})
public class Distribuidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDistribuidor")
    private Integer idDistribuidor;
    @Size(max = 50)
    @Column(name = "rutEmpresa")
    private String rutEmpresa;
    @Column(name = "anioInicioVentas")
    private Integer anioInicioVentas;
    @Size(max = 50)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDistribuidor")
    private List<Factura> facturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDistribuidor")
    private List<Direcciondistribuidor> direcciondistribuidorList;

    public Distribuidor() {
    }

    public Distribuidor(Integer idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public Integer getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(Integer idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public Integer getAnioInicioVentas() {
        return anioInicioVentas;
    }

    public void setAnioInicioVentas(Integer anioInicioVentas) {
        this.anioInicioVentas = anioInicioVentas;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<Direcciondistribuidor> getDirecciondistribuidorList() {
        return direcciondistribuidorList;
    }

    public void setDirecciondistribuidorList(List<Direcciondistribuidor> direcciondistribuidorList) {
        this.direcciondistribuidorList = direcciondistribuidorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistribuidor != null ? idDistribuidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distribuidor)) {
            return false;
        }
        Distribuidor other = (Distribuidor) object;
        if ((this.idDistribuidor == null && other.idDistribuidor != null) || (this.idDistribuidor != null && !this.idDistribuidor.equals(other.idDistribuidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Distribuidor[ idDistribuidor=" + idDistribuidor + " ]";
    }
    
}
