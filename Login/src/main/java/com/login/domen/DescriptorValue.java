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
@Table(name = "descriptor_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescriptorValue.findAll", query = "SELECT d FROM DescriptorValue d")
    , @NamedQuery(name = "DescriptorValue.findById", query = "SELECT d FROM DescriptorValue d WHERE d.id = :id")
    , @NamedQuery(name = "DescriptorValue.findByValue", query = "SELECT d FROM DescriptorValue d WHERE d.value = :value")
    , @NamedQuery(name = "DescriptorValue.findByDescriptorId", query = "SELECT d FROM DescriptorValue d WHERE d.descriptorId = :descriptorId")
    , @NamedQuery(name = "DescriptorValue.findByDocumentInstanceId", query = "SELECT d FROM DescriptorValue d WHERE d.documentInstanceId = :documentInstanceId")})
public class DescriptorValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descriptor_id")
    private int descriptorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "document_instance_id")
    private int documentInstanceId;

    public DescriptorValue() {
    }

    public DescriptorValue(Integer id) {
        this.id = id;
    }

    public DescriptorValue(Integer id, String value, int descriptorId, int documentInstanceId) {
        this.id = id;
        this.value = value;
        this.descriptorId = descriptorId;
        this.documentInstanceId = documentInstanceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getDescriptorId() {
        return descriptorId;
    }

    public void setDescriptorId(int descriptorId) {
        this.descriptorId = descriptorId;
    }

    public int getDocumentInstanceId() {
        return documentInstanceId;
    }

    public void setDocumentInstanceId(int documentInstanceId) {
        this.documentInstanceId = documentInstanceId;
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
        if (!(object instanceof DescriptorValue)) {
            return false;
        }
        DescriptorValue other = (DescriptorValue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.login.domen.DescriptorValue[ id=" + id + " ]";
    }
    
}
