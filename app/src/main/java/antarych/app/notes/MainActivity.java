package antarych.app.notes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final  static String TEST_TAG = "TEST_TAG";

    Button saveButton;
    EditText textField;
    EditText nameField;
    CheckBox isImportant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TEST_TAG, "onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TEST_TAG, "onResume()");
        bindViews();
    }

    private void bindViews() {
        saveButton = (Button) findViewById(R.id.s_button);
        nameField = (EditText) findViewById(R.id.note_name);
        textField = (EditText) findViewById(R.id.note_text);
        isImportant = (CheckBox) findViewById(R.id.checkbox_importance);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), TextActivity.class);
                myIntent.putExtra("saved_text", textField.getText().toString());
                myIntent.putExtra("checkbox_importance", isImportant.isChecked());
                myIntent.putExtra("saved_name", nameField.getText().toString());
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
