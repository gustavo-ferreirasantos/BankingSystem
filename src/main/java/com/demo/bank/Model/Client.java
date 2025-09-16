package com.demo.bank.Model;



public class Client extends User {
    private String nameClient;
    private int id;
    private Endereco endereco;
    private String cpf;


    private static int numUser = 1000;



    public Client(String nameClient, Endereco endereco, String cpf, String email, String password)
    {
        super.setEmail(email);
        super.setPassword(password);
        this.nameClient = nameClient;
        this.id = ++numUser;
        this.endereco = endereco;
        try {
            if(validateCpf(cpf)){
                this.cpf = formatCpf(cpf);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }


    public String getNameClient() {
        return nameClient;
    }
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }



    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        if (validateCpf(cpf)) {
            this.cpf = formatCpf(cpf);
        }else{
            System.out.println("CPF invalido");
        }
    }





    public static boolean validateCpf(String cpf) {
        if (cpf == null) return false;

        // Mantém apenas dígitos
        String digits = cpf.replaceAll("\\D", "");
        if (digits.length() != 11) return false;

        // Rejeita sequências repetidas tipo "00000000000"
        if (digits.chars().distinct().count() == 1) return false;

        // Calcula 1º dígito verificador (pesos 10..2)
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int n = digits.charAt(i) - '0';
            sum += n * (10 - i);
        }
        int d1 = 11 - (sum % 11);
        if (d1 >= 10) d1 = 0;

        // Calcula 2º dígito verificador (pesos 11..2)
        sum = 0;
        for (int i = 0; i < 10; i++) {
            int n = digits.charAt(i) - '0';
            sum += n * (11 - i);
        }
        int d2 = 11 - (sum % 11);
        if (d2 >= 10) d2 = 0;

        // Confere com os dígitos do CPF
        return (digits.charAt(9)  - '0') == d1 && (digits.charAt(10) - '0') == d2;
    }

    public static String formatCpf(String cpf) {
        // Mantém apenas dígitos
        String digits = cpf.replaceAll("\\D", "");
        if (digits.length() != 11) return cpf; // retorna como está se não tiver 11 dígitos

        return digits.substring(0, 3) + "." +
                digits.substring(3, 6) + "." +
                digits.substring(6, 9) + "-" +
                digits.substring(9);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
