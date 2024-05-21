// Crie um programa que gerencie informações sobre empregados. O programa deve permitir ao usuário inserir o primeiro nome, sobrenome e salário mensal de um empregado, calcular o salário anual e aplicar um aumento de 10% no salário mensal. É necessário garantir que o salário mensal seja um valor positivo. Se o usuário inserir um valor negativo para o salário, o programa deve tratar a exceção, e informar ao usuário sobre o erro e solicitar um valor válido (positivo).


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            try {
                System.out.println("Informe o primeiro nome do empregado:");
                String primeiroNome = input.nextLine();

                System.out.println("Informe o sobrenome do empregado:");
                String sobrenome = input.nextLine();

                float salarioMensal = 0;
                boolean salarioValido = false;

                while (!salarioValido) {
                    try {
                        System.out.println("Informe o salário mensal do empregado: R$ ");
                        salarioMensal = input.nextFloat();
                        input.nextLine(); 

                        if (salarioMensal <= 0) {
                            throw new IllegalArgumentException("O salário mensal deve ser um valor positivo.");
                        }

                        salarioValido = true; 

                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                        System.out.println("Por favor, insira um valor válido.");
                    }
                }

                Empregado empregado = new Empregado(primeiroNome, sobrenome, salarioMensal);

                System.out.println("Salário anual do empregado: R$ " + empregado.calcularSalarioAnual());
                empregado.aumentarSalario();
                System.out.println("\nApós aumento de salário:");
                System.out.println("Novo salário anual do empregado: R$ " + empregado.calcularSalarioAnual());

            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            } finally {
                System.out.println("\nDeseja informar sobre outro empregado? (S/N)");
                choice = input.nextLine();
            }
        } while (choice.equalsIgnoreCase("S"));

        input.close();
    }
}

// Solução: Usei o tratamento de exceção para verificar se o usuário colocou um valor negativo no salário, se esse for o caso, criei um loop que sinaliza o erro e pede que o usuário insira um valor positivo. O loop só vai parar quando o usuário inserir um valor positivo. Também coloquei um tratamento de exceção mais geral para qualquer problema que ocorra no programa.
