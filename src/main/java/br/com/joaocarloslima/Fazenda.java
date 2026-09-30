package br.com.joaocarloslima;

import java.util.List;

public class Fazenda {
    private List<Terreno> terrenos;
    private Celeiro celeiro;

    public Fazenda(){
        this.terrenos = List<Terreno> terrenos;
        this.celeiro = new Celeiro(50);

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                this.terrenos.add(new Terreno(i, j));
            }
        }
    }

    public Terreno getTerreno(int x, int y) {
        for (Terreno t : terrenos) {
            if (t.getX() == x && t.getY() == y) {
                return t;
            }
        }
        return null;
    }

    public void plantarBatata(int x, int y){
        Terreno t = getTerreno(x, y);
        if(t != null){
            celeiro.consumirBatata();
            t.plantar(new Batata(3));
        }
    }

    public void plantarCenoura(int x, int y){
        Terreno t = getTerreno(x, y);
        if(t != null){
            celeiro.consumirBatata();
            t.plantar(new Cenoura(4));
        }
    }
}
