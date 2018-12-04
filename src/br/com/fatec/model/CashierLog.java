package br.com.fatec.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CashierLog {
    private int id;
    private LocalDate dateRecorded;
    private LocalTime timeRecorded;

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
