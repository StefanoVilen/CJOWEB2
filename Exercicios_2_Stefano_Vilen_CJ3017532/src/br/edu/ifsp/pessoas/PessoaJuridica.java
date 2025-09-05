package br.edu.ifsp.pessoas;

public class PessoaJuridica extends Pessoa {
    private final String cnpj;

    public PessoaJuridica(String nome, String cnpj, Endereco endereco) {
        super(nome, endereco);
        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("CNPJ é obrigatório.");
        }
        this.cnpj = cnpj;
    }

    @Override
    public String getDocumento() { return cnpj; }
    @Override
    public String getTipo() { return "Pessoa Jurídica"; }
}