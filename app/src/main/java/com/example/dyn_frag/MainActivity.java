package com.example.dyn_frag;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        ((Button)findViewById( R.id.button_1 )).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra( "seconds", 10);
                startActivity(intent);
            }
        } );

        ((Button)findViewById( R.id.button_2 )).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra( "seconds", 30);
                startActivity(intent);
            }
        } );
        ((Button)findViewById( R.id.button_3 )).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra( "seconds", 60);
                startActivity(intent);
            }
        } );

    }
}
