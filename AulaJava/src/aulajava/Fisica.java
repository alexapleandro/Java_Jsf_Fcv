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
public class Fisica  extends Pessoa{
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public Double getCalculaImposto() {
        if(getSalario() <= 1400.0){
            return 0.0;
        }else if(getSalario() <= 2100.0){
            return getSalario() * 0.10;
        }else if(getSalario() <= 2800.0){
            return getSalario() * 0.15;
        }else if(getSalario() <= 3600.0){
            return getSalario() * 0.25;
        }
        return getSalario() * 0.30;
    }
}
