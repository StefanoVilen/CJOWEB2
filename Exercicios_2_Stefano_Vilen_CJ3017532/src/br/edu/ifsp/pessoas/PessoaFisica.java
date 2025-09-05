package br.edu.ifsp.pessoas;

public class PessoaFisica extends Pessoa {
    private final String cpf;

    public PessoaFisica(String nome, String cpf, Endereco endereco) {
        super(nome, endereco);
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF é obrigatório.");
        }
        this.cpf = cpf;
    }

    @Override
    public String getDocumento() { return cpf; }
    @Override
    public String getTipo() { return "Pessoa Física"; }
}