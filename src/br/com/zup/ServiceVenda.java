package br.com.zup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class ServiceVenda {
    // Esta classe possuirá os métodos referentes à manipulação e gerenciamento dos objetos Venda

    private static List<Venda> listaDeVendas = new ArrayList<>(); // Lista de vendas cadastradas

    // Este método recebe como parâmetro as informações necessárias para instanciar uma Venda, e em seguida a adiciona a lista.
    public static void cadastrarVenda (String emailCliente, String emailVendedor, double valor, Date data) throws Exception{
        Cliente cliente = ServiceCliente.encontrarClientePeloEmail(emailCliente); // O dono deste email é adicionado à esta variável
        Vendedor vendedor = ServiceVendedor.encontrarVendedorPeloEmail(emailVendedor); // O mesmo que acima
        Venda venda = new Venda(cliente, vendedor, valor, data);
        listaDeVendas.add(venda);
        System.out.println("Venda cadastrada: \n" + venda);
    }

    // Este método utiliza referência de método para listar todas as vendas, caso não haja, uma exceção é gerada pela Stream.
    public static void listarVendasCadastradas() throws Exception{
        System.out.println("Vendas cadastrados: ");
        listaDeVendas.forEach(System.out::println);
        listaDeVendas.stream().findFirst().orElseThrow(() -> new Exception("Não há."));
    }

    // Este método utiliza a function Predicate para encontrar Vendas de um determinado cliente.
    // Aqui todas as vendas que possuem o CPF igual ao do parâmetro são filtradas e uma a uma, printadas.
    // Caso não haja, uma exceçao é gerada.
    public static void pesquisarComprasCliente (String cpf) throws Exception{
        Predicate<Venda> vendasEncontradas = Vendas -> Vendas.getCliente().getCpf().equals(cpf);//Criar a lógica (lambda)
        listaDeVendas.stream().filter(vendasEncontradas).forEach(System.out::println);// Filtrar baseado na lógica acima
        if (listaDeVendas.stream().noneMatch(vendasEncontradas)) {// Gerar exceção
            throw new Exception("Não há compras neste Cpf");
        }
    }

    // Mesma lógica que o método acima, contudo passando o email como parâmetro desta vez.
    public static void pesquisarVendasVendedor (String email) throws Exception{
        Predicate<Venda> vendasEncontradas = Vendas -> Vendas.getVendedor().getEmail().equals(email);
        listaDeVendas.stream().filter(vendasEncontradas).forEach(System.out::println);
        if (listaDeVendas.stream().noneMatch(vendasEncontradas)) {
            throw new Exception("Não há compras neste Cpf");
        }
    }
}
