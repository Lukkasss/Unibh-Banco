/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 20/10/2018
 * Time: 16:18
 * To change this template use File | Settings | File and Code Templates.
 */
public class Endereco {

    private String logradouro, cidade, uf;
    private int numero, cep;

    public Endereco() {
    }

    public Endereco(String logradouro, String cidade, String uf, int numero, int cep) {
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String imprimirDados(){
        return String.format("Logradouro: %s\nNúmero: %d\nCidade:%s\nEstado: %s\nCEP: %d\n", this.getLogradouro(), this.getNumero(), this.getCidade(), this.getUf(), this.getCep());
    }
}
