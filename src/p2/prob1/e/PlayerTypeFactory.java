package ClassAdapter;

public class PlayerTypeFactory {

    public FormatoAudio escolhaFormato(String formato) {

        String[] ext = formato.split("\\.");
        switch (ext[1]) {
            case "aac":
                return new AACPlayerAdapter();
            case "aiff":
                return new AIFFSuperPlayerAdapter();
            case "mpm3dj":
                return new MP3DJAdapter();
            case "wav":
                return new WAVPlayerAdapter();
            case "wma":
                return new WmaPlayerAdapter();
            default:
                return null;
        }

    }
}
