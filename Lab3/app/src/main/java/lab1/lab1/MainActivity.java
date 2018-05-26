package lab1.lab1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    TextView QuestionLabel;
    EditText QuestionText;
    RadioButton YesButton;
    RadioButton NoButton;
    Button OkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app_answers.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS answers (answ TEXT)");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuestionLabel = findViewById(R.id.QuestionLabel);
        QuestionText = findViewById(R.id.QuestionText);
        YesButton = findViewById(R.id.YesButton);
        NoButton = findViewById(R.id.NoButton);
        OkButton = findViewById(R.id.OkButton);

        OkButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mess="";
                mess+="Питання: "+QuestionText.getText() + "\nВідповідь: ";
                if(YesButton.isChecked())
                    mess+=YesButton.getText().toString();
                else
                    mess+=NoButton.getText().toString();

                SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app_answers.db", MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS answers (answ TEXT)");
                db.execSQL("INSERT INTO answers VALUES ('"+mess+"');");



                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(QuestionText.getText());
                builder.setMessage(YesButton.isChecked() ? YesButton.getText() : NoButton.getText());
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

        Button button_get_data = findViewById(R.id.button_get_data);

        button_get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                startActivity(intent);
            }
        });
    }
}
