package dao;

import entidade.EntidadeInterface;

import java.util.ArrayList;

public abstract class Dao<T extends EntidadeInterface> {
    private ArrayList<T> banco = new ArrayList<>();

    public void salvar(T entidade) {
        if (entidade.getId() > 0) {
            banco.set(banco.indexOf(entidade), entidade);
        } else {
            banco.add(entidade);
            entidade.setId(banco.size());
        }
    }

    public ArrayList<T> buscar() {
        return banco;
    }

    public void deletar(T entidade) {
        banco.remove(entidade);
    }
}
