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
public class Alunos {

    private String nome;
    private String matricula;
    private String telefone;
    private String email;
    private String uffMail;
    private String status;

    /**
     * Como estamos lendo as informações dos alunos de um arquivo, linha por
     * linha, eu resolvi criar um construtor que recebesse um vetor de dados
     * para então criar uma instância de alunos com as informações passadas
     * através desse vetor(o qual é a informação de uma linha do arquivo de
     * Alunos).
     */
    public Alunos(String[] dados) {
        this.nome = dados[0];
        this.matricula = dados[1];
        this.telefone = dados[2];
        this.email = dados[3];
        this.uffMail = dados[4];
        this.status = dados[5];
    }

    /**
     * Esta parte mostra a criação dos métodos getters e setters dos dados do
     * Aluno.
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUffMail() {
        return uffMail;
    }

    public void setUffMail(String uffMail) {
        this.uffMail = uffMail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
