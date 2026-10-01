package br.com.joaocarloslima;

import java.util.ArrayList;
import java.util.List;

public class Fazenda {
    private List<Terreno> terrenos;
    private Celeiro celeiro;

    public Fazenda(){
        this.terrenos = new ArrayList<>();
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

    public void plantarCenoura(int x, int y) {
        Terreno t = getTerreno(x, y);
        if (t != null) {
            celeiro.consumirCenoura();
            t.plantar(new Cenoura(4)); // Tempo de crescimento = 4 ciclos
        }
    }

    public void plantarMorango(int x, int y) {
        Terreno t = getTerreno(x, y);
        if (t != null) {
            celeiro.consumirMorango();
            t.plantar(new Morango(5)); // Tempo de crescimento = 5 ciclos
        }
    }

    public void colher(int x, int y) {
        Terreno t = getTerreno(x, y);
        if (t != null) {
            t.colher(this.celeiro);
        }
    }

    // Avança o tempo de todas as plantas na fazenda
    public void passarCiclo() {
        for (Terreno t : terrenos) {
            t.atualizarCiclo();
        }
    }

    public Celeiro getCeleiro() { return celeiro; }
    public List<Terreno> getTerrenos() { return terrenos; }
}
