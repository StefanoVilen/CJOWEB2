package br.edu.ifsp.sons;

public class Bateria implements Instrumento {
    @Override
    public String tocar() {
        return "🥁 Bateria: Tum pá, tum tum pá!";
    }
}