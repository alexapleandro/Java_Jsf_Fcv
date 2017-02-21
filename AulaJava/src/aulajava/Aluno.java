/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulajava;

/**
 *
 * @author Aluno
 */
public class Aluno implements Comparable<Aluno>{
    private String nome;
    private Double nota1;
    private Double nota2;
    
    public Double getMediaAluno(){
        return (nota1 + nota2) / 2;
    }
    
    public String getSituacao(){
        if(getMediaAluno() >= 6.0){
            return "Aprovado";
        }else{
            return "Reprovado";
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }
    
    @Override
    public String toString(){
        return nome + ": ( "+ nota1+" - "+nota2+")  Média: "+getMediaAluno()+" Situacão: "+getSituacao()+"\n";
    }

    @Override
    public int compareTo(Aluno o) {
        return this.nome.compareTo(o.getNome());
    }
}
