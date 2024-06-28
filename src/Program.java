import Controller.AlunoController;
import Model.Aluno;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        AlunoController controller = new AlunoController();
        List<Aluno> alunos = controller.lerAlunos("bd/aluno.csv");
        controller.gerarResumo(alunos, "bd/resumo.csv");
    }
}
