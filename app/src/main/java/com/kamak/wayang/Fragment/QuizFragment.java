package com.kamak.wayang.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kamak.wayang.MainActivity;
import com.kamak.wayang.Quiz_Activity;
import com.kamak.wayang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {


    @BindView(R.id.tittle)
    TextView tittle;
    @BindView(R.id.quiz1)
    CardView quiz1;
    @BindView(R.id.quiz2)
    CardView quiz2;
    @BindView(R.id.sv)
    LinearLayout sv;
    Unbinder unbinder;

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        unbinder = ButterKnife.bind(this, view);
        MainActivity.mediaPlayer.start();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.quiz1, R.id.quiz2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.quiz1:
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.enter_from_right).
                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
                        replace(R.id.content,
                                new Quiz_satuFragment(),
                                Quiz_satuFragment.class.getSimpleName())
                        .addToBackStack(null).commit();

                break;
            case R.id.quiz2:
                startActivity(new Intent(getContext(), Quiz_Activity.class));

                break;
        }
    }
}
