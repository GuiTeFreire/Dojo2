package Objetos;

import java.util.Scanner;

public class Menu {
    private Aluno[] alunos = new Aluno[50];
    private int contAlunos = 0;
    private Scanner teclado = new Scanner(System.in);

    public Menu() {
    }

    public void inicializaMenu() {
        int op = -1;
        do {
            System.out.println("O que deseja fazer?");
            System.out.println("(1) - Listar todos os alunos");
            System.out.println("(2) - Adicionar um novo aluno");
            System.out.println("(3) - Deletar um aluno existente");
            System.out.println("(4) - Ler os atributos de um aluno");
            System.out.println("(5) - Alterar a idade de um aluno");
            System.out.println("(0) - Sair do programa");
            op = teclado.nextInt();
            teclado.nextLine();

            switch (op) {
                case 1:
                    this.listarAlunos();
                    break;
                case 2:
                    this.addAluno();
                    break;
                case 3:
                    this.deletaAluno();
                    break;
                case 4:
                    this.checarAluno();
                    break;
                case 5:
                    this.alteraIdade();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Comando inválido. Digite novamente.");
            }
        } while (op != 0);
    }

    private void listarAlunos() {
        System.out.println("Lista de Alunos:\n");
        for (int i = 0; i < contAlunos; i++) {
            System.out.println("Aluno " + (i + 1) + " " + alunos[i]);
        }
    }

    private void addAluno() {
        String nome, matricula;
        int idade;
        Prova[] provas = new Prova[3];
        Prova prova1 = new Prova();
        Prova prova2 = new Prova();
        Prova provaF = new Prova();

        System.out.println("Matrícula do aluno: ");
        matricula = teclado.nextLine();
        System.out.println("Nome do aluno: ");
        nome = teclado.nextLine();
        System.out.println("Idade do aluno: ");
        idade = teclado.nextInt();
        teclado.nextLine();

        alunos[contAlunos] = new Aluno(matricula, nome, idade);

        do {
            System.out.println("Nota da Avaliação 1: ");
            prova1.setNota(teclado.nextFloat());
            if (prova1.getNota() < 0 || prova1.getNota() > 10)
                System.out.println("VALOR DE NOTA INVÁLIDO! DIGITE NOVAMENTE.");
        } while (prova1.getNota() < 0 || prova1.getNota() > 10);

        do {
            System.out.println("Nota da Avaliação 2: ");
            prova2.setNota(teclado.nextFloat());
            if (prova2.getNota() < 0 || prova2.getNota() > 10)
                System.out.println("VALOR DE NOTA INVÁLIDO! DIGITE NOVAMENTE.");
        } while (prova2.getNota() < 0 || prova2.getNota() > 10);

        provas[0] = prova1;
        provas[1] = prova2;
        alunos[contAlunos].setProvas(provas);

        if (alunos[contAlunos].provaFinal()) {
            do {
                System.out.println("Nota da Prova Final: ");
                provaF.setNota(teclado.nextFloat());
                if (provaF.getNota() < 0 || provaF.getNota() > 10)
                    System.out.println("VALOR DE NOTA INVÁLIDO! DIGITE NOVAMENTE.");
            } while (provaF.getNota() < 0 || provaF.getNota() > 10);

            provas[2] = provaF;
            alunos[contAlunos].setProvas(provas);
        }
        contAlunos++;
    }

    private void deletaAluno() {
        int del;
        System.out.println("Qual aluno deseja deletar?");
        del = teclado.nextInt();
        for (int i = del; i < contAlunos; i++) {
            alunos[i - 1] = alunos[i];
        }
        contAlunos--;
    }

    private void checarAluno() {
        int alunoChecar;
        System.out.println("Qual aluno deseja checar os atributos?");
        alunoChecar = teclado.nextInt();
        System.out.println("Atributos do aluno:");
        System.out.println(alunos[alunoChecar - 1]);
    }

    private void alteraIdade() {
        int alunoAlt, alunoIdade;
        System.out.println("Qual aluno deseja alterar a idade?");
        alunoAlt = teclado.nextInt();
        System.out.println("Qual a nova idade do aluno?");
        alunoIdade = teclado.nextInt();
        alunos[alunoAlt - 1].setIdade(alunoIdade);
    }
}
