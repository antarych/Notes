package antarych.app.notes;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Antarych on 03.10.2016.
 */

public class NoteAdapter extends ArrayAdapter {
    Activity activity;
    int resource;
    List list;

    public NoteAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
        list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        Note selectedNote;
        selectedNote = (Note) list.get(position);

        if (convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(resource, null);

            viewHolder = new ViewHolder();

            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.note_name);
            viewHolder.noteTextView = (TextView) convertView.findViewById(R.id.first_line);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameTextView.setText(selectedNote.noteName);
        viewHolder.noteTextView.setText(selectedNote.firstLine);

        return  convertView;
    }

    class  ViewHolder{
        TextView nameTextView;
        TextView noteTextView;
    }
}
