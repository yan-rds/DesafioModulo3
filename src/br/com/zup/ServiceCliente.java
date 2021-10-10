package br.com.zup;

import java.util.ArrayList;
import java.util.List;

public class ServiceCliente {

    private static List<Cliente> listaDeClientes = new ArrayList<>();

    public static Cliente cadastrarCliente (String nome, String cpf, String email){
        Cliente cliente = new Cliente(nome, cpf, email);
        listaDeClientes.add(cliente);
        System.out.println("Cliente cadastrado\nNome: " + cliente);
        return cliente;
    }

    public static void verificarDuplicidadeNoCadastro(String cpfOuEmail) throws Exception{
        for (Cliente referencia : listaDeClientes){
            if (referencia.getEmail().equalsIgnoreCase(cpfOuEmail)){
                throw new Exception("Já existe um cliente cadastrado com este email");
            }
            else if (referencia.getCpf().equalsIgnoreCase(cpfOuEmail)){
                throw new Exception("Já existe um cliente cadastrado com este cpf");
            }
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
        if (listaDeClientes.size() == 0){
            System.out.println("No momento não há nenhum cliente cadastrado");
        }
        else {
            for (Cliente referencia : listaDeClientes) {
                System.out.println(referencia);
            }
        }

    }



}
