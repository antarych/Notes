package antarych.app.notes;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antarych on 03.10.2016.
 */

public class NoteAdapter extends ArrayAdapter {
    Activity activity;
    int resource;
    ArrayList<NotesModel> list;

    public NoteAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
        this.list = (ArrayList<NotesModel>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (list.get(position) instanceof Note) {
            Note selectedNote;
            selectedNote = (Note) list.get(position);
            NoteViewHolder viewHolder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_note, null);
                viewHolder = new NoteViewHolder(
                        (TextView) convertView.findViewById(R.id.note_name),
                        (TextView) convertView.findViewById(R.id.first_line)
                );

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (NoteViewHolder) convertView.getTag();
            }

            Note note = (Note) list.get(position);
            viewHolder.name.setText(selectedNote.noteName);
            viewHolder.text.setText(selectedNote.text);

            convertView.setTag(viewHolder);

        } else if (list.get(position) instanceof Separator) {
            SeparatorViewHolder viewHolder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_separator, null);
                viewHolder = new SeparatorViewHolder(
                        (TextView) convertView.findViewById(R.id.tv_separator)
                );
            } else {
                viewHolder = (SeparatorViewHolder) convertView.getTag();
            }
            Separator separator = (Separator) list.get(position);
            viewHolder.text.setText(separator.text);
        }
        return convertView;
    }

    class NoteViewHolder {
        TextView name;
        TextView text;

        public NoteViewHolder(TextView name, TextView text) {
            this.name = name;
            this.text = text;
        }
    }

    class SeparatorViewHolder {
        TextView text;

        public SeparatorViewHolder(TextView text) {
            this.text = text;
        }
    }
}

