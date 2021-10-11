package br.com.zup;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Sistema {
    // Essa classe fará a interação usuário/programa, recebendo dados e exibindo informações.

    private static boolean menu = true; // Variável estática acessada pelos métodos Executar e TratarExceções

    // Método que envia uma mensagem ao usuário e recebe uma resposta
    private static Scanner capturarDados (String mensagem){
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    // Método que recebe as informações necessárias para cadastro de uma venda e as valida, registrando data e horário.
    public static void cadastrarVenda() throws Exception{
        String emailCliente = capturarDados("Digite o email do cliente que deseja cadastrar esta venda").nextLine();
        Validadores.validarEmail(emailCliente);
        String emailVendedor = capturarDados("Digite o email do vendedor que realizou a venda").nextLine();
        Validadores.validarEmail(emailVendedor);
        double valor = capturarDados("Qual é o valor desta venda").nextDouble();
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        ServiceVenda.cadastrarVenda(emailCliente, emailVendedor, valor, data);
    }

    // Método que recebe as informações necessárias para cadastro de um cliente e as valida.
    public static void cadastrarCliente() throws Exception{
        String nome = capturarDados("Qual é o nome do cliente?").nextLine();
        String cpf = capturarDados(("Qual é o CPF do cliente:")).nextLine();
        Validadores.validarCpf(cpf);
        ServiceCliente.verificarDuplicidadeNoCadastro(cpf);
        String email = capturarDados("Qual é o email do cliente?").nextLine();
        Validadores.validarEmail(email);
        ServiceCliente.verificarDuplicidadeNoCadastro(email);
        ServiceCliente.cadastrarCliente(nome, cpf, email);
    }

    // Método que recebe as informações necessárias para cadastrar um vendedor e as valida
    public static void cadastrarVendedor() throws Exception{
        String nome = capturarDados("Qual é o nome do vendedor?").nextLine();
        String cpf = capturarDados(("Qual é o CPF do vendedor?:")).nextLine();
        Validadores.validarCpf(cpf);
        ServiceVendedor.verificarDuplicidadeNoCadastro(cpf);
        String email = capturarDados("Qual é o email do vendedor?").nextLine();
        ServiceVendedor.verificarDuplicidadeNoCadastro(email);
        Validadores.validarEmail(email);
        ServiceVendedor.cadastrarVendedor(nome, cpf, email);
    }

    // Este método exibe o menu inicial para o usuário
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

    // Este método recebe o CPF do cliente para fins de pesquisa e o valida.
    public static void consultarComprasCliente() throws Exception{
        String cpf = capturarDados("Qual é o cpf do cliente que você quer consultar?").nextLine();
        Validadores.validarCpf(cpf);
        ServiceVenda.pesquisarComprasCliente(cpf);
    }

    // Este método recebe o E-mail do vendedor para fins de pesquisa e o valida.
    public static void pesquisarVendasVendedor() throws Exception{
        String email = capturarDados("Qual é o email do vendedor que você quer consultar?").nextLine();
        Validadores.validarEmail(email);
        ServiceVenda.pesquisarVendasVendedor(email);
    }

    // Este método executa todos os métodos acima, possibilitando a navegação do usuário pelas opções do programa.
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
                consultarComprasCliente();
            } else if (escolha == 8) {
                pesquisarVendasVendedor();
            } else if (escolha == 9) {
                menu = false;
            }
        }
    }

    // Por fim, este método trata as exceções que o método executar acumulou de todos os demais métodos.
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
