package ClassAdapter;

import problema1.WAVPlayer;

public class WAVPlayerAdapter implements FormatoAudio {

    private WAVPlayer wav;
    private int tempo = 0;
    
    
    @Override
    public void abrir(String nome) {
        
        wav = new WAVPlayer(nome);

    }

    @Override
    public void reproduzir() {
        
        wav.play();
        tempo++;
        
    }

    @Override
    public void pausar() {
        
        wav.stop();
    }

    @Override
    public void parar() {
        
        wav.stop();
        tempo = 0;
    }

    @Override
    public void avancar(int tempseg) {
        
        tempo = wav.forward(tempo  + (tempseg/1000));
        
    }

    @Override
    public void retornar(int tempseg) {

        tempo = wav.reward(tempo  - (tempseg/1000));
        
    }

    @Override
    public void liberar() {
        
        wav = new WAVPlayer("");
    }

}
