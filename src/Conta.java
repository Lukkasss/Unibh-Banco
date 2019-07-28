/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 20/10/2018
 * Time: 16:17
 * To change this template use File | Settings | File and Code Templates.
 */
public abstract class Conta {

    private String agencia, numero;
    private double saldo;
    private Cliente cliente;

    public abstract String sacar(double valor);
    public abstract String consultarSaldo();

    public Conta() {
    }

    public Conta(String agencia, String numero, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    public boolean temSaldo(double valor){
        if(valor > this.getSaldo())
            return false;
        else
            return true;
    }
}
