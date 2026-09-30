package br.com.joaocarloslima;

public class Terreno {
    private Batata batata;
    private Cenoura cenoura;
    private Morango morango;
    private int x;
    private int y;

    public Terreno(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void plantar(Batata batata) {
        if (estaOcupado()) throw new IllegalStateException("Ocupado");
        this.batata = batata;
    }

    public void plantar(Cenoura cenoura) {
        if (estaOcupado()) throw new IllegalStateException("Ocupado");
        this.cenoura = cenoura;
    }

    public void plantar(Morango morango) {
        if (estaOcupado()) throw new IllegalStateException("Ocupado");
        this.morango = morango;
    }

    public void colher(Celeiro celeiro){
        if (!estaOcupado()) throw new IllegalStateException("Vazio");
        if (batata != null) {
            if (!batata.podeColher()) throw new IllegalStateException("Não maduro");
            celeiro.armazenarBatata();
            this.batata = null;
        } else if (cenoura != null) {
            if (!cenoura.podeColher()) throw new IllegalStateException("Não maduro");
            celeiro.armazenarCenoura();
            this.cenoura = null;
        } else if (morango != null) {
            if (!morango.podeColher()) throw new IllegalStateException("Não maduro");
            celeiro.armazenarMorango();
            this.morango = null;
        }
    }

    //inicio
    public void atualizarCiclo() {
        if (batata != null) batata.crescer();
        if (cenoura != null) cenoura.crescer();
        if (morango != null) morango.crescer();
    }
    //fim

    public boolean estaOcupado(){
        return batata != null || cenoura != null || morango != null;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Batata getBatata() { return batata; }
    public Cenoura getCenoura() { return cenoura; }
    public Morango getMorango() { return morango; }
}
