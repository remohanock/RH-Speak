package com.example.remo.rhspeak;


import android.annotation.SuppressLint;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    EditText etName;
    TextView tvResult;
    TextToSpeech ttsObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        tvResult = (TextView) findViewById(R.id.tvResult);

        ttsObj = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR)
                    ttsObj.setLanguage(Locale.US);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (ttsObj != null) {
            ttsObj.stop();
            ttsObj.shutdown();
        }
    }

    public void greetUser(View view) {
        //ttsObj.speak(etName.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
        ttsObj.speak(etName.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if= it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
