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
    }
}
