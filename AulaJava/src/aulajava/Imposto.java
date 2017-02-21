/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulajava;

import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Imposto {
    public static void main(String[] args) {
        Fisica p1 = new Fisica();
        p1.setCpf("12345");
        p1.setNome("Alex");
        p1.setSalario(1700.0);
        
        Juridica p2 = new Juridica();
        p2.setCnpj("12345");
        p2.setNome("Pedertronica");
        p2.setSalario(255700.0);
        
        JOptionPane.showMessageDialog(null, "imposto do "+p1.getNome()+" é "+ p1.getCalculaImposto());
        JOptionPane.showMessageDialog(null, "imposto do "+p2.getNome()+" é "+ p2.getCalculaImposto());
    }
}
