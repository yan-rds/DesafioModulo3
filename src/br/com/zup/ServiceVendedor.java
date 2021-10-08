package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServiceVendedor {

    private static List<Vendedor> listaDeVendedor = new ArrayList<>();

    public static Vendedor cadastrarVendedor(String nome, String cpf, String email){
        Vendedor vendedor = new Vendedor(nome, cpf, email);
        listaDeVendedor.add(vendedor);
        return vendedor;
    }
}
