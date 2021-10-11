package br.com.zup;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ServiceVendedor {
    // Esta classe possuirá os métodos referentes à manipulação e gerenciamento dos objetos Vendedor

    private static List<Vendedor> listaDeVendedor = new ArrayList<>(); // Lista de vendedores cadastrados

    // Este método criará um objeto vendedor baseado nos parâmetros dados pelo Sistema e o adicionará à lista.
    public static void cadastrarVendedor(String nome, String cpf, String email){
        Vendedor vendedor = new Vendedor(nome, cpf, email);
        listaDeVendedor.add(vendedor);
        System.out.println("Vendedor cadastrado\nNome: " + vendedor);
    }

    // Este método procura o Vendedor que possui o email que é passado como parâmetro, assim que o encontra, ele o retorna.
    public static Vendedor encontrarVendedorPeloEmail (String email) throws Exception{
        for (Vendedor referencia : listaDeVendedor) {
            if (referencia.getEmail().equalsIgnoreCase(email)) {
                return referencia;
            }
        }
        throw new Exception("Não existe um vendedor cadastrado com este email");
    }

    // Este método lista todos os vendedores cadastrados atráves de referência de método, caso não haja, uma exceção é criada.
    public static void listarVendedoresCadastrados() throws Exception {
        System.out.println("Vendedores cadastrados: ");
        listaDeVendedor.forEach(System.out::println);
        listaDeVendedor.stream().findFirst().orElseThrow(() -> new Exception("Não há."));
    }

    // Este método utiliza a function Predicate para identificar cadastros duplicados. Caso haja, uma exceção é criada.
    public static void verificarDuplicidadeNoCadastro(String cpfOuEmail) throws Exception{
        Predicate <Vendedor> emailDuplicado = Vendedor -> Vendedor.getEmail().equalsIgnoreCase(cpfOuEmail);
        Predicate <Vendedor> cpfDuplicado = Vendedor -> Vendedor.getCpf().equalsIgnoreCase(cpfOuEmail);
        if (listaDeVendedor.stream().anyMatch(emailDuplicado) | listaDeVendedor.stream().anyMatch(cpfDuplicado)){
            throw new Exception("Já existe um vendedor com este dado cadastrado.");
        }
    }
}
