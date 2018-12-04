package br.com.fatec.model;

import java.util.ArrayList;

public class Cashier {
    private int id;
    private ArrayList<CashierLog> logs = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void addLog(CashierLog log) {
        logs.add(log);
    }
    
    public void removeLog(CashierLog log) {
        logs.remove(log);
    }
}
