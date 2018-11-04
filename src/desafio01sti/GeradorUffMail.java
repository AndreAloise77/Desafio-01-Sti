/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio01sti;

/**
 *
 * @author André
 */
public class GeradorUffMail {

    private String[] nomes;

    public GeradorUffMail(Alunos aluno) {
        /**
         * Este vertor vai receber o nome completo do aluno, passar para letras
         * minúsculas e separá-lo pelos espaços entre o primeiro nome, nome do
         * meio e ultimo nome.
         */
        nomes = aluno.getNome().toLowerCase().split(" ");
    }

    /**
     * Este método tem como objetivo gerar todas as opções/sugestões já prontas
     * para o aluno escolher na hora de criar seu uffMail, logo o seu retorno é
     * um vetor de Strings(as opções no caso).
     */
    public String[] opcoesUffMail() {
        String[] opcoes = new String[5];
        //
        opcoes[0] = nomes[0] + "_" + nomes[1] + "@id.uff.br";
        //
        opcoes[1] = nomes[0] + primeiraLetra(nomes[1]) + primeiraLetra(nomes[2]) + "@id.uff.br";
        //
        opcoes[2] = nomes[0] + nomes[2] + "@id.uff.br";
        //
        opcoes[3] = primeiraLetra(nomes[0]) + nomes[2] + "@id.uff.br";
        //
        opcoes[4] = primeiraLetra(nomes[0]) + nomes[1] + nomes[2] + "@id.uff.br";
        //
        return opcoes;
    }

    /**
     * Este método serve como apoio para a realização da tarefa de gerar as
     * opções de email, ele basicamente pega a primeira letra do nome e retorna
     * essa letra em forma de String.
     */
    private String primeiraLetra(String nome) {
        char pLetra = nome.charAt(0);
        String resultado = Character.toString(pLetra);
        return resultado;
    }

    public String getPrimeiroNome() {
        return nomes[0];
    }
}