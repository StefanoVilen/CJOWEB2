package br.edu.ifsp.sons;

public class Guitarra implements Instrumento {
    @Override
    public String tocar() {
        return "🎸 Guitarra: Tcharam tcharam! (distortion on)";
    }
}