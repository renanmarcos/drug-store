package br.com.fatec.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Cashier {
    private int number;
    private ArrayList<CashierLog> logs = new ArrayList<>();
    private String currentStatus;

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int id) {
        this.number = id;
    }
    
    public void addLog(CashierLog log) {
        logs.add(log);
    }
    
    public void removeLog(CashierLog log) {
        logs.remove(log);
    }
    
    public Iterator<CashierLog> logsIterator() {
        return logs.iterator();
    }
}
