package com.example.m6.security.bean;

import com.example.m6.bean.Prestation;
import com.example.m6.bean.TypeRemplissage;
import com.example.m6.bean.Voie;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient extends User {
    private Date datenais;
    private String cin;
    private String code;
    private String ipp;
    private String tel;
    private String document;
    @OneToOne
    private TypeRemplissage typeRemplissage;
    @OneToOne
    private Voie voie;
    @ManyToOne
    private Prestation prestation;

    //    Getters && Setters
    public Date getDatenais() {
        return datenais;
    }

    public void setDatenais(Date datenais) {
        this.datenais = datenais;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIpp() {
        return ipp;
    }

    public void setIpp(String ipp) {
        this.ipp = ipp;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public TypeRemplissage getTypeRemplissage() {
        return typeRemplissage;
    }

    public void setTypeRemplissage(TypeRemplissage typeRemplissage) {
        this.typeRemplissage = typeRemplissage;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }
}
