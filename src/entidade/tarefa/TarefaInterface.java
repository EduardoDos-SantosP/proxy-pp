package entidade.tarefa;

import entidade.EntidadeInterface;

import java.util.Date;

public interface TarefaInterface extends EntidadeInterface {
    void realizar();
    void concluir();

    String getTitulo();
    void setTitulo(String titulo);

    String getDescricao();
    void setDescricao(String descricao);

    Date getDataCriacao();
    Date getDataRealizacao();
    Date getDataConclusao();
    StatusTarefa getStatus();
}
