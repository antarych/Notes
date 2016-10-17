package antarych.app.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.view.MenuItem;
import android.content.Intent;
import android.view.Menu;

public class TextActivity extends AppCompatActivity {

    TextView savedText;
    CheckBox savedImportance;
    Boolean value;
    TextView savedName;
    String noteName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        bindViews();
    }

    private void bindViews() {
        savedText = (TextView)findViewById(R.id.saved_text);
        savedImportance = (CheckBox) findViewById(R.id.saved_importance);
        value = getIntent().getBooleanExtra("checkbox_importance", false);
        noteName = getIntent().getStringExtra("saved_name");
        setTitle(noteName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MainActivity.TEST_TAG, getIntent().getStringExtra("saved_text"));
        savedText.setText(getIntent().getStringExtra("saved_text"));
        Log.d(MainActivity.TEST_TAG, getIntent().getStringExtra("saved_name"));
        savedImportance.setChecked(value);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
