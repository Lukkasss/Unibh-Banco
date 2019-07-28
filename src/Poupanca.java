/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 20/10/2018
 * Time: 16:18
 * To change this template use File | Settings | File and Code Templates.
 */
public class Poupanca extends Conta{

    public Poupanca() {
    }

    public Poupanca(String agencia, String numero, double saldo, Cliente cliente) {
        super(agencia, numero, saldo, cliente);
    }

    @Override
    public String sacar(double valor) {
        if(!temSaldo(valor))
            return String.format("O limite da sua conta não permite essa operação. Seu limite atual é: %.2f", this.getSaldo());
         else {
            this.setSaldo(this.getSaldo() - valor);
            return String.format("Operação realizada com sucesso. Seu novo saldo é: %.2f", this.getSaldo());
        }
    }

    @Override
    public String consultarSaldo() {
        return String.format("O limite da sua conta é: %8.2f", this.getSaldo());
    }
}
