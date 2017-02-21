/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulajava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class AulaJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Aluno> lista = new ArrayList<Aluno>();
        Double mediaTurma = 0.0;
        Aluno aluno = new Aluno();
        
        Integer quantAluno = Integer.parseInt(
                JOptionPane.showInputDialog("Quantos alunos tem?")
        );
        
        for(int i = 1; i <= quantAluno; i++){
            aluno.setNome(JOptionPane.showInputDialog("Digite o nome do "+i+"º aluno:"));
            aluno.setNota1(Double.parseDouble(JOptionPane.showInputDialog("Digite o primeira nota do "+i+"º aluno "+aluno.getNome()+":")));
            aluno.setNota2(Double.parseDouble(JOptionPane.showInputDialog("Digite o segunda nota do "+i+"º aluno "+aluno.getNome()+":")));
            lista.add(aluno);
            mediaTurma = mediaTurma + aluno.getMediaAluno();
            aluno = new Aluno();
        }
        Collections.sort(lista);
        JOptionPane.showMessageDialog(null, lista);
        JOptionPane.showMessageDialog(null, "Média da turma: "+ mediaTurma / quantAluno);
    }
    
}
