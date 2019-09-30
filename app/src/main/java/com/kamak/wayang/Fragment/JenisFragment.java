package com.kamak.wayang.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kamak.wayang.Adapter.Adapter_wayang;
import com.kamak.wayang.Data_Jenis_Wayang;
import com.kamak.wayang.MainActivity;
import com.kamak.wayang.Model_Wayang;
import com.kamak.wayang.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class JenisFragment extends Fragment {


    @BindView(R.id.tittle)
    TextView tittle;
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private ArrayList<Model_Wayang> list;


    public JenisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_jenis, container, false);
        unbinder = ButterKnife.bind(this, v);
        rv.setHasFixedSize(true);
        list = new ArrayList<Model_Wayang>();
        list.addAll(Data_Jenis_Wayang.getListData());

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        Adapter_wayang listSejarah = new Adapter_wayang(getContext());
        listSejarah.setModoel_wayang(list);
        rv.setAdapter(listSejarah);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
