/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.fmoocc.ingenieria.tpi2018.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yisusdebian
 */
@Entity
@Table(name = "Diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d")
    , @NamedQuery(name = "Diagnostico.findByPKidDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.diagnosticoPK.pKidDiagnostico = :pKidDiagnostico")
    , @NamedQuery(name = "Diagnostico.findByOrdenTrabajopkidOrdenTrabajo", query = "SELECT d FROM Diagnostico d WHERE d.diagnosticoPK.ordenTrabajopkidOrdenTrabajo = :ordenTrabajopkidOrdenTrabajo")})
public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiagnosticoPK diagnosticoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diagnostico", fetch = FetchType.LAZY)
    private List<Dianosticoparte> dianosticoparteList;

    public Diagnostico() {
    }

    public Diagnostico(DiagnosticoPK diagnosticoPK) {
        this.diagnosticoPK = diagnosticoPK;
    }

    public Diagnostico(int pKidDiagnostico, int ordenTrabajopkidOrdenTrabajo) {
        this.diagnosticoPK = new DiagnosticoPK(pKidDiagnostico, ordenTrabajopkidOrdenTrabajo);
    }

    public DiagnosticoPK getDiagnosticoPK() {
        return diagnosticoPK;
    }

    public void setDiagnosticoPK(DiagnosticoPK diagnosticoPK) {
        this.diagnosticoPK = diagnosticoPK;
    }

    @XmlTransient
    public List<Dianosticoparte> getDianosticoparteList() {
        return dianosticoparteList;
    }

    public void setDianosticoparteList(List<Dianosticoparte> dianosticoparteList) {
        this.dianosticoparteList = dianosticoparteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagnosticoPK != null ? diagnosticoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.diagnosticoPK == null && other.diagnosticoPK != null) || (this.diagnosticoPK != null && !this.diagnosticoPK.equals(other.diagnosticoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.fmoocc.ingenieria.tpi2018.Entities.Diagnostico[ diagnosticoPK=" + diagnosticoPK + " ]";
    }
    
}
