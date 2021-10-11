package br.com.zup;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ServiceVendedor {


    private static List<Vendedor> listaDeVendedor = new ArrayList<>();

    public static Vendedor cadastrarVendedor(String nome, String cpf, String email){
        Vendedor vendedor = new Vendedor(nome, cpf, email);
        listaDeVendedor.add(vendedor);
        System.out.println("Vendedor cadastrado\nNome: " + vendedor);
        return vendedor;
    }

   /* public static Vendedor encontrarVendedorPeloEmail (String email) throws Exception{
        Predicate<Vendedor> vendedorEncontrado = Vendedor -> Vendedor.getEmail().equals(email);
        Function<Vendedor, Vendedor> retornarVendedor = Vendedor -> Vendedor;
        listaDeVendedor.stream().filter(vendedorEncontrado)
        return retornarVendedor;


        throw new Exception("Não existe um vendedor cadastrado com este email");
    }*/

    public static Vendedor encontrarVendedorPeloEmail (String email) throws Exception{
        for (Vendedor referencia : listaDeVendedor) {
            if (referencia.getEmail().equalsIgnoreCase(email)) {
                return referencia;
            }
        }
        throw new Exception("Não existe um vendedor cadastrado com este email");
    }


    public static void listarVendedoresCadastrados() {
        System.out.println("Vendedores cadastrados: ");
        listaDeVendedor.forEach(System.out::println);
        if (listaDeVendedor.size() == 0){
            System.out.println("No momento não há nenhum vendedor cadastrado");
        }
    }

    public static void verificarDuplicidadeNoCadastro(String cpfOuEmail) throws Exception{
        Predicate <Vendedor> emailDuplicado = Vendedor -> Vendedor.getEmail().equalsIgnoreCase(cpfOuEmail);
        Predicate <Vendedor> cpfDuplicado = Vendedor -> Vendedor.getCpf().equalsIgnoreCase(cpfOuEmail);
        if (listaDeVendedor.stream().anyMatch(emailDuplicado) | listaDeVendedor.stream().anyMatch(cpfDuplicado)){
            throw new Exception("Já existe um vendedor com este dado cadastrado");
        }
    }
}
