package practicaltest01var02.eim.systems.cs.pub.ro.practicaltest01var02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends ActionBarActivity {
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements Button.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.sum:

                    /*
                    //startActivity(intent1);
                    Intent intent2 = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
                    intent2.putExtra("ora_exacta", "Ora exacta este: ");

                    startActivityForResult(intent2, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                */
                    Intent intent = getIntent();
                    if (intent != null) {
                        //am luat datele transmise prin intentie
                        ArrayList<Integer> list = intent.getIntegerArrayListExtra("numere");
                        Integer sum = 0;
                        Integer p = 1;
                        for (int i = 0; i < list.size(); i++) {
                            sum = sum + list.get(i);
                            p = p * list.get(i);

                        }
                        Toast.makeText(getApplicationContext(),sum.toString(), Toast.LENGTH_LONG).show();
                    }
                    setResult(RESULT_OK, new Intent());
                    //finish();
                    break;
                case R.id.product:
                    Intent intent2 = getIntent();
                    if (intent2 != null) {
                        //am luat datele transmise prin intentie
                        ArrayList<Integer> list = intent2.getIntegerArrayListExtra("numere");
                        Integer sum = 0;
                        Integer p = 1;
                        for (int i = 0; i < list.size(); i++) {
                            sum = sum + list.get(i);
                            p = p * list.get(i);

                        }
                        Toast.makeText(getApplicationContext(),p.toString(), Toast.LENGTH_LONG).show();
                    }
                    setResult(RESULT_OK, new Intent());
                   // finish();
                    break;


                //ma duc direct in activtatea cu service

            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
/*
        Intent intent = getIntent();
        if (intent != null) {
            //am luat datele transmise prin intentie
            ArrayList<Integer> list = intent.getIntegerArrayListExtra("numere");
            Integer sum = 0;
            Integer p = 1;
            for (int i = 0; i < list.size(); i++) {
                sum = sum + list.get(i);
                p = p * list.get(i);

            }
            Toast.makeText(getApplicationContext(),sum.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),p.toString(), Toast.LENGTH_LONG).show();


*/
            Button backButton = (Button) findViewById(R.id.sum);
            backButton.setOnClickListener(buttonClickListener);
            Button backButton2 = (Button) findViewById(R.id.product);
            backButton2.setOnClickListener(buttonClickListener);
           // Log.d("data", date);

    }

}

