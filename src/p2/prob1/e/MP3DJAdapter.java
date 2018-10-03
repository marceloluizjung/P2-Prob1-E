package ClassAdapter;

import problema1.MP3DJ;

public class MP3DJAdapter implements FormatoAudio {

    private MP3DJ mp3;
    int tempo = 0;

    @Override
    public void abrir(String nome) {

        mp3 = new MP3DJ();
        mp3.setFile(nome);

    }

    @Override
    public void reproduzir() {

        mp3.play();
        tempo++;

    }

    @Override
    public void pausar() {

        mp3.stop();

    }

    @Override
    public void parar() {

        mp3.stop();
        mp3.reward(tempo);
        tempo = 0;

    }

    @Override
    public void avancar(int tempseg) {
        tempo = tempo + tempseg;
        mp3.forward(tempo);
        
    }

    @Override
    public void retornar(int tempseg) {
        tempo = tempo - tempseg;
        mp3.reward(tempo);
    }

    @Override
    public void liberar() {

        mp3 = new MP3DJ();
    }

}
