package Objetos;
public class Aluno {
    private String matricula, nome;
    private int idade;
    private Prova[] provas;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Prova[] getProvas() {
        return provas;
    }

    public void setProvas(Prova[] provas) {
        this.provas = provas;
    }

    public Aluno(String matricula, String nome, int idade) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
    }


    public String toString(){
        if (!provaFinal()){
            return "Nome: " + nome + "\nMatricula: " + matricula + "\nIdade: " + idade + "\nProva 1: " + provas[0].getNota() + "\nProva 2: " + provas[1].getNota() + "\nMedia Final: " + calculaMedia();
        }
        else
            return "Nome: " + nome + "\nMatricula: " + matricula + "\nIdade: " + idade + "\nProva 1: " + provas[0].getNota() + "\nProva 2: " + provas[1].getNota() + "\nProva Final: " + provas[2].getNota() + "\nMedia Final: " + calculaMedia();
    }

    public double calculaMedia(){
        if ((this.provas[0].getNota() + this.provas[1].getNota()) / 2 >= 7)
            return (this.provas[0].getNota() + this.provas[1].getNota()) / 2;
        else
            return (((this.provas[0].getNota() + this.provas[1].getNota()) / 2) + this.provas[2].getNota()) / 2;
    }
    public boolean provaFinal(){
        if ((this.provas[0].getNota() + this.provas[1].getNota()) / 2 >= 7)
            return false;
        else
            return true;
    }
}