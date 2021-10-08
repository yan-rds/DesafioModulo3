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
}
