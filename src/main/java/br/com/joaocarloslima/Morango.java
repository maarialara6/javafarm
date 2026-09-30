package br.com.joaocarloslima;

public class Morango {
    private int tamanho;
    private int tempoDeVida;
    private int tempoDeCrescimento;

    public Morango(int tempoDeVida){
        this.tamanho = 1;
        this.tempoDeVida = 1;
        this.tempoDeCrescimento = tempoDeVida;
    }

    public void crescer(){
        this.tempoDeVida++;
        if (this.tempoDeVida % this.tempoDeCrescimento == 0){
            if (this.tamanho < 4){
                this.tamanho++;
            }
        }
    }

    public boolean podeColher(){
        return this.tamanho == 4;
    }

    public String getImagem(){
        return "images/morango" + tamanho + ".png";
    }

    public int getTamanho(){return tamanho;}
    public int getTempoDeVida(){return tempoDeVida;}
    public int getTempoDeCrescimento(){return tempoDeCrescimento;}
}
