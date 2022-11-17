package Objetos;

public class Prova {
    public enum tipo {
        AVALIACAO1, AVALIACAO2, PROVAFINAL;
    }

    private tipo avaliacao;
    private float nota;
    private ConteudoProva conteudoProva;

    public tipo getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(tipo avaliacao) {
        this.avaliacao = avaliacao;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public ConteudoProva getConteudoProva() {
        return conteudoProva;
    }

    public void setConteudoProva(ConteudoProva conteudoProva) {
        this.conteudoProva = conteudoProva;
    }

    public Prova(tipo avaliacao, float nota) {
        this.avaliacao = avaliacao;
        this.nota = nota;
    }

    public Prova() {
    }
}