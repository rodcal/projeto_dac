/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evento.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author RodrigoCavotre
 */
@Entity
@Table(name = "EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByNome", query = "SELECT e FROM Evento e WHERE e.nome = :nome")
    , @NamedQuery(name = "Evento.findBySigla", query = "SELECT e FROM Evento e WHERE e.sigla = :sigla")
    , @NamedQuery(name = "Evento.findByAreaDeConcentracao", query = "SELECT e FROM Evento e WHERE e.areaDeConcentracao = :areaDeConcentracao")
    , @NamedQuery(name = "Evento.findByInstituicaoOrganizadora", query = "SELECT e FROM Evento e WHERE e.instituicaoOrganizadora = :instituicaoOrganizadora")
    , @NamedQuery(name = "Evento.findByIndex", query = "SELECT e FROM Evento e WHERE e.index = :index")})
public class Evento implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoFk")
    private List<Edicao> edicaoList;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SIGLA")
    private String sigla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AREA_DE_CONCENTRACAO")
    private String areaDeConcentracao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "INSTITUICAO_ORGANIZADORA")
    private String instituicaoOrganizadora;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INDEX")
    private Long index;

    public Evento() {
    }

    public Evento(Long index) {
        this.index = index;
    }

    public Evento(Long index, String nome, String sigla, String areaDeConcentracao, String instituicaoOrganizadora) {
        this.index = index;
        this.nome = nome;
        this.sigla = sigla;
        this.areaDeConcentracao = areaDeConcentracao;
        this.instituicaoOrganizadora = instituicaoOrganizadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getAreaDeConcentracao() {
        return areaDeConcentracao;
    }

    public void setAreaDeConcentracao(String areaDeConcentracao) {
        this.areaDeConcentracao = areaDeConcentracao;
    }

    public String getInstituicaoOrganizadora() {
        return instituicaoOrganizadora;
    }

    public void setInstituicaoOrganizadora(String instituicaoOrganizadora) {
        this.instituicaoOrganizadora = instituicaoOrganizadora;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (index != null ? index.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.index == null && other.index != null) || (this.index != null && !this.index.equals(other.index))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.evento.entity.Evento[ index=" + index + " ]";
    }

    @XmlTransient
    public List<Edicao> getEdicaoList() {
        return edicaoList;
    }

    public void setEdicaoList(List<Edicao> edicaoList) {
        this.edicaoList = edicaoList;
    }

    
}
