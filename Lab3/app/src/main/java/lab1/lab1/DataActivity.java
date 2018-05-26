package lab1.lab1;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;


public class DataActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app_answers.db", MODE_PRIVATE, null);

        Cursor query = db.rawQuery("SELECT * FROM answers;", null);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("");
        if(query.moveToFirst()){
            do{
                String mess = query.getString(0);
                textView.append(mess);
                textView.append("\n\n");
            }
            while(query.moveToNext());
        }
        else{
            textView.setText("");
            textView.append("БД пуста");
        }

        query.close();
        db.close();
    }

    public void onClick(View view) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app_answers.db", MODE_PRIVATE, null);


        db.execSQL("DELETE FROM answers");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("");
        textView.append("БД пуста");

        db.close();
    }
}
