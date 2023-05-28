package entidade.tarefa;

import entidade.Entidade;

import java.util.Date;

public class Tarefa extends Entidade implements TarefaInterface {
    private String titulo;
    private String descricao;
    private Date dataCriacao;
    private Date dataRealizacao;
    private Date dataConclusao;
    private StatusTarefa status;

    public Tarefa() {
        this.dataCriacao = new Date();
        status = StatusTarefa.A_FAZER;
    }

    public void realizar() {
        dataRealizacao = new Date();
        status = StatusTarefa.FAZENDO;
    }

    public void concluir() {
        dataConclusao = new Date();
        status = StatusTarefa.FEITO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return getId() + " - " + getTitulo();
    }
}
