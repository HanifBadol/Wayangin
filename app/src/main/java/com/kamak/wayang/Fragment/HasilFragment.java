package com.kamak.wayang.Fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kamak.wayang.MainActivity;
import com.kamak.wayang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HasilFragment extends Fragment   {


    @BindView(R.id.nilai)
    TextView nilai;
    @BindView(R.id.benar)
    TextView benar;
    @BindView(R.id.line1)
    LinearLayout line1;
    @BindView(R.id.btnnext)
    Button btnnext;
    Unbinder unbinder;
    @BindView(R.id.img)
    ImageView img;

    public HasilFragment() {
        // Required empty public constructor
    }

    int hasil;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hasil, container, false);
        unbinder = ButterKnife.bind(this, view);

        hasil = Quiz_satuFragment.benar * 20;
        benar.setText("Jawaban Benar : " + Quiz_satuFragment.benar + "\nJawaban Salah : " + Quiz_satuFragment.salah + "\n Nilai Anda : " + hasil);


        if (hasil <= 60) {
            img.setImageResource(R.drawable.semangat);

        } else {

            img.setImageResource(R.drawable.trophy);
        }
        return view;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnnext)
    public void onViewClicked() {
        Intent intent=new Intent(getContext(), MainActivity.class);
        startActivity(intent);


    }
    public void onBackPressed() {
        super.getActivity().onBackPressed();
        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.enter_from_right).
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
                replace(R.id.content,
                        new HomeFragment(),
                        HomeFragment.class.getSimpleName())
                .addToBackStack(null).commit();
    }

}
