package mk.edu.fikt.pmp.kviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int globTochno;
    int globKliknato;
    int poeni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        poeni=0;
        TextView txtviewpoeni = (TextView) findViewById(R.id.txtPoeni);
        txtviewpoeni.setText(String.valueOf(poeni));

        PostaviZadaca();
        

        final Button button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(lisenerot);


        final Button button2 = (Button) findViewById(R.id.btn2);
        button2.setOnClickListener(lisenerot);

        final Button button3 = (Button) findViewById(R.id.btn3);
        button3.setOnClickListener(lisenerot);

    }



//    protected void proveri(View view) {
//        Log.d("ilija","kliknav na kopce");
//    }

    View.OnClickListener lisenerot = new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
            Log.d("ilija","kliknav na kopce");

            Log.d("ilija","test"+String.valueOf(v.getId()));

            TextView txtviewpoeni = (TextView) findViewById(R.id.txtPoeni);


            if((globTochno==1&&R.id.btn1==v.getId())||(globTochno==2&&R.id.btn2==v.getId())||(globTochno==3&&R.id.btn3==v.getId())){
                Log.d("ilija","TOCHNO!");
                poeni++;
                txtviewpoeni.setText(String.valueOf(poeni));
            }
            else {
                Log.d("ilija","NETOCHNO!");
                poeni--;
                txtviewpoeni.setText(String.valueOf(poeni));
            }

            PostaviZadaca();

        }
    };



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
        High = 4;
        pozicijatocno = r.nextInt(High-Low) + Low;

        Log.d("ilija","poz tochno:" + String.valueOf(pozicijatocno));

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
