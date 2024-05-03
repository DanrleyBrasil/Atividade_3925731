import java.util.Scanner;

public class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public ContaBancaria(String nome, String sobrenome, String cpf, double saldoInicial) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = saldoInicial;
    }

    public void depositar(double quantia) {
        if (quantia > 0) {
            saldo += quantia;
            System.out.println("Depósito realizado com sucesso! Seu saldo atual é R$ " + saldo);
        } else {
            System.out.println("Por favor, informe uma quantia válida para depósito.");
        }
    }

    public void sacar(double quantia) {
        if (quantia > 0 && saldo >= quantia) {
            saldo -= quantia;
            System.out.println("Saque realizado com sucesso! Seu saldo atual é R$ " + saldo);
        } else {
            System.out.println("Operação não realizada. Verifique se o saldo é suficiente e a quantia é válida.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Seu saldo atual é R$ " + saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Informe seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Informe seu CPF: ");
        String cpf = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf, 0);

        int opcao = 0;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Informe a quantia para depósito: R$ ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Informe a quantia para saque: R$ ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 4:
                    System.out.println("Encerrando o sistema. Obrigado por usar nosso serviço!");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção entre 1 e 4.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
