package br.com.zup;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Sistema {

    private static boolean menu = true;

    private static Scanner capturarDados (String mensagem){
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    public static Venda cadastrarVenda() throws Exception{
        String emailCliente = capturarDados("Digite o email do cliente que deseja cadastrar esta venda").nextLine();
        String emailVendedor = capturarDados("Digite o email do vendedor que realizou a venda").nextLine();
        double valor = capturarDados("Qual é o valor desta venda").nextDouble();
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        return ServiceVenda.cadastrarVenda(emailCliente, emailVendedor, valor, data);
    }

    public static Cliente cadastrarCliente() throws Exception{
        String nome = capturarDados("Qual é o nome do cliente?").nextLine();
        String cpf = capturarDados(("Qual é o CPF do cliente:")).nextLine();
        ServiceCliente.verificarDuplicidadeNoCadastro(cpf);
        String email = capturarDados("Qual é o email do cliente?").nextLine();
        ServiceCliente.validarEmail(email);
        ServiceCliente.verificarDuplicidadeNoCadastro(email);
        return ServiceCliente.cadastrarCliente(nome, cpf, email);
    }

    public static Vendedor cadastrarVendedor() throws Exception{
        String nome = capturarDados("Qual é o nome do vendedor?").nextLine();
        String cpf = capturarDados(("Qual é o CPF do vendedor?:")).nextLine();
        ServiceVendedor.verificarDuplicidadeNoCadastro(cpf);
        String email = capturarDados("Qual é o email do vendedor?").nextLine();
        ServiceVendedor.verificarDuplicidadeNoCadastro(email);
        ServiceCliente.validarEmail(email);
        return ServiceVendedor.cadastrarVendedor(nome, cpf, email);
    }

    public static void menuInicial(){
        System.out.println("Sistema de registo de vendas");
        System.out.println("1 - Cadastrar um consumidor");
        System.out.println("2 - Cadastrar um vendedor");
        System.out.println("3 - Cadastrar uma venda");
        System.out.println("4 - Exibir consumidores cadastrados");
        System.out.println("5 - Exibir vendedores cadastrados");
        System.out.println("6 - Exibir todas as vendas cadastradas");
        System.out.println("7 - Pesquisar todas as compras de um consumidor");
        System.out.println("8 - Pesquisar todas as vendas de um vendedor");
        System.out.println("9 - Sair");
    }

    public static void executar() throws Exception {
        while (menu) {
            menuInicial();
            int escolha = capturarDados("Digite a opção desejada").nextInt();
            if (escolha == 1) {
                cadastrarCliente();
            } else if (escolha == 2) {
                cadastrarVendedor();
            } else if (escolha == 3) {
                cadastrarVenda();
            } else if (escolha == 4) {
                ServiceCliente.listarClientesCadastrados();
            } else if (escolha == 5) {
                ServiceVendedor.listarVendedoresCadastrados();
            } else if (escolha == 6) {
                ServiceVenda.listarVendasCadastradas();
            } else if (escolha == 7) {
                String cpf = capturarDados("Qual é o cpf do cliente que você quer consultar?").nextLine();
                ServiceVenda.pesquisarComprasCliente(cpf);
            } else if (escolha == 8) {
                String email = capturarDados("Qual é o email do vendedor que você quer consultar?").nextLine();
                ServiceVenda.pesquisarVendasVendedor(email);
            } else if (escolha == 9) {
                menu = false;
            }
        }
    }

    public static void tratarExcecoes() {
        while (menu) {
            try {
                executar();
            } catch (Exception erro) {
                System.out.println(erro.getMessage());
            }
        }
    }


}
