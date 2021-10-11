package br.com.zup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class ServiceVenda {
    private static List<Venda> listaDeVendas = new ArrayList<>();

    public static void cadastrarVenda (String emailCliente, String emailVendedor, double valor, Date data) throws Exception{
        Cliente cliente = ServiceCliente.encontrarClientePeloEmail(emailCliente);
        Vendedor vendedor = ServiceVendedor.encontrarVendedorPeloEmail(emailVendedor);
        Venda venda = new Venda(cliente, vendedor, valor, data);
        listaDeVendas.add(venda);
        System.out.println("Venda cadastrada: \n" + venda);
    }

    public static void listarVendasCadastradas() throws Exception{
        System.out.println("Vendas cadastrados: ");
        listaDeVendas.forEach(System.out::println);
        listaDeVendas.stream().findFirst().orElseThrow(() -> new Exception("Não há."));
    }

    public static void pesquisarComprasCliente (String cpf) throws Exception{
        Predicate<Venda> vendasEncontradas = Vendas -> Vendas.getCliente().getCpf().equals(cpf);
        listaDeVendas.stream().filter(vendasEncontradas).forEach(System.out::println);
        if (listaDeVendas.stream().noneMatch(vendasEncontradas)) {
            throw new Exception("Não há compras neste Cpf");
        }
    }

    public static void pesquisarVendasVendedor (String email) throws Exception{
        Predicate<Venda> vendasEncontradas = Vendas -> Vendas.getCliente().getEmail().equals(email);
        listaDeVendas.stream().filter(vendasEncontradas).forEach(System.out::println);
        if (listaDeVendas.stream().noneMatch(vendasEncontradas)) {
            throw new Exception("Não há compras neste Cpf");
        }
    }
}
