package br.com.zup;

import java.util.Scanner;

public class Sistema {

    private static Scanner capturarDados (String mensagem){
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    public static Venda cadastrarVenda(){
        String emailCliente = capturarDados("Digite o email do cliente que deseja cadastrar esta venda").nextLine();
        String emailVendedor = capturarDados("Digite o email do vendedor que realizou a venda").nextLine();
        double valor = capturarDados("Qual é o valor desta venda").nextDouble();
        String data = capturarDados("Qual é a data do registro").nextLine();
    }

    public static Cliente cadastrarCliente() throws Exception{
        String nome = capturarDados("Qual é o nome do cliente?").nextLine();
        String cpf = capturarDados(("Qual é o CPF do cliente:")).nextLine();
        String email = capturarDados("Qual é o email do cliente?").nextLine();
        ServiceCliente.verificarDuplicidadeNoCadastro(email);
        return ServiceCliente.cadastrarCliente(nome, cpf, email);
    }

    public static Vendedor cadastrarVendedor(){
        String nome = capturarDados("Qual é o nome do vendedor??").nextLine();
        String cpf = capturarDados(("Qual é o CPF do vendedor?:")).nextLine();
        String email = capturarDados("Qual é o email do vendedor?").nextLine();
        return ServiceVendedor.cadastrarVendedor(nome, cpf, email);
    }
}
