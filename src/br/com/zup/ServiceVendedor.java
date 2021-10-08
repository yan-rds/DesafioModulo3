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

    public static Vendedor encontrarVendedorPeloEmail (String email) throws Exception{
        for (Vendedor referencia : listaDeVendedor){
            if (referencia.getEmail().equalsIgnoreCase(email)){
                return referencia;
            }
        }
        throw new Exception("Não existe um vendedor cadastrado com este email");
    }
}
