package br.com.zup;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ServiceCliente {

    private static List<Cliente> listaDeClientes = new ArrayList<>();

    public static void cadastrarCliente (String nome, String cpf, String email){
        Cliente cliente = new Cliente(nome, cpf, email);
        listaDeClientes.add(cliente);
        System.out.println("Cliente cadastrado\nNome: " + cliente);
    }

    public static void verificarDuplicidadeNoCadastro(String cpfOuEmail) throws Exception{
        Predicate <Cliente> emailDuplicado = Cliente -> Cliente.getEmail().equalsIgnoreCase(cpfOuEmail);
        Predicate <Cliente> cpfDuplicado = Cliente -> Cliente.getCpf().equalsIgnoreCase(cpfOuEmail);
        if (listaDeClientes.stream().anyMatch(emailDuplicado) | listaDeClientes.stream().anyMatch(cpfDuplicado)){
            throw new Exception("Já existe um cliente com este dado cadastrado");
        }
    }

    public static Cliente encontrarClientePeloEmail (String email) throws Exception{
        for (Cliente referencia : listaDeClientes){
            if (referencia.getEmail().equalsIgnoreCase(email)){
                return referencia;
            }
        }
        throw new Exception("Não existe um cliente cadastrado com este email");
    }

    public static void listarClientesCadastrados() throws Exception {
        System.out.println("Clientes cadastrados: ");
        listaDeClientes.forEach(System.out::println);
        listaDeClientes.stream().findFirst().orElseThrow(() -> new Exception("Não há."));
    }
}
