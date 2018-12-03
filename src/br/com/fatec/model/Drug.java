package br.com.fatec.model;

import java.text.DecimalFormat;

public class Drug {
    private int idDrug;
    private String comname;
    private String typedrug;
    private String lab;
    private int isgeneric;
    private int needpre;
    private float unitprice;
    private String descdrug;
    private String dateshelf;
    
    public Drug(int idDrug, String comname, String typedrug, String lab, int isgeneric, int needpre, float unitprice, String descdrug, String dateshelf) {
        this.idDrug = idDrug;
        this.comname = comname;
        this.typedrug = typedrug;
        this.lab = lab;
        this.isgeneric = isgeneric;
        this.needpre = needpre;
        this.unitprice = unitprice;
        this.descdrug = descdrug;
        this.dateshelf = dateshelf;
    }
    
    public Drug() {}

    @Override
    public String toString() {
        return comname;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idDrug;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drug other = (Drug) obj;
        if (this.idDrug != other.idDrug) {
            return false;
        }
        return true;
    }    
    
    public int getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(int idDrug) {
        this.idDrug = idDrug;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getTypedrug() {
        return typedrug;
    }

    public void setTypedrug(String typedrug) {
        this.typedrug = typedrug;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public int getIsgeneric() {
        return isgeneric;
    }

    public void setIsgeneric(int isgeneric) {
        this.isgeneric = isgeneric;
    }

    public int getNeedpre() {
        return needpre;
    }

    public void setNeedpre(int needpre) {
        this.needpre = needpre;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }

    public String getDescdrug() {
        return descdrug;
    }

    public void setDescdrug(String descdrug) {
        this.descdrug = descdrug;
    }

    public String getDateshelf() {
        return dateshelf;
    }

    public void setDateshelf(String dateshelf) {
        this.dateshelf = dateshelf;
    }

}