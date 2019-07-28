/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 22/10/2018
 * Time: 12:31
 * To change this template use File | Settings | File and Code Templates.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Banco {

    HashMap<String, Cliente> Clientes = new HashMap<>();
    HashMap<String, ArrayList<Conta>> Contas = new HashMap<>();
    ArrayList<Conta> arr = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void montaMenu(){
        escreve("\nBem vindo ao sistema bancário\n");
        escreve("Menu\n");
        escreve("1 - Cadastrar Cliente\n");
        escreve("2 - Cadastrar Conta\n");
        escreve("3 - Consultar Saldo\n");
        escreve("4 - Depositar\n");
        escreve("5 - Sacar\n");
        escreve("6 - Imprimir Dados do Cliente\n");
    }

    public String cadastraCliente(){
        String cpf, nome, logradouro, cidade, uf;
        int numero, cep;

        escreve("Digite o CPF do cliente: ");
        cpf = input.nextLine();
        for(Cliente i : Clientes.values()){
            if(i.getCpf().contains(cpf))
            escreve("Cliente já cadastrado. Voltando ao menu...");
            return "Cliente já cadastrado.";
        }
        escreve("Digite o NOME do cliente: ");
        nome = input.nextLine();
        escreve("Digite o LOGRADOURO do cliente: ");
        logradouro = input.nextLine();
        escreve("Digite o NÚMERO do LOGRADOURO do cliente: ");
        numero = Integer.parseInt(input.nextLine());
        escreve("Digite o CEP do cliente: ");
        cep = Integer.parseInt(input.nextLine());
        escreve("Digite a CIDADE do cliente: ");
        cidade = input.nextLine();
        escreve("Digite o UF do cliente: ");
        uf = input.nextLine();
        Cliente c = new Cliente(cpf, nome, new Endereco(logradouro, cidade, uf, numero, cep));
        this.Clientes.put(cpf, c);

        return "Cliente cadastrado com sucesso.";
    }

    public String cadastraConta(){
        String cpf, agencia, numero;
        double saldo;
        int tipo;
        escreve("Para qual cliente você gostaria de abrir a conta? Digite o CPF do cliente: ");
        cpf = input.nextLine();
        escreve("Digite o número da agência: ");
        agencia = input.nextLine();
        escreve("Digite o número da conta: ");
        numero = input.nextLine();
        escreve("Digite o saldo da conta: ");
        saldo = Double.parseDouble(input.nextLine());
        escreve("Digite o tipo da conta [1] = CORRENTE, [2] = POUPANÇA):  ");
        tipo = Integer.parseInt(input.nextLine());
        while(tipo != 1 && tipo != 2){
            escreve("Tipo de conta não permitido no sistema. Os tipos válidos são 1 ou 2.\n");
            tipo = Integer.parseInt(input.nextLine());
        }
        if(tipo == 1){
            double limite;
            escreve("Digite o limite disponível da conta: ");
            limite = Double.parseDouble(input.nextLine());

            Conta c = new Corrente(limite, agencia, numero, saldo, this.Clientes.get(cpf));
            this.arr.add(c);
            this.Contas.put(cpf, this.arr);

        } else if(tipo == 2){
            Conta c = new Poupanca(agencia, numero, saldo, this.Clientes.get(cpf));
            this.arr.add(c);
            this.Contas.put(cpf, this.arr);
        }

        return String.format("Conta %s vinculada com sucesso para o cliente: %s", numero, this.Clientes.get(cpf).getNome());
    }

    public void consultarSaldo(){
        String numero;
        escreve("Digite o número da conta para consultar o saldo: ");
        numero = input.nextLine();
        for(ArrayList<Conta> data : this.Contas.values()){
            for(int i = 0; i < data.size(); i++){
                if(data.get(i).getNumero().equals(numero)){
                    escreve(data.get(i).consultarSaldo());
                }
            }
        }
    }

    public String depositarValor(){
        String numero;
        double valor;
        escreve("Digite o número da conta: ");
        numero = input.nextLine();
        escreve("Digite o valor para depósito: ");
        valor = Double.parseDouble(input.nextLine());

        for(ArrayList<Conta> data : this.Contas.values()){
            for(int i = 0; i < data.size(); i++){
                if(data.get(i).getNumero().equals(numero)){
                    data.get(i).depositar(valor);
                }
            }
        }

        return "Depósito efetuado com sucesso.";
    }

    public void sacarValor(){
        String numero;
        double valor;
        escreve("Digite o número da conta: ");
        numero = input.nextLine();
        escreve("Digite o valor do saque: ");
        valor = Double.parseDouble(input.nextLine());

        for(ArrayList<Conta> data : this.Contas.values()){
            for(int i = 0; i < data.size(); i++){
                if(data.get(i).getNumero().equals(numero)){
                    data.get(i).sacar(valor);
                }
            }
        }
    }

    public void consultaCorrentista(){
        String cpf;
        ArrayList<String> contasCpf = new ArrayList<>();
        escreve("Digite o cpf da pessoa: ");
        cpf = input.nextLine();

        escreve(this.Clientes.get(cpf).imprimirDados());
        escreve("Contas referentes a esse cliente: \n");

        for(ArrayList<Conta> data : this.Contas.values()){
            for(int i = 0; i < data.size(); i++){
                if(data.get(i).getCliente().getCpf().equals(cpf)){
                    if(!contasCpf.contains(data.get(i).getNumero()))
                        contasCpf.add(data.get(i).getNumero());
                }
            }
        }
        escreve(contasCpf.toString());
    }

    public void escreve(String frase){
         System.out.print(frase);
    }


}
