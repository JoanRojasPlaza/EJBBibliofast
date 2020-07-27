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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Cliente.findByApePaternoCliente", query = "SELECT c FROM Cliente c WHERE c.apePaternoCliente = :apePaternoCliente")
    , @NamedQuery(name = "Cliente.findByApeMaternoCliente", query = "SELECT c FROM Cliente c WHERE c.apeMaternoCliente = :apeMaternoCliente")
    , @NamedQuery(name = "Cliente.findByFechaNacimiento", query = "SELECT c FROM Cliente c WHERE c.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Cliente.findByRutCliente", query = "SELECT c FROM Cliente c WHERE c.rutCliente = :rutCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Size(max = 50)
    @Column(name = "nombreCliente")
    private String nombreCliente;
    @Size(max = 50)
    @Column(name = "apePaternoCliente")
    private String apePaternoCliente;
    @Size(max = 50)
    @Column(name = "apeMaternoCliente")
    private String apeMaternoCliente;
    @Column(name = "fechaNacimiento")
    private Integer fechaNacimiento;
    @Size(max = 50)
    @Column(name = "rutCliente")
    private String rutCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<Direccioncliente> direccionclienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<Emailcliente> emailclienteList;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApePaternoCliente() {
        return apePaternoCliente;
    }

    public void setApePaternoCliente(String apePaternoCliente) {
        this.apePaternoCliente = apePaternoCliente;
    }

    public String getApeMaternoCliente() {
        return apeMaternoCliente;
    }

    public void setApeMaternoCliente(String apeMaternoCliente) {
        this.apeMaternoCliente = apeMaternoCliente;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    @XmlTransient
    public List<Direccioncliente> getDireccionclienteList() {
        return direccionclienteList;
    }

    public void setDireccionclienteList(List<Direccioncliente> direccionclienteList) {
        this.direccionclienteList = direccionclienteList;
    }

    @XmlTransient
    public List<Emailcliente> getEmailclienteList() {
        return emailclienteList;
    }

    public void setEmailclienteList(List<Emailcliente> emailclienteList) {
        this.emailclienteList = emailclienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
