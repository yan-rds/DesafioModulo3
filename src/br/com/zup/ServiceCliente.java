package br.com.zup;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ServiceCliente {
    // Esta classe possuirá os métodos referentes à manipulação e gerenciamento dos objetos Cliente

    private static List<Cliente> listaDeClientes = new ArrayList<>(); // Lista de clientes cadastrados

    // Este método criará um objeto cliente baseado nos parâmetros dados pelo Sistema e o adicionará à lista.
    public static void cadastrarCliente (String nome, String cpf, String email){
        Cliente cliente = new Cliente(nome, cpf, email);
        listaDeClientes.add(cliente);
        System.out.println("Cliente cadastrado\nNome: " + cliente);
    }

    // Este método utiliza a function Predicate para identificar cadastros duplicados. Caso haja, uma exceção é criada.
    public static void verificarDuplicidadeNoCadastro(String cpfOuEmail) throws Exception{
        Predicate <Cliente> emailDuplicado = Cliente -> Cliente.getEmail().equalsIgnoreCase(cpfOuEmail);
        Predicate <Cliente> cpfDuplicado = Cliente -> Cliente.getCpf().equalsIgnoreCase(cpfOuEmail);
        if (listaDeClientes.stream().anyMatch(emailDuplicado) | listaDeClientes.stream().anyMatch(cpfDuplicado)){
            throw new Exception("Já existe um cliente com este dado cadastrado");
        }
    }

    // Este método procura o Cliente que possui o email que é passado como parâmetro, assim que o encontra, ele o retorna.
    public static Cliente encontrarClientePeloEmail (String email) throws Exception{
        for (Cliente referencia : listaDeClientes){
            if (referencia.getEmail().equalsIgnoreCase(email)){
                return referencia;
            }
        }
        throw new Exception("Não existe um cliente cadastrado com este email");
    }

    // Este método lista todos os clientes cadastrados atráves de referência de método, caso não haja, uma exceção é criada.
    public static void listarClientesCadastrados() throws Exception {
        System.out.println("Clientes cadastrados: ");
        listaDeClientes.forEach(System.out::println);
        listaDeClientes.stream().findFirst().orElseThrow(() -> new Exception("Não há."));
    }
}
