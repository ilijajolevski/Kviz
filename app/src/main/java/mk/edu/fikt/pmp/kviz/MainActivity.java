package mk.edu.fikt.pmp.kviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int globTochno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PostaviZadaca();
    }




    void PostaviZadaca(){

        int br1=0;
        int br2=0;
        int znak=-1;
        int rez=0;
        int pozicijatocno = -1;


        Random r = new Random();
        int Low = 1;
        int High = 100;
        br1 = r.nextInt(High-Low) + Low;
        br2 = r.nextInt(High-Low) + Low;

        Low = -100;
        znak = r.nextInt(High-Low) + Low;

        TextView txtviewbr1 = (TextView) findViewById(R.id.br1);
        txtviewbr1.setText(String.valueOf(br1));
        TextView txtviewbr2 = (TextView) findViewById(R.id.br2);
        txtviewbr2.setText(String.valueOf(br2));

        TextView txtznak = (TextView) findViewById(R.id.znak);

        if(znak<0)
        {
            rez = br1-br2;
            txtznak.setText("-");
        }
        else{

            rez = br1+br2;
            txtznak.setText("+");
        }


        //TextView txtrez = (TextView) findViewById(R.id.rezultat);
        //txtrez.setText(String.valueOf(rez));


        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);

        Low = 1;
        High = 3;
        pozicijatocno = r.nextInt(High-Low) + Low;

        if(pozicijatocno==1)
        {
            btn1.setText(String.valueOf(rez));
            btn2.setText(String.valueOf(rez+2));
            btn3.setText(String.valueOf(rez-3));
            globTochno = 1;
        }
        if(pozicijatocno==2)
        {
            btn1.setText(String.valueOf(rez+1));
            btn2.setText(String.valueOf(rez));
            btn3.setText(String.valueOf(rez-3));
            globTochno = 2;
        }
        if(pozicijatocno==3)
        {
            btn1.setText(String.valueOf(rez-3));
            btn2.setText(String.valueOf(rez+2));
            btn3.setText(String.valueOf(rez));
            globTochno = 3;
        }


    }
}
