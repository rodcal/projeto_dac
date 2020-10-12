/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RodrigoCavotre
 */
@Entity
@Table(name = "EDICAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edicao.findAll", query = "SELECT e FROM Edicao e")
    , @NamedQuery(name = "Edicao.findByAno", query = "SELECT e FROM Edicao e WHERE e.ano = :ano")
    , @NamedQuery(name = "Edicao.findByDataInicio", query = "SELECT e FROM Edicao e WHERE e.dataInicio = :dataInicio")
    , @NamedQuery(name = "Edicao.findByDataFim", query = "SELECT e FROM Edicao e WHERE e.dataFim = :dataFim")
    , @NamedQuery(name = "Edicao.findByCidade", query = "SELECT e FROM Edicao e WHERE e.cidade = :cidade")
    , @NamedQuery(name = "Edicao.findByPais", query = "SELECT e FROM Edicao e WHERE e.pais = :pais")
    , @NamedQuery(name = "Edicao.findById", query = "SELECT e FROM Edicao e WHERE e.id = :id")})
public class Edicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANO")
    private int ano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_FIM")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CIDADE")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PAIS")
    private String pais;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @JoinColumn(name = "EVENTO_FK", referencedColumnName = "INDEX")
    @ManyToOne(optional = false)
    private Evento eventoFk;

    public Edicao() {
    }

    public Edicao(Long id) {
        this.id = id;
    }

    public Edicao(Long id, int ano, Date dataInicio, Date dataFim, String cidade, String pais) {
        this.id = id;
        this.ano = ano;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.cidade = cidade;
        this.pais = pais;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEventoFk() {
        return eventoFk;
    }

    public void setEventoFk(Evento eventoFk) {
        this.eventoFk = eventoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edicao)) {
            return false;
        }
        Edicao other = (Edicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.evento.entity.Edicao[ id=" + id + " ]";
    }
    
}
