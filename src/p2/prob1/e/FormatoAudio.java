
package ClassAdapter;

public interface FormatoAudio {
    
    public void abrir(String nome);
    public void reproduzir(); 
    public void pausar(); 
    public void parar(); 
    public void avancar(int tempseg);
    public void retornar(int tempseg); 
    public void liberar();
    
}
