package practicaltest01var02.eim.systems.cs.pub.ro.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PracticalTest01Var02MainActivity extends ActionBarActivity {
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements Button.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.set:

                    /*
                    //startActivity(intent1);
                    Intent intent2 = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
                    intent2.putExtra("ora_exacta", "Ora exacta este: ");

                    startActivityForResult(intent2, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                */
                    EditText editText1 = (EditText) findViewById(R.id.edit_text_1);
                    EditText editText2 = (EditText) findViewById(R.id.edit_text_2);
                    EditText editText3 = (EditText) findViewById(R.id.edit_text_3);
                    EditText editText4 = (EditText) findViewById(R.id.edit_text_4);
                    Intent intent2 = new Intent(getApplicationContext(), SecondActivity.class);
                    ArrayList<Integer> list = new  ArrayList<Integer>();
                    list.add(Integer.parseInt(editText1.getText().toString()));
                    list.add(Integer.parseInt(editText2.getText().toString()));
                    list.add(Integer.parseInt(editText3.getText().toString()));
                    list.add(Integer.parseInt(editText4.getText().toString()));

                    intent2.putIntegerArrayListExtra("numere", list);
                   // intent2.putExtra("ora_exacta", "Ora exacta este: ");

                    startActivityForResult(intent2, 2);
                    /*
                    try{
                        int x = Integer.parseInt(editText1.getText().toString()) + 1;
                    }catch (Exception e) {
                        //vedem aici
                    }
*/
                    break;
                //ma duc direct in activtatea cu service

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        Button backButton = (Button) findViewById(R.id.set);
        backButton.setOnClickListener(buttonClickListener);

        EditText editText1 = (EditText) findViewById(R.id.edit_text_1);
        EditText editText2 = (EditText) findViewById(R.id.edit_text_2);
        EditText editText3 = (EditText) findViewById(R.id.edit_text_3);
        EditText editText4 = (EditText) findViewById(R.id.edit_text_4);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("leftCount")) {
                editText1.setText(savedInstanceState.getString("leftCount"));
            } else {
                editText1.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("leftCount1")) {
                editText3.setText(savedInstanceState.getString("leftCount"));
            } else {
                editText3.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("leftCount2")) {
                editText4.setText(savedInstanceState.getString("leftCount2"));
            } else {
                editText4.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("rightCount")) {
                editText2.setText(savedInstanceState.getString("rightCount"));
            } else {
                editText2.setText(String.valueOf(0));
            }
        } else {
            editText1.setText(String.valueOf(0));
            editText2.setText(String.valueOf(0));
            editText3.setText(String.valueOf(0));
            editText4.setText(String.valueOf(0));


        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        EditText editText1 = (EditText) findViewById(R.id.edit_text_1);
        EditText editText2 = (EditText) findViewById(R.id.edit_text_2);
        EditText editText3 = (EditText) findViewById(R.id.edit_text_3);
        EditText editText4 = (EditText) findViewById(R.id.edit_text_4);
        savedInstanceState.putString("leftCount", editText1.getText().toString());
        savedInstanceState.putString("rightCount", editText2.getText().toString());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //poate ici trebuie altceva
        if (requestCode == 2) {
            Toast.makeText(getApplicationContext(), resultCode + "", Toast.LENGTH_LONG).show();
        }
    }
}
