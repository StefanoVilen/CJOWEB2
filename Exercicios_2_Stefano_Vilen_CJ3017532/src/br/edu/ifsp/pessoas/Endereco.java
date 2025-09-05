package br.edu.ifsp.pessoas;

import java.util.Objects;

public class Endereco {
    private final String logradouro;
    private final String numero;
    private final String bairro;
    private final String cidade;

    public Endereco(String logradouro, String numero, String bairro, String cidade) {
        if (isBlank(logradouro) || isBlank(numero) || isBlank(bairro) || isBlank(cidade)) {
            throw new IllegalArgumentException("Todos os campos de endereço são obrigatórios.");
        }
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    @Override
    public String toString() {
        return String.format("%s, %s - %s, %s", logradouro, numero, bairro, cidade);
    }
}