package br.com.zup;


import java.text.DateFormat;
import java.util.Date;

public class Venda {
    private Cliente cliente;
    private Vendedor vendedor;
    private double valor;
    private Date data;
    private DateFormat dataFormatada = DateFormat.getDateTimeInstance();


    public Venda(Cliente cliente, Vendedor vendedor, double valor, Date data) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valor = valor;
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder concatenador = new StringBuilder();
        concatenador.append("\n\tDados da venda:");
        concatenador.append("\nCliente: " + cliente);
        concatenador.append("\nVendedor: " + vendedor);
        concatenador.append("\nValor: R$ " + valor);
        concatenador.append("\nData de registro: " + dataFormatada.format((data)));
        return concatenador.toString();
    }
}
