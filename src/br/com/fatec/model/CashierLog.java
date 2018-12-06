package br.com.fatec.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CashierLog {
    private int id;
    private LocalDate dateRecorded;
    private LocalTime timeRecorded;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id;
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
        final CashierLog other = (CashierLog) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public LocalTime getTimeRecorded() {
        return timeRecorded;
    }

    public void setTimeRecorded(LocalTime timeRecorded) {
        this.timeRecorded = timeRecorded;
    }
}
