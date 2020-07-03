/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.domen;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nenad
 */
@Entity
@Table(name = "descriptor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descriptor.findAll", query = "SELECT d FROM Descriptor d")
    , @NamedQuery(name = "Descriptor.findByDescriptorId", query = "SELECT d FROM Descriptor d WHERE d.descriptorId = :descriptorId")
    , @NamedQuery(name = "Descriptor.findByMark", query = "SELECT d FROM Descriptor d WHERE d.mark = :mark")
    , @NamedQuery(name = "Descriptor.findByName", query = "SELECT d FROM Descriptor d WHERE d.name = :name")
    , @NamedQuery(name = "Descriptor.findByType", query = "SELECT d FROM Descriptor d WHERE d.type = :type")
    , @NamedQuery(name = "Descriptor.findByDocumentId", query = "SELECT d FROM Descriptor d WHERE d.documentId = :documentId")})
public class Descriptor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "descriptor_id")
    private Integer descriptorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mark")
    private String mark;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "document_id")
    private int documentId;

    public Descriptor() {
    }

    public Descriptor(Integer descriptorId) {
        this.descriptorId = descriptorId;
    }

    public Descriptor(Integer descriptorId, String mark, String name, String type, int documentId) {
        this.descriptorId = descriptorId;
        this.mark = mark;
        this.name = name;
        this.type = type;
        this.documentId = documentId;
    }

    public Integer getDescriptorId() {
        return descriptorId;
    }

    public void setDescriptorId(Integer descriptorId) {
        this.descriptorId = descriptorId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descriptorId != null ? descriptorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descriptor)) {
            return false;
        }
        Descriptor other = (Descriptor) object;
        if ((this.descriptorId == null && other.descriptorId != null) || (this.descriptorId != null && !this.descriptorId.equals(other.descriptorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.login.domen.Descriptor[ descriptorId=" + descriptorId + " ]";
    }
    
}
