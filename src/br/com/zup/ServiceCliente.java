package br.com.zup;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ServiceCliente {

    private static List<Cliente> listaDeClientes = new ArrayList<>();

    public static Cliente cadastrarCliente (String nome, String cpf, String email){
        Cliente cliente = new Cliente(nome, cpf, email);
        listaDeClientes.add(cliente);
        System.out.println("Cliente cadastrado\nNome: " + cliente);
        return cliente;
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

    public static void listarClientesCadastrados() {
        System.out.println("Clientes cadastrados: ");
        listaDeClientes.forEach(System.out::println);
        if (listaDeClientes.size() == 0){
            System.out.println("No momento não há nenhum cliente cadastrado");
        }
    }



}
