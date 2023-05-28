package dao;

import entidade.EntidadeInterface;
import log.Logger;

import java.util.ArrayList;

public class DaoLogDecorator<T extends EntidadeInterface> extends Dao<T> {
    private Dao<T> dao;
    private Logger logger;

    public DaoLogDecorator(Dao<T> dao, Logger logger) {
        this.dao = dao;
        this.logger = logger;
    }

    @Override
    public void salvar(T entidade) {
        logger.log(TipoOperacaoDao.SALVAR, entidade);
        super.salvar(entidade);
    }

    @Override
    public ArrayList<T> buscar() {
        var retorno = super.buscar();
        logger.log(TipoOperacaoDao.BUSCAR, retorno);
        return retorno;
    }

    @Override
    public void deletar(T entidade) {
        logger.log(TipoOperacaoDao.DELETAR, entidade);
        super.deletar(entidade);
    }
}
