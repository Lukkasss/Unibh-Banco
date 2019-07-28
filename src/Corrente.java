/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 20/10/2018
 * Time: 16:18
 * To change this template use File | Settings | File and Code Templates.
 */
public class Corrente extends Conta{

    private double limite, limiteInicial;

    public Corrente() {
    }

    public Corrente(double limite) {
        this.limite = limite;
    }

    public Corrente(double limite, String agencia, String numero, double saldo, Cliente cliente) {
        super(agencia, numero, saldo, cliente);
        this.limite = limite;
        this.limiteInicial = this.getLimite();
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldoTotal(){
        return this.getSaldo() + this.getLimite();
    }

    @Override
    public void depositar(double valor){
        if(this.getSaldo() < 0){
            this.setSaldo(this.getSaldo() + valor);
            this.setLimite(valor);
        }
        else {
            this.setSaldo(this.getSaldo() + valor);
            this.setLimite(this.limiteInicial);
        }
    }

    @Override
    public String sacar(double valor) {
        if(!temSaldo(valor)) {
            if (getSaldo() + getLimite() > valor) {
                this.setSaldo(-((this.getSaldo() + this.getLimite()) - valor));
                this.setLimite(0);
                return String.format("Operação efetuada. Seu novo saldo é: %.2f", this.getSaldoTotal());
            } else {
                return String.format("Operação não realizada. Você não tem limite suficiente. Seu saldo é: %.2f", this.getSaldoTotal());
            }
        } else {
            this.setSaldo(this.getSaldo() - valor);
            return String.format("Operação efetuada. Seu novo saldo é: %.2f", this.getSaldoTotal());
        }
    }

    @Override
    public String consultarSaldo() {
        return String.format("O limite da sua conta é: %.2f", this.getSaldo() + this.getLimite());
    }
}
