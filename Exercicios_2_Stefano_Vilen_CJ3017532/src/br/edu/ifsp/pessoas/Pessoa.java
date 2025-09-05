package br.edu.ifsp.pessoas;

public abstract class Pessoa {
    private final String nome;
    private final Endereco endereco;

    protected Pessoa(String nome, Endereco endereco) {
        if (isBlank(nome) || endereco == null) {
            throw new IllegalArgumentException("Nome e endereço são obrigatórios.");
        }
        this.nome = nome;
        this.endereco = endereco;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public String getNome() { return nome; }
    public Endereco getEndereco() { return endereco; }

    public abstract String getDocumento();
    public abstract String getTipo();

    public String dadosCompletos() {
        return String.format(
            "%s%nNome: %s%nDocumento: %s%nEndereço: %s",
            getTipo(), nome, getDocumento(), endereco.toString()
        );
    }
}