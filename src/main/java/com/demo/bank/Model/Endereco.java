package com.demo.bank.Model;


import com.demo.bank.API.ViaCepService;

public class Endereco {
    private String localidade;
    private String logradouro;
    private String bairro;
    private String estado;
    private int number;
    private String cep;


    public String getLogradouro() {
        return logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Endereco() {

    }





}


