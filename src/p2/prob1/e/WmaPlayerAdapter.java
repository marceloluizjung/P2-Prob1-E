package ClassAdapter;

import problema1.wmaPlay;

public class WmaPlayerAdapter implements FormatoAudio {

    private wmaPlay wma;
    boolean tocando = false;

    @Override
    public void abrir(String nome) {
        
        wma = new wmaPlay();
        wma.setFile(nome);
        wma.open();
        wma.setLocation(0);

    }

    @Override
    public void reproduzir() {

        wma.play();
        tocando = true;
    }

    @Override
    public void pausar() {

        if(tocando == true){
            wma.stop();
            tocando = false;
        } else {
            System.out.println("Não tem como pausar algo que já está parado!");
        }
    }

    @Override
    public void parar() {
        
        wma.stop();
        wma.setLocation(0);
        tocando = false;
        
    }

    @Override
    public void avancar(int tempseg) {
        
        wma.setLocation(tempseg + wma.getLocation());
        
        
    }

    @Override
    public void retornar(int tempseg) {
        
        wma.setLocation(wma.getLocation() - tempseg);
        
    }

    @Override
    public void liberar() {
        
        wma = new wmaPlay();
        
    }

}
