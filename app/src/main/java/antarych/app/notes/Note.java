package antarych.app.notes;

/**
 * Created by Antarych on 03.10.2016.
 */

public class Note extends NotesModel{
    String noteName;

    public Note(String name, String text) {
        this.noteName = name;
        this.text = text;
    }
}
