import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 20/10/2018
 * Time: 16:28
 * To change this template use File | Settings | File and Code Templates.
 */
public class Main {
    public static void main(String[] args) {
        Integer optionId = null;
        Banco banco = new Banco();
        Scanner input = new Scanner(System.in);
        ArrayList<Conta> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();

        do {

            banco.montaMenu();
            optionId = Integer.parseInt(input.nextLine());

            switch (optionId) {
                case 1:
                    banco.cadastraCliente();
                    break;
                case 2:
                    banco.cadastraConta();
                    break;
                case 3:
                    banco.consultarSaldo();
                    break;
                case 4:
                    banco.depositarValor();
                    break;
                case 5:
                    banco.sacarValor();
                    break;
                case 6:
                    banco.consultaCorrentista();
                    break;
            }
        }
        while(optionId != 0);
        System.out.println("Sistema encerrado.");
    }
}
