/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.model;

/**
 *
 * @author Matheus1
 */
public class Consumer {
    private int idConsumer;
    private String name;
    private String cpf;
    private String rg;
    private String fone;
    private String email;
    private String date;
    
    public Consumer(int idConsumer, String name, String cpf, String rg, String fone, String email, String date) {
        this.idConsumer = idConsumer;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.fone = fone;
        this.email = email;
        this.date = date;
    }
    public Consumer(){
    
    }
    public int getIdConsumer() {
        return idConsumer;
    }

    public void setIdConsumer(int idConsumer) {
        this.idConsumer = idConsumer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
