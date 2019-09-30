package com.kamak.wayang.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.kamak.wayang.Database;
import com.kamak.wayang.MainActivity;
import com.kamak.wayang.R;
import com.kamak.wayang.WayangItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Quiz_duaFragment extends Fragment {

    List<WayangItem> list;
    Random r;
    int turn = 1;

    @BindView(R.id.line1)
    LinearLayout line1;
    Unbinder unbinder;

    public Quiz_duaFragment() {
        // Required empty public constructor
    }

    View v;
    Button b_answer1,b_answer2,b_answer3,b_answer4;
    ImageView iv_flag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_quiz_dua, container, false);
        iv_flag = (ImageView)v.findViewById(R.id.iv_flag);

        b_answer1 = (Button)v.findViewById(R.id.b_answer1);
        b_answer2 = (Button)v.findViewById(R.id.b_answer2);
        b_answer3 = (Button)v.findViewById(R.id.b_answer3);
        b_answer4 = (Button)v.findViewById(R.id.b_answer4);
        list = new ArrayList<>();
        r = new Random();
        MainActivity.mediaPlayer.pause();

        //add all wayang image and name
        for (int i = 0; i < new Database().answer.length; i++) {
            list.add(new WayangItem(new Database().answer[i], new Database().flags[i]));
        }

        //suffle the wayang
        Collections.shuffle(list);

        newQuestion(turn);

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b_answer1.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();

                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(getContext(), "You Finish The Game", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), "You Lost The Game", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }

            }
        });
        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b_answer2.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();

                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(getContext(), "You Finish The Game", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), "You Lost The Game", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }


            }
        });
        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b_answer3.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();

                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(getContext(), "You Finish The Game", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), "You Lost The Game", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }


            }
        });
        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b_answer4.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();

                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(getContext(), "You Finish The Game", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), "You Lost The Game", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }

            }
        });


        return null;
    }

    private void newQuestion(int number) {
        iv_flag.setImageResource(list.get(number - 1).getImage());

        int correct_answer = r.nextInt(4) + 1;

        int firstbutton = number - 1;
        int secondbutton;
        int thirdbutton;
        int fourthbutton;


        switch (correct_answer) {
            case 1:
                b_answer1.setText(list.get(firstbutton).getName());

                do {
                    secondbutton = r.nextInt(list.size());
                } while (secondbutton == firstbutton);
                do {
                    thirdbutton = r.nextInt(list.size());
                } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                do {
                    fourthbutton = r.nextInt(list.size());
                } while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);

                b_answer2.setText(list.get(secondbutton).getName());
                b_answer3.setText(list.get(thirdbutton).getName());
                b_answer4.setText(list.get(fourthbutton).getName());


                break;
            case 2:
                b_answer2.setText(list.get(firstbutton).getName());

                do {
                    secondbutton = r.nextInt(list.size());
                } while (secondbutton == firstbutton);
                do {
                    thirdbutton = r.nextInt(list.size());
                } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                do {
                    fourthbutton = r.nextInt(list.size());
                } while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);

                b_answer1.setText(list.get(secondbutton).getName());
                b_answer3.setText(list.get(thirdbutton).getName());
                b_answer4.setText(list.get(fourthbutton).getName());
                break;
            case 3:
                b_answer3.setText(list.get(firstbutton).getName());

                do {
                    secondbutton = r.nextInt(list.size());
                } while (secondbutton == firstbutton);
                do {
                    thirdbutton = r.nextInt(list.size());
                } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                do {
                    fourthbutton = r.nextInt(list.size());
                } while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);

                b_answer2.setText(list.get(secondbutton).getName());
                b_answer1.setText(list.get(thirdbutton).getName());
                b_answer4.setText(list.get(fourthbutton).getName());
                break;
            case 4:
                b_answer4.setText(list.get(firstbutton).getName());

                do {
                    secondbutton = r.nextInt(list.size());
                } while (secondbutton == firstbutton);
                do {
                    thirdbutton = r.nextInt(list.size());
                } while (thirdbutton == firstbutton || thirdbutton == secondbutton);
                do {
                    fourthbutton = r.nextInt(list.size());
                } while (fourthbutton == firstbutton || fourthbutton == secondbutton || fourthbutton == thirdbutton);

                b_answer2.setText(list.get(secondbutton).getName());
                b_answer3.setText(list.get(thirdbutton).getName());
                b_answer1.setText(list.get(fourthbutton).getName());
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
