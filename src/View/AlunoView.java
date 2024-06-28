package View;

public class AlunoView {
    public void exibirResumo(int quantidadeAlunos, int quantidadeAprovados, int quantidadeReprovados, double menorNota, double maiorNota, double mediaGeral) {
        System.out.println("Quantidade de alunos: " + quantidadeAlunos);
        System.out.println("Quantidade de alunos aprovados: " + quantidadeAprovados);
        System.out.println("Quantidade de alunos reprovados: " + quantidadeReprovados);
        System.out.println("Menor nota da turma: " + menorNota);
        System.out.println("Maior nota da turma: " + maiorNota);
        System.out.println("Média geral: " + mediaGeral);
    }
}
