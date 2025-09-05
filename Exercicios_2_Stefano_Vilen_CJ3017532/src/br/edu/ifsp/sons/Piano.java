package br.edu.ifsp.sons;

public class Piano implements Instrumento {
    @Override
    public String tocar() {
        return "🎹 Piano: Plim plim plim (arpejo suave)";
    }
}