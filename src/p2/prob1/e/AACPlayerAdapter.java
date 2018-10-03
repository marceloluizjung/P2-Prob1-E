
package ClassAdapter;

import problema1.AACPlayer;

public class AACPlayerAdapter implements FormatoAudio {
    
    private AACPlayer aac;
    private boolean tocando = false;

    @Override
    public void abrir(String nome) {

        aac = new AACPlayer(nome);
        aac.open();
        aac.setLocation(0);
    }

    @Override
    public void reproduzir() {
        aac.play();
        tocando = true;
    }

    @Override
    public void pausar() {
    
        if(tocando == true){
            aac.stop();
            tocando = false;
        } else {
            System.out.println("Não é possível parar algo que já está parado");
        }
    }

    @Override
    public void parar() {
        aac.stop();
        aac.setLocation(0);
        tocando = false;
    }

    @Override
    public void avancar(int tempseg) {
        
        aac.setLocation(tempseg  + aac.getLocation());
        
    }

    @Override
    public void retornar(int tempseg) {
        
        aac.setLocation(aac.getLocation() - tempseg);
    }

    @Override
    public void liberar() {
        
        aac = new AACPlayer("");
    }

}
