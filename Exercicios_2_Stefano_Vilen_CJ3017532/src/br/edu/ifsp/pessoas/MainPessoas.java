package br.edu.ifsp.pessoas;

public class MainPessoas {
    public static void main(String[] args) {
        Endereco end1 = new Endereco("Av. Brasil", "1000", "Centro", "São Paulo");
        Endereco end2 = new Endereco("Rua das Flores", "25", "Jardins", "Campinas");

        Pessoa pf = new PessoaFisica("Ana Souza", "123.456.789-10", end1);
        Pessoa pj = new PessoaJuridica("Tech LTDA", "12.345.678/0001-90", end2);

        System.out.println(pf.dadosCompletos());
        System.out.println();
        System.out.println(pj.dadosCompletos());
    }
}