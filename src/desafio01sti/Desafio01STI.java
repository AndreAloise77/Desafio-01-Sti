/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio01sti;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 *
 * @author André
 */
public class Desafio01STI {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Logo de inicio é realizada a criação de algumas variáveis, juntamente
         * do Scanner para a leitura dos comandos do usuário.
         */
        Scanner teclado = new Scanner(System.in);
        String matricula;
        Alunos aluno = null;
        boolean check = true;
        System.out.println("Digite sua matrícula");
        /**
         * Este while indica que todo o arquivo será percorrido, para tentar
         * achar a opção desejada pelo usuário.
         */
        while (check) {
            matricula = teclado.next();
            /**
             * Nessa parte o sistema irá verificar se no arquivo existe alguma
             * matrícula que seja igual a que o usuário informou. Caso ele ache
             * então uma instância da classe Alunos será criada com as
             * informações já existentes sobre ele no arquivo.
             */
            try {
                Scanner scanner = new Scanner(new FileReader("alunos.csv"));
                String line = scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String[] dados = line.split(",");
                    if (dados[1].equals(matricula)) {
                        aluno = new Alunos(dados);
                        check = false;
                        /**
                         * Este comando break é necessário para interromper a
                         * leitura do arquivo assim que a matrícula é encontrada
                         * e cria uma instância de Alunos.
                         */
                        break;
                    } else {
                        line = scanner.nextLine();
                    }
                }
            } catch (FileNotFoundException | NumberFormatException e) {
                System.out.println(e);
            }
            /**
             * Esta verificação é para o caso da matrícula informada pelo
             * usuário não constar no arquivo, ele recebe um alerta para entrar
             * novamente com uma matrícula válida!
             */
            if (aluno == null) {
                System.out.println("A matrícula informada não existe.");
                System.out.println("Por favor entre com um número de matrícula válido para realizar a operação!");
            }
        }
        /**
         * Esta parte consiste na verificação por 3 etapas: 1) Se após o usuário
         * digitar a matricula corretamente o objeto aluno foi criado
         * corretamente. 2) Se o aluno possui o status de Ativo ou Inativo 3) Se
         * o aluno já possui ou não um uffMail.
         */
        if (aluno != null) {
            //
            if (aluno.getStatus().equals("Ativo")) {
                //
                if (aluno.getUffMail().equals("")) {
                    System.out.println("");
                    GeradorUffMail gerador = new GeradorUffMail(aluno);
                    String pNome = gerador.getPrimeiroNome();
                    System.out.println(pNome + ", por favor escolha uma das opções abaixo para o seu UFFMail");
                    String[] sugestoes = gerador.opcoesUffMail();
                    for (int i = 0; i < sugestoes.length; i++) {
                        System.out.println((i + 1) + " - " + sugestoes[i]);
                    }
                    System.out.println("");
                    int opcao = teclado.nextInt();
                    System.out.println("");
                    /**
                     * Neste trecho é feita uma verificação para saber se o
                     * usuário entrou com uma opção válida ou não. Caso ela não
                     * seja válida, o sistema informa e pede uma nova entrada.
                     */
                    boolean escolhaErrada = true;
                    while (escolhaErrada) {
                        if (opcao < 1 || opcao > 5) {
                            System.out.println("Opção Inválida, por favor escolha uma opção válida!");
                            opcao = teclado.nextInt();
                            System.out.println("");
                        } else {
                            System.out.println("A criação de seu e-mail (" + sugestoes[opcao - 1] + ") será feita nos próximos minutos.");
                            String tel = aluno.getTelefone();
                            System.out.println("Um SMS foi enviado para " + tel + " com a sua senha de acesso.");
                            escolhaErrada = false;
                        }
                    }
                } else {
                    System.out.println("O aluno já possui um uffMail cadastrado.");
                    System.out.println("infelizmente não é possível criar um novo para este aluno!");
                }
            } else {
                System.out.println("No momento este aludo se encontra com o status de Inativo.");
                System.out.println("Sendo assim não é possível realizar a criação de um uffMail para o mesmo!");
            }
        }
    }
}