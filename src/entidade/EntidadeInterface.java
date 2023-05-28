package entidade;

public interface EntidadeInterface {
    int getId();
    void setId(int id);
    String toString();
    default boolean Equals(Object o) {
        try {
            var entidade = (EntidadeInterface) o;
            return entidade.getId() == getId();
        } catch (ClassCastException e) {
            return o.equals(this);
        }
    }
}
