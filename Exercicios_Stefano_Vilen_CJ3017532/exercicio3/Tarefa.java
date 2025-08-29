public class Tarefa {
    private int codigo;
    private String titulo;

    public Tarefa(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Título: " + titulo;
    }
}
