/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.prob1.e;

import javax.swing.JOptionPane;
import problema1.AIFFSuperPlayer;
import problema1.WAVPlayer;
import problema1.wmaPlay;

/**
 *
 * @author Marcelo
 */
public class GerenciaAudio<T> implements FormatoAudio {

    //Atributos  
    private WAVPlayer wav;
    private wmaPlay wma;
    private AIFFSuperPlayer aiff;
    private String ext;
    private int tempo = 0;

    @Override

    public void abrir(String nome) {

        String ext = nome.split(".")[1].toLowerCase();

        switch (ext) {
            case "wma":
                ext = "wma";
                wma = new wmaPlay();
                wma.setFile(nome);
                wma.open();
                break;
            case "wav":
                ext = "wav";
                wav = new WAVPlayer(nome);
                break;
            case "aiff":
                ext = "aiff";
                aiff = new AIFFSuperPlayer(nome);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Formato nao reconhecido");
        }

    }

    @Override
    public void reproduzir() {
        switch (ext) {
            case "wma":
                wma.setLocation(tempo);
                wma.play();
                break;
            case "wav":
                wav.play();
                break;
            case "aiff":
                aiff.play();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Formato nao reconhecido");
                break;
        }
    }

    @Override
    public void pausar() {
        switch (ext) {
            case "wma":
                tempo = wma.getLocation();
                wma.stop();
                break;
            case "wav":
                wav.stop();
                break;
            case "aiff":
                tempo = aiff.pause();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Formato nao reconhecido");
                break;
        }
    }

    @Override
    public void parar() {
        switch (ext) {
            case "wma":
                tempo = 0;
                wma.stop();
                break;
            case "wav":
                tempo = 0;
                wav.stop();
                break;
            case "aiff":
                aiff.stop();
                aiff.setCursor(0);
                tempo = 0;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Formato nao reconhecido");
                break;
        }
    }

    @Override
    public void avancar(int tempseg) {
        switch (ext) {
            case "wma":
                wma.setLocation(tempo + tempseg);
                wma.play();
                break;
            case "wav":
                wav.forward(tempseg * 1000);
                break;
            case "aiff":
                aiff.setCursor(tempo + tempseg);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Formato nao reconhecido");
                break;
        }
    }

    @Override
    public void retornar(int tempseg) {
        switch (ext) {
            case "wma":
                if (tempo - tempseg >= 0) {
                    wma.setLocation(tempo - tempseg);
                } else {
                    wma.setLocation(0);
                }
                break;
            case "wav":
                wav.reward(tempseg * 1000);
                break;
            case "aiff":
                aiff.setCursor(tempo - tempseg);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Formato nao reconhecido");
                break;
        }
    }

    @Override
    public void liberar() {
        switch (ext) {
            case "wma":
                wma.stop();
                wma = new wmaPlay();
                break;
            case "wav":
                wav.stop();
                wav = new WAVPlayer("");
                break;
            case "aiff":
                aiff.stop();
                aiff = new AIFFSuperPlayer("");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Formato nao reconhecido");
                break;
        }
    }

    public static void main(String[] args) {

        GerenciaAudio ge = new GerenciaAudio();

        ge.abrir("hugy.wma");
        System.out.println("p2.prob1.e.GerenciaAudio.main()" + ge.getClass());

    }

}
