package com.imaltuna.geks.model;

import java.util.Date;



public class GailuTaulaGaurEgun {
    private Integer idGailua;
    private String marka;
    private String modeloa;
    private String serieZenb;
    private String mota;
    private GailuEgoera egoera;
    private Date altaData;
    private Date bajaData;
    private Integer idGela;      // 'Egon' taulatik
    private Date hasieraData;    // 'Egon' taulatik (Data Hartu)



    
    public GailuTaulaGaurEgun(Integer idGailua, String marka, String modeloa, String serieZenb, String mota,
            GailuEgoera egoera, Date altaData, Date bajaData, Integer idGela, Date hasieraData) {
        this.idGailua = idGailua;
        this.marka = marka;
        this.modeloa = modeloa;
        this.serieZenb = serieZenb;
        this.mota = mota;
        this.egoera = egoera;
        this.altaData = altaData;
        this.bajaData = bajaData;
        this.idGela = idGela;
        this.hasieraData = hasieraData;
    }


    public Integer getIdGailua() {
        return idGailua;
    }
    public void setIdGailua(Integer idGailua) {
        this.idGailua = idGailua;
    }
    public String getMarka() {
        return marka;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public String getModeloa() {
        return modeloa;
    }
    public void setModeloa(String modeloa) {
        this.modeloa = modeloa;
    }
    public String getSerieZenb() {
        return serieZenb;
    }
    public void setSerieZenb(String serieZenb) {
        this.serieZenb = serieZenb;
    }
    public String getMota() {
        return mota;
    }
    public void setMota(String mota) {
        this.mota = mota;
    }
    public GailuEgoera getEgoera() {
        return egoera;
    }
    public void setEgoera(GailuEgoera egoera) {
        this.egoera = egoera;
    }
    public Date getAltaData() {
        return altaData;
    }
    public void setAltaData(Date altaData) {
        this.altaData = altaData;
    }
    public Date getBajaData() {
        return bajaData;
    }
    public void setBajaData(Date bajaData) {
        this.bajaData = bajaData;
    }
    public Integer getIdGela() {
        return idGela;
    }
    public void setIdGela(Integer idGela) {
        this.idGela = idGela;
    }
    public Date getHasieraData() {
        return hasieraData;
    }
    public void setHasieraData(Date hasieraData) {
        this.hasieraData = hasieraData;
    }   

}

