package lab2.lab2;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.app.Activity;


public class ContentFragment extends Fragment{

    TextView QuestionLabel;
    EditText QuestionText;
    RadioButton YesButton;
    RadioButton NoButton;
    Button OkButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        QuestionLabel = view.findViewById(R.id.QuestionLabel);
        QuestionText = view.findViewById(R.id.QuestionText);
        YesButton = view.findViewById(R.id.YesButton);
        NoButton = view.findViewById(R.id.NoButton);
        OkButton = view.findViewById(R.id.OkButton);

        OkButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mess="";
                mess+="Питання: "+QuestionText.getText() + "\nВідповідь: ";
                if(YesButton.isChecked())
                    mess+=YesButton.getText().toString();
                else
                    mess+=NoButton.getText().toString();

                updateDetail(mess);
            }

        });
        return view;
    }

    public OnFragmentInteractionListener mListener;
    interface OnFragmentInteractionListener {

        void onFragmentInteraction(String link);
    }
    public void updateDetail(String curDate) {
        // генерируем некоторые данные

        // Посылаем данные Activity
        mListener.onFragmentInteraction(curDate);
    }
    @Override
    public void onAttach(Activity MainActivity) {
        super.onAttach(MainActivity);
        mListener = (OnFragmentInteractionListener) MainActivity;}
}
