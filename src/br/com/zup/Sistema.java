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
}
