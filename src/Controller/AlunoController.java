package Controller;

import Model.Aluno;
import View.AlunoView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlunoController {
    
    public List<Aluno> lerAlunos(String filePath) {
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String matricula = dados[0].trim();
                String nome = dados[1].trim();
                double nota = Double.parseDouble(dados[2].trim());
                Aluno aluno = new Aluno(matricula, nome, nota);
                alunos.add(aluno);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public void gerarResumo(List<Aluno> alunos, String filePath) {
        int totalAlunos = alunos.size();
        int aprovados = 0;
        int reprovados = 0;
        double menorNota = Double.MAX_VALUE;
        double maiorNota = Double.MIN_VALUE;
        double somaNotas = 0;

        for (Aluno aluno : alunos) {
            double nota = aluno.getNota();
            if (nota >= 6.0) {
                aprovados++;
            } else {
                reprovados++;
            }
            if (nota < menorNota) {
                menorNota = nota;
            }
            if (nota > maiorNota) {
                maiorNota = nota;
            }
            somaNotas += nota;
        }

        double mediaNota = somaNotas / totalAlunos;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Quantidade de Alunos: " + totalAlunos + "\n");
            bw.write("Aprovados: " + aprovados + "\n");
            bw.write("Reprovados: " + reprovados + "\n");
            bw.write("Menor Nota: " + menorNota + "\n");
            bw.write("Maior Nota: " + maiorNota + "\n");
            bw.write("Média Geral: " + mediaNota + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        AlunoView view = new AlunoView();
        view.exibirResumo(totalAlunos, aprovados, reprovados, menorNota, maiorNota, mediaNota);
    }
}
