package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServiceVendedor {


    private static List<Vendedor> listaDeVendedor = new ArrayList<>();

    public static Vendedor cadastrarVendedor(String nome, String cpf, String email){
        Vendedor vendedor = new Vendedor(nome, cpf, email);
        listaDeVendedor.add(vendedor);
        System.out.println("Vendedor cadastrado\nNome: " + vendedor);
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
        System.out.println("Vendedores cadastrados: ");
        if (listaDeVendedor.size() == 0){
            System.out.println("No momento não há nenhum vendedor cadastrado");
        }
        else {
            listaDeVendedor.forEach(vendedor -> System.out.println(vendedor));
        }

    }

    public static void verificarDuplicidadeNoCadastro(String cpfOuEmail) throws Exception{
        for (Vendedor referencia : listaDeVendedor){
            if (referencia.getEmail().equalsIgnoreCase(cpfOuEmail)){
                throw new Exception("Já existe um vendedor cadastrado com este email");
            }
            else if (referencia.getCpf().equalsIgnoreCase(cpfOuEmail)){
                throw new Exception("Já existe um vendedor cadastrado com este cpf");
            }
        }
    }
}
