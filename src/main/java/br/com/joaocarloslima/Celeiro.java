package br.com.joaocarloslima;

public class Celeiro {
    private int capacidade;
    private int qtdeBatatas;
    private int qtdeCenouras;
    private int qtdeMorangos;

    public Celeiro(int capacidade){
        this.capacidade = capacidade;
        this.qtdeBatatas = 5;
        this.qtdeCenouras = 5;
        this.qtdeMorangos = 5;
    }

    public void armazenarBatata() {
        if (getEspacoDisponivel() < 2) {
            throw new IllegalStateException("Celeiro cheio!");
        }
        this.qtdeBatatas += 2;
    }

    public void armazenarCenoura() {
        if (getEspacoDisponivel() < 2) {
            throw new IllegalStateException("Celeiro cheio!");
        }
        this.qtdeCenouras += 2;
    }

    public void armazenarMorango() {
        if (getEspacoDisponivel() < 2) {
            throw new IllegalStateException("Celeiro cheio!");
        }
        this.qtdeMorangos += 2;
    }

    public void consumirBatata() {
        if (this.qtdeBatatas < 1) {
            throw new IllegalStateException("Faltam batatas!");
        }
        this.qtdeBatatas--;
    }

    public void consumirCenoura() {
        if (this.qtdeCenouras < 1) {
            throw new IllegalStateException("Faltam cenouras!");
        }
        this.qtdeCenouras--;
    }

    public void consumirMorango() {
        if (this.qtdeMorangos < 1) {
            throw new IllegalStateException("Faltam morangos!");
        }
        this.qtdeMorangos--;
    }

    public int getEspacoDisponivel(){
        return capacidade - (qtdeBatatas + qtdeCenouras + qtdeMorangos);
    }

    public int getOcupacao(){
        int totalOcupado = qtdeBatatas + qtdeCenouras + qtdeMorangos;
        return (totalOcupado/capacidade) * 100;
    }

    public boolean celeiroCheio(){
        return (qtdeBatatas + qtdeCenouras + qtdeMorangos) >= capacidade;
    }

    public int getCapacidade(){return capacidade;}
    public int getQtdeBatatas(){return qtdeBatatas;}
    public int getQtdeCenouras(){return qtdeCenouras;}
    public int getQtdeMorangos(){return qtdeMorangos;}
}
