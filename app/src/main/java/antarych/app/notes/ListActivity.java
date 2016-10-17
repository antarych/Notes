package antarych.app.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    final  static String TEST_TAG = "TEST_TAG";

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Note> noteList;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.lv_my_notes);
        initListView();
    }

    private void initListView(){
        noteList = new ArrayList<>();
        noteList.add(new Note("Note1", "text text text text text text text text text text text text text tex"));
        noteList.add(new Note("Note2", "text text text text text"));
        noteList.add(new Note("Note3", "text text text text text"));
        noteList.add(new Note("Note4", "text text text text text"));
        noteList.add(new Note("Note5", "text text text text text"));
        noteList.add(new Note("Note6", "text text text text text"));
        noteList.add(new Note("Note7", "text text text text text"));
        noteList.add(new Note("Note2", "text text text text text"));
        noteList.add(new Note("Note3", "text text text text text"));
        noteList.add(new Note("Note4", "text text text text text"));
        noteList.add(new Note("Note5", "text text text text text"));
        noteList.add(new Note("Note6", "text text text text text"));
        noteList.add(new Note("Note7", "text text text text text"));

        adapter = new NoteAdapter(this, R.layout.item_note, noteList);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TEST_TAG, "onResume()");
        bindViews();
        addNewNote();
    }

    private void addNewNote() {
        addButton = (Button) findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bindViews(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(getApplicationContext(), TextActivity.class);
                myIntent.putExtra("saved_text", noteList.get(position).firstLine);
                myIntent.putExtra("saved_name", noteList.get(position).noteName);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TEST_TAG, "onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TEST_TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TEST_TAG, "onStop()");
    }
}

