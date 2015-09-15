package com.example.dante.smartjokenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SmartJoKenPo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_jo_ken_po);
    }


    private Random gerador = new Random();
    DBHelper db = new DBHelper(this);
    Rounds round = new Rounds();


    public void Rock (View view){
        round.setchooseHuman(10);
        round.setchooseProg(gerador.nextInt(3) + 1);
        //db.updateStatistics("rock");
        String s = round.compare();
        String l = s.substring(0, 1);
        //updateScore(l, view);
        Toast.makeText(SmartJoKenPo.this, round.compare(), Toast.LENGTH_SHORT).show();
    }


    public void Paper (View view){
        round.setchooseHuman(20);
        round.setchooseProg(gerador.nextInt(3) + 1);
        //db.updateStatistics("paper");
        String s = round.compare();
        String l = s.substring(0, 1);
        //updateScore(l, view);
        Toast.makeText(SmartJoKenPo.this, round.compare(), Toast.LENGTH_SHORT).show();
    }

    public void Scissors (View view){
        round.setchooseHuman(30);
        round.setchooseProg(gerador.nextInt(3) + 1);
        //db.updateStatistics("30");
        String s = round.compare();
        String l = s.substring(0, 1);
        //updateScore(l, view);
        Toast.makeText(SmartJoKenPo.this, round.compare(), Toast.LENGTH_SHORT).show();
    }


    public void updateScore(String l, View view){

        switch(l) {
            case "W":
                db.updateStatistics("win");
                TextView win = (TextView) findViewById(R.id.textView4);
                win.setText("" + db.selectStatistics("win"));
                return;
            case "L":
                db.updateStatistics("lose");
                TextView lose = (TextView) findViewById(R.id.textView3);
                lose.setText("" + db.selectStatistics("lose"));
                return;
            case "D":
                db.updateStatistics("draw");
                TextView draw = (TextView) findViewById(R.id.textView6);
                draw.setText("" + db.selectStatistics("draw"));
                return;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_smart_jo_ken_po, menu);
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
