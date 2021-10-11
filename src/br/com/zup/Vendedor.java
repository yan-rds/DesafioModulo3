package br.com.zup;

public class Vendedor {
    // Classe que moldará meus objetos Vendedor

    private String nome;
    private String cpf;
    private String email;

    public Vendedor(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder concatenador = new StringBuilder();
        concatenador.append(nome);
        concatenador.append("\tCpf: " + cpf);
        concatenador.append("\tEmail: " + email);
        return concatenador.toString();
    }
}
