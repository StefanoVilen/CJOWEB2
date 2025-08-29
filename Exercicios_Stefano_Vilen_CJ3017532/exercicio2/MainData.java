import javax.swing.JOptionPane;

public class MainData {
    public static void main(String[] args) {
        // Instanciação com valores fixos
        Data data = new Data(10, 8, 2024);

        // Lendo novos valores do usuário
        int novoDia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia (1-30):"));
        int novoMes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês (1-12):"));
        int novoAno = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano (>=1900):"));

        // Alterando os valores
        data.setDia(novoDia);
        data.setMes(novoMes);
        data.setAno(novoAno);

        // Exibindo a nova data
        JOptionPane.showMessageDialog(null, "Nova data: " + data.getDataFormatada());
    }
}
