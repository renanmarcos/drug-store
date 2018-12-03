package br.com.fatec.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Order {
    private HashMap<Drug, Integer> drugs = new HashMap<>();
    private float freight, discount, total;
    private LocalDate dateOrdered;
    private LocalTime timeOrdered;  
    
    public void addDrug(Drug drug, int quantity) {
        drugs.merge(drug, quantity, (oldQuantity, newQuantity) -> {
            if ( (oldQuantity + newQuantity) >= 999) return 999;
            return oldQuantity + newQuantity;
        });
    }
    
    public void removeDrug(Drug drug, int quantity) {
        drugs.merge(drug, quantity, (oldQuantity, newQuantity) -> {
            if (oldQuantity <= newQuantity) return 0;
            return oldQuantity - newQuantity;
        });
    }
    
    public Set<Map.Entry<Drug, Integer>> getEntrySet() {
        return drugs.entrySet();
    }
    public float getFreight() {
        return freight;
    }

    public void setFreight(float freight) {
        this.freight = freight;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public LocalTime getTimeOrdered() {
        return timeOrdered;
    }

    public void setTimeOrdered(LocalTime timeOrdered) {
        this.timeOrdered = timeOrdered;
    } 
}