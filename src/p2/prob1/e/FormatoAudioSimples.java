package p2.prob1.e;

public class FormatoAudioSimples {

    PlayerTypeFactory ptf;
    FormatoAudio fa;

    public FormatoAudioSimples() {
        ptf = new PlayerTypeFactory();
    }

    public void reproduzirSimples(String nome) {
        this.fa = ptf.escolhaFormato(nome);
        this.fa.abrir(nome);
        this.fa.reproduzir();

    }

    public void pararSimples() {

        this.fa.pausar();
        this.fa.liberar();

    }
    
}
