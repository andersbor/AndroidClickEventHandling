package dk.easj.anbo.clickeventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_TAG = "BUTTONS";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button_interface);
        button1.setOnClickListener(this); // this Activity class implements View.OnClickListener


        Button button2 = findViewById(R.id.button_named_inner_classs);
        button2.setOnClickListener(new MyListener());

        final Button button3 = findViewById(R.id.button_anonymous_inner_class);
        button3.setOnClickListener(
                new View.OnClickListener() {
                    // Java feature: Anonymous inner class
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getBaseContext(), "Button clicked ", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        final EditText myEditText = findViewById(R.id.MyEditText);

        myEditText.setOnFocusChangeListener(
                new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) myEditText.setBackgroundColor(Color.YELLOW);
                        else myEditText.setBackgroundColor(Color.WHITE);
                        Log.d(LOG_TAG, "EditText has focus: " + hasFocus);
                    }
                }
        );

        myEditText.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                Log.d(LOG_TAG, "EditText hover");
                return false;
            }
        });

        myEditText.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Log.d(LOG_TAG, "EditText long click");
                        return false;
                    }
                }
        );

        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(LOG_TAG, "EditText TextWatcher: " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void onClickXml(View view) { // method reference in layout XML file
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) { // class ... implements View.OnClickListener
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
    }

    // Java feature: Inner class
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();
        }
    }
}