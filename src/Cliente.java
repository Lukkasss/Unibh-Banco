/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 20/10/2018
 * Time: 16:18
 * To change this template use File | Settings | File and Code Templates.
 */
public class Cliente {

    private String cpf, nome;
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String imprimirDados(){
        return String.format("CPF: %s\nNome: %s\n%s", this.getCpf(), this.getNome(), this.endereco.imprimirDados());
    }

}
