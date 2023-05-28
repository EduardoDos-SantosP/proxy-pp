package entidade.tarefa;

import java.util.Date;

public class ProxyValidacaoTarefa implements TarefaInterface {
    private final TarefaInterface tarefa;

    public ProxyValidacaoTarefa() {
        this(new Tarefa());
    }

    public ProxyValidacaoTarefa(TarefaInterface tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void realizar() {
        if (getStatus() == StatusTarefa.FEITO)
            throw new RuntimeException("A tarefa não pode ser feita pois já foi concluída");
        tarefa.realizar();
    }

    @Override
    public void concluir() {
        if (getStatus() == StatusTarefa.A_FAZER)
            throw new RuntimeException("Para concluir a tarefa primeiro inicie sua realização");
        tarefa.realizar();
    }

    @Override
    public int getId() {
        return tarefa.getId();
    }

    @Override
    public void setId(int id) {
        tarefa.setId(id);
    }

    @Override
    public String getTitulo() {
        return tarefa.getTitulo();
    }

    @Override
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.equals(""))
            throw new RuntimeException("Título não pode ser vazio");
        if (titulo.length() > 127)
            throw new RuntimeException("Título deve ter no máximo 127 caracteres");
        tarefa.setTitulo(titulo);
    }

    @Override
    public String getDescricao() {
        return tarefa.getDescricao();
    }

    @Override
    public void setDescricao(String descricao) {
        if (descricao.length() > 511)
            throw new RuntimeException("Descrição deve ter no máximo 511 caracteres");
        tarefa.setDescricao(descricao);
    }

    @Override
    public Date getDataCriacao() {
        return tarefa.getDataCriacao();
    }

    @Override
    public Date getDataRealizacao() {
        return tarefa.getDataRealizacao();
    }

    @Override
    public Date getDataConclusao() {
        return tarefa.getDataConclusao();
    }

    @Override
    public StatusTarefa getStatus() {
        return tarefa.getStatus();
    }

    @Override
    public String toString() {
        return tarefa.toString();
    }
}
