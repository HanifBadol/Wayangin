package com.kamak.wayang;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz_Activity extends AppCompatActivity {
    Button b_answer1,b_answer2,b_answer3,b_answer4;
    ImageView iv_flag;
    List<WayangItem> list;
    Random r;
    int turn = 1;
    MediaPlayer mpbenar,mpsalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_);
        iv_flag = (ImageView)findViewById(R.id.iv_flag);

        b_answer1 = (Button)findViewById(R.id.b_answer1);
        b_answer2 = (Button)findViewById(R.id.b_answer2);
        b_answer3 = (Button)findViewById(R.id.b_answer3);
        b_answer4 = (Button)findViewById(R.id.b_answer4);
        mpbenar = MediaPlayer.create(this, R.raw.benar);
        mpsalah = MediaPlayer.create(this, R.raw.salah);
        list = new ArrayList<>();
        r = new Random();
        MainActivity.mediaPlayer.stop();

        //add all wayang image and name
        for (int i=0; i< new Database().answer.length; i++){
            list.add(new WayangItem(new Database().answer[i], new Database().flags[i]));
        }

        //suffle the wayang
        Collections.shuffle(list);

        newQuestion(turn);

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    mpbenar.start();
                    Toast.makeText(Quiz_Activity.this,"Correct", Toast.LENGTH_SHORT).show();

                    if (turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(Quiz_Activity.this,"You Finish The Game",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    mpsalah.start();
                    Toast.makeText(Quiz_Activity.this, "Wrong",Toast.LENGTH_SHORT).show();
                    Toast.makeText(Quiz_Activity.this, "You Lost The Game",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(Quiz_Activity.this,"Correct", Toast.LENGTH_SHORT).show();

                    if (turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(Quiz_Activity.this,"You Finish The Game",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Quiz_Activity.this, "Wrong",Toast.LENGTH_SHORT).show();
                    Toast.makeText(Quiz_Activity.this, "You Lost The Game",Toast.LENGTH_SHORT).show();
                    finish();
                }


            }
        });
        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    mpbenar.start();
                    Toast.makeText(Quiz_Activity.this,"Correct", Toast.LENGTH_SHORT).show();

                    if (turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(Quiz_Activity.this,"You Finish The Game",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    mpsalah.start();
                    Toast.makeText(Quiz_Activity.this, "Wrong",Toast.LENGTH_SHORT).show();
                    Toast.makeText(Quiz_Activity.this, "You Lost The Game",Toast.LENGTH_SHORT).show();
                    finish();
                }


            }
        });
        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    mpbenar.start();
                    Toast.makeText(Quiz_Activity.this,"Correct", Toast.LENGTH_SHORT).show();

                    if (turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(Quiz_Activity.this,"You Finish The Game",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    mpsalah.start();
                    Toast.makeText(Quiz_Activity.this, "Wrong",Toast.LENGTH_SHORT).show();
                    Toast.makeText(Quiz_Activity.this, "You Lost The Game",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

    }
    private void newQuestion(int number){
        iv_flag.setImageResource(list.get(number-1).getImage());

        int correct_answer = r.nextInt(4)+1;

        int firstbutton = number - 1;
        int secondbutton;
        int thirdbutton;
        int fourthbutton;


        switch (correct_answer){
            case 1:
                b_answer1.setText(list.get(firstbutton).getName());

                do {
                    secondbutton = r.nextInt(list.size());
                }while (secondbutton == firstbutton);
                do {
                    thirdbutton = r.nextInt(list.size());
                }while (thirdbutton == firstbutton   || thirdbutton == secondbutton  );
                do {
                    fourthbutton = r.nextInt(list.size());
                }while (fourthbutton == firstbutton   || fourthbutton == secondbutton  || fourthbutton == thirdbutton);

                b_answer2.setText(list.get(secondbutton).getName());
                b_answer3.setText(list.get(thirdbutton).getName());
                b_answer4.setText(list.get(fourthbutton).getName());


                break;
            case 2:
                b_answer2.setText(list.get(firstbutton).getName());

                do {
                    secondbutton = r.nextInt(list.size());
                }while (secondbutton == firstbutton);
                do {
                    thirdbutton = r.nextInt(list.size());
                }while (thirdbutton == firstbutton   || thirdbutton == secondbutton  );
                do {
                    fourthbutton = r.nextInt(list.size());
                }while (fourthbutton == firstbutton   || fourthbutton == secondbutton  || fourthbutton == thirdbutton);

                b_answer1.setText(list.get(secondbutton).getName());
                b_answer3.setText(list.get(thirdbutton).getName());
                b_answer4.setText(list.get(fourthbutton).getName());
                break;
            case 3:
                b_answer3.setText(list.get(firstbutton).getName());

                do {
                    secondbutton = r.nextInt(list.size());
                }while (secondbutton == firstbutton);
                do {
                    thirdbutton = r.nextInt(list.size());
                }while (thirdbutton == firstbutton   || thirdbutton == secondbutton  );
                do {
                    fourthbutton = r.nextInt(list.size());
                }while (fourthbutton == firstbutton   || fourthbutton == secondbutton  || fourthbutton == thirdbutton);

                b_answer2.setText(list.get(secondbutton).getName());
                b_answer1.setText(list.get(thirdbutton).getName());
                b_answer4.setText(list.get(fourthbutton).getName());
                break;
            case 4:
                b_answer4.setText(list.get(firstbutton).getName());

                do {
                    secondbutton = r.nextInt(list.size());
                }while (secondbutton == firstbutton);
                do {
                    thirdbutton = r.nextInt(list.size());
                }while (thirdbutton == firstbutton   || thirdbutton == secondbutton  );
                do {
                    fourthbutton = r.nextInt(list.size());
                }while (fourthbutton == firstbutton   || fourthbutton == secondbutton  || fourthbutton == thirdbutton);

                b_answer2.setText(list.get(secondbutton).getName());
                b_answer3.setText(list.get(thirdbutton).getName());
                b_answer1.setText(list.get(fourthbutton).getName());
                break;
        }
    }
}
