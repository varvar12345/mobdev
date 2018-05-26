package lab2.lab2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import lab2.lab2.R;

public class MainActivity extends AppCompatActivity implements ContentFragment.OnFragmentInteractionListener{

    TextView QuestionLabel;
    EditText QuestionText;
    RadioButton YesButton;
    RadioButton NoButton;
    Button OkButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(String link) {
        DetailFragment fragment = (DetailFragment) getFragmentManager()
                .findFragmentById(R.id.detailFragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(link);
        }
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }*/
}
