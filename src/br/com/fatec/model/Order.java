package br.com.fatec.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Order {
    private int id;
    private HashMap<Drug, Integer> drugs = new HashMap<>();
    private float freight, discount, total;
    private LocalDate dateOrdered;
    private LocalTime timeOrdered;  
    private Consumer specialClient;
    
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

    public Consumer getSpecialClient() {
        return specialClient;
    }

    public void setSpecialClient(Consumer specialClient) {
        this.specialClient = specialClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
