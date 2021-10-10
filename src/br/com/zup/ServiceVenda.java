package br.com.zup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ServiceVenda {
    private static List<Venda> listaDeVendas = new ArrayList<>();

    public static Venda cadastrarVenda (String emailCliente, String emailVendedor, double valor, Date data) throws Exception{
        Cliente cliente = ServiceCliente.encontrarClientePeloEmail(emailCliente);
        Vendedor vendedor = ServiceVendedor.encontrarVendedorPeloEmail(emailVendedor);
        Venda venda = new Venda(cliente, vendedor, valor, data);
        listaDeVendas.add(venda);
        System.out.println("Venda cadastrada: \n" + venda);
        return venda;
    }

    public static void listarVendasCadastradas() {
        System.out.println("Vendas cadastrados: ");
        if (listaDeVendas.size() == 0){
            System.out.println("No momento não há nenhuma venda cadastrada");
        }
        else {
            listaDeVendas.forEach(System.out::println);
        }
    }

    public static void pesquisarComprasCliente (String cpf) throws Exception{
        List<Venda> vendasDoCliente = new ArrayList<>();
        for (Venda referencia : listaDeVendas){
            if (referencia.getCliente().getCpf().equals(cpf)){
                System.out.println(referencia);
                vendasDoCliente.add(referencia);
            }
        }
        if (vendasDoCliente.size() == 0) {
            throw new Exception("Não há compras registradas neste CPF");
        }
    }

    public static void pesquisarVendasVendedor (String email) throws Exception{
        List<Venda> vendasDoUsuário = new ArrayList<>();
        for (Venda referencia : listaDeVendas){
            if (referencia.getVendedor().getEmail().equalsIgnoreCase(email)){
                System.out.println(referencia);
                vendasDoUsuário.add(referencia);
            }
        }
        if (vendasDoUsuário.size() == 0) {
            throw new Exception("Este vendedor não realizou vendas");
        }
    }
}
