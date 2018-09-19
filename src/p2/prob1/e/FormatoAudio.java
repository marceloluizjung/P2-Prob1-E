/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.prob1.e;

/**
 *
 * @author Marcelo
 */
public interface FormatoAudio <T> {
    
    public void abrir(String nome);
    public void reproduzir(); 
    public void pausar(); 
    public void parar(); 
    public void avancar(int tempseg);
    public void retornar(int tempseg); 
    public void liberar();
    
}
