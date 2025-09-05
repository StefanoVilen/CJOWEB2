package br.edu.ifsp.sons;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class JanelaInstrumentos extends JFrame {
    private final JTextField campoInstrumento = new JTextField();
    private final JButton botaoTocar = new JButton("Tocar");
    private final JTextArea areaSaida = new JTextArea(5, 30);
    private final Map<String, Instrumento> instrumentos = new HashMap<>();

    public JanelaInstrumentos() {
        super("Gerenciador de Sons de Instrumentos");
        instrumentos.put("guitarra", new Guitarra());
        instrumentos.put("bateria", new Bateria());
        instrumentos.put("piano", new Piano());

        configurarUI();
        configurarEventos();
    }

    private void configurarUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        JPanel topo = new JPanel(new BorderLayout(8, 8));
        topo.add(new JLabel("Digite um instrumento (guitarra, bateria, piano):"), BorderLayout.NORTH);
        topo.add(campoInstrumento, BorderLayout.CENTER);
        topo.add(botaoTocar, BorderLayout.EAST);
        areaSaida.setEditable(false);
        areaSaida.setLineWrap(true);
        areaSaida.setWrapStyleWord(true);
        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(areaSaida), BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void configurarEventos() {
        botaoTocar.addActionListener(e -> tocarInstrumento());
        campoInstrumento.addActionListener(e -> tocarInstrumento());
    }

    private void tocarInstrumento() {
        String nome = campoInstrumento.getText();
        if (nome == null || nome.trim().isEmpty()) {
            mostrarMensagem("Por favor, digite o nome de um instrumento.");
            return;
        }
        String chave = nome.trim().toLowerCase(Locale.ROOT);
        Instrumento inst = instrumentos.get(chave);
        if (inst != null) {
            mostrarMensagem("Simulando...\n" + inst.tocar());
        } else {
            mostrarMensagem("Instrumento não encontrado: " + nome + ".\nTente: guitarra, bateria ou piano.");
        }
    }

    private void mostrarMensagem(String msg) {
        areaSaida.append(msg + "\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JanelaInstrumentos().setVisible(true));
    }
}