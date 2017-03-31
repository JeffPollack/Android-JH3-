package com.example.jeff.jh3_jdpollack;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity  implements OnClickListener, HangmanUpdate{
    TextView display = null;
    myDrawHangmanView myDrawHangmanView;
    public void updateMessage(String s){
        display.setText(s);
    }
    public void gameIsDone(boolean winner){

    }
    HangmanLogic hml;
    String[]words = {"pig","cow","sheep","dog","cat"};

    int[] button_resources = {R.id.a, R.id.b, R.id.c, R.id.d, R.id.e, R.id.f,
            R.id.g, R.id.h, R.id.i, R.id.j, R.id.k, R.id.l,
            R.id.m, R.id.n, R.id.o, R.id.p, R.id.q,R.id.r,
            R.id.s, R.id.t, R.id.u, R.id.v, R.id.w,R.id.x, R.id.y, R.id.z};
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hml = new HangmanLogic(this);


        for (int i = 0; i < button_resources.length; i++) {
            Button b = (Button) findViewById(button_resources[i]);
            b.setOnClickListener(this);
        }
        display = (TextView) findViewById(R.id.display);

        myDrawHangmanView = (myDrawHangmanView)findViewById(R.id.myDrawHangmanView);

        hml.newGame(20, words);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        for (int i = 0; i < button_resources.length; i++) {
            Button b = (Button) findViewById(button_resources[i]);
            b.setVisibility(View.VISIBLE);
            myDrawHangmanView.reset();
        }
        hml.newGame(20, words);
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v)
    {
        Button b = (Button)v;
        String label = b.getText().toString();
        char c = label.charAt(0);
        hml.buttonClicked(c);
        //if (hml.buttonClicked(c))
        b.setVisibility(View.INVISIBLE);

        if (hml.buttonClicked(c) != true)
            myDrawHangmanView.increment();
        /*switch (v.getId())
        {
            case hml.buttonClicked(c)=false:
                myDrawHangmanView.increment();
                break;
        }*/


    }

}