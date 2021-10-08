package br.com.zup;

public class Main {

    public static void main(String[] args) {
        try {
            Sistema.cadastrarCliente();
            ServiceCliente.verificarDuplicidadeNoCadastro("44");
        }catch (Exception erro){
            System.out.println(erro.getMessage());
        }

    }
}
