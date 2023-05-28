package log;

import dao.TipoOperacaoDao;
import entidade.EntidadeInterface;

import java.util.ArrayList;
import java.util.Date;

public class Logger {
    private final LoggerStrategyInterface strategy;

    public Logger(LoggerStrategyInterface strategy) {
        this.strategy = strategy;
    }

    public void log(TipoOperacaoDao operacao, EntidadeInterface entidadeManipulacao) {
        log(operacao, (Object) entidadeManipulacao);
    }

    public void log(TipoOperacaoDao operacao, ArrayList retornoBusca) {
        log(operacao, retornoBusca.size());
    }

    private void log(TipoOperacaoDao operacao, Object valor) {
        var data = new Date();
        var log = switch (operacao) {
            case SALVAR -> "Salvar\n" + data + "\nObjeto salvo: " + valor;
            case BUSCAR -> "Buscar\n" + data + "\nItens buscados: " + valor;
            case DELETAR -> "Deletar\n" + data + "\nObjeto deletado: " + valor;
        } + "\n";
        strategy.log(log);
    }
}
