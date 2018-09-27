package p2.prob1.e;

import problema1.AIFFSuperPlayer;

public final class AIFF implements FormatoAudio {

    private AIFFSuperPlayer aiff;
    int tempo = 0;

    @Override
    public void abrir(String nome) {

        aiff = new AIFFSuperPlayer(nome);
    }

    @Override
    public void reproduzir() {

        aiff.play();

    }

    @Override
    public void pausar() {

        tempo = aiff.pause();
    }

    @Override
    public void parar() {

        aiff.stop();
        aiff.setCursor(0);
        tempo = 0;

    }

    @Override
    public void avancar(int tempseg) {
        aiff.setCursor(tempo + tempseg);
    }

    @Override
    public void retornar(int tempseg) {
        
        aiff.setCursor(tempo - tempseg);
        
    }

    @Override
    public void liberar() {
        
        aiff = new AIFFSuperPlayer("");

    }

}
