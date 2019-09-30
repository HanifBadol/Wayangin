package com.kamak.wayang.Fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kamak.wayang.MainActivity;
import com.kamak.wayang.R;
import com.kamak.wayang.VideoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.kamak.wayang.MainActivity.mediaPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.tittle)
    TextView tittle;
    @BindView(R.id.sejarah)
    CardView sejarah;
    @BindView(R.id.jenis)
    CardView jenis;
    @BindView(R.id.video)
    CardView video;
    @BindView(R.id.about)
    CardView about;
    @BindView(R.id.sv)
    ScrollView sv;
    Unbinder unbinder;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, v);
        mediaPlayer.start();
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        if(mediaPlayer != null && !mediaPlayer.isPlaying())
            mediaPlayer.start();
        super.onResume();
    }

    @OnClick({R.id.sejarah, R.id.jenis, R.id.video, R.id.about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sejarah:
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.enter_from_right).
                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
                        replace(R.id.content,
                                new SejarahFragment(),
                                SejarahFragment.class.getSimpleName())
                        .addToBackStack(null).commit();
                break;
            case R.id.jenis:
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.enter_from_right).
                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
                        replace(R.id.content,
                                new JenisFragment(),
                                JenisFragment.class.getSimpleName())
                        .addToBackStack(null).commit();
                break;
            case R.id.video:
                startActivity(new Intent(getContext(), VideoActivity.class));
                break;
            case R.id.about:
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.enter_from_right).
                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
                        replace(R.id.content,
                                new AboutFragment(),
                                AboutFragment.class.getSimpleName())
                        .addToBackStack(null).commit();

                break;
        }
    }


}
