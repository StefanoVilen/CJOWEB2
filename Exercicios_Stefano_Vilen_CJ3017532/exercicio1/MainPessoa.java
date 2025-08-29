public class MainPessoa {
    public static void main(String[] args) {
        // Instanciação com valores fixos
        Pessoa p1 = new Pessoa("João", 25);

        // Alterando os dados
        p1.setNome("Carlos");
        p1.setIdade(30);

        // Exibindo a nova idade
        System.out.println("Nova idade de " + p1.getNome() + ": " + p1.getIdade());
    }
}
