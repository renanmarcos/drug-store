package br.com.fatec.model;

public class Consumer {
    private int idConsumer;
    private String name;
    private String cpf;
    private String rg;
    private String phone;
    private String email;
    private String datebirth;
    
    public Consumer(int idConsumer, String name, String cpf, String rg, String phone, String email, String datebirth) {
        this.idConsumer = idConsumer;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.phone = phone;
        this.email = email;
        this.datebirth = datebirth;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateBirth() {
        return datebirth;
    }

    public void setDateBirth(String datebirth) {
        this.datebirth = datebirth;
    }
}
