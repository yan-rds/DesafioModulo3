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

    public static void listarVendedoresCadastrados() {
        System.out.println("Clientes cadastrados: ");
        if (listaDeVendedor.size() == 0){
            System.out.println("No momento não há nenhum vendedor cadastrado");
        }
        else {
            for (Vendedor referencia : listaDeVendedor) {
                System.out.println(referencia);
            }
        }

    }
}
