import dao.Dao;
import dao.DaoLogDecorator;
import dao.TarefaDao;
import entidade.tarefa.ProxyValidacaoTarefa;
import entidade.tarefa.TarefaInterface;
import log.Logger;
import log.LoggerConsoleStrategy;

public class Main {
    public static void main(String[] args) {
        TarefaInterface tarefa = new ProxyValidacaoTarefa();
        tarefa.setTitulo("Teste");
        tarefa.realizar();
        tarefa.concluir();

        Dao<TarefaInterface> dao = new TarefaDao();
        var logger = new Logger(new LoggerConsoleStrategy());
        dao = new DaoLogDecorator<>(dao, logger);

        dao.salvar(tarefa);
        dao.buscar();
        dao.deletar(tarefa);
    }
}
