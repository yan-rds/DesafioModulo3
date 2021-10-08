package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServiceVenda {
    private static List<Venda> listaDeVendas = new ArrayList<>();

    public static Venda cadastrarVenda (String emailCliente, String emailVendedor, double Valor, String data) throws Exception{
        ServiceCliente.encontrarClientePeloEmail(emailCliente);
        ServiceVendedor.encontrarVendedorPeloEmail(emailCliente);
        // Instanciar uma venda com essas informações
        // Adicionar a venda à lista de vendas
        // Retornar Venda
    }

    public static void listarVendasCadastradas() {
        System.out.println("Clientes cadastrados: ");
        if (listaDeVendas.size() == 0){
            System.out.println("No momento não há nenhuma venda cadastrada");
        }
        else {
            for (Venda referencia : listaDeVendas) {
                System.out.println(referencia);
            }
        }

    }
}
