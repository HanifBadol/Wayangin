package com.kamak.wayang.Fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
public class Quiz_satuFragment extends Fragment {


    @BindView(R.id.pertanyaan)
    TextView pertanyaan;
    @BindView(R.id.pilihanA)
    RadioButton PilihanA;
    @BindView(R.id.pilihanB)
    RadioButton PilihanB;
    @BindView(R.id.pilihanC)
    RadioButton PilihanC;
    @BindView(R.id.pilihanD)
    RadioButton PilihanD;
    @BindView(R.id.radio_group)
    RadioGroup rg;
    Unbinder unbinder;
    int nomor = 0;
    public static int hasil, benar, salah;
    //pertanyaan quiz
    String[] pertanyaan_kuis = new String[]{
            "1. Cerita wayang adalah termasuk karya sastra ?",
            "2. Cerita wayang dibuat dengan mengambil cerita dari negara ?",
            "3. Cerita wayang dibuat berdasrkan pada cerita yang sudah pasti atau tetap yaitu ?",
            "4. Jenis karya sastra yang sama dengan cerita wayang adalah ?",
            "5. Persamaan cerita wayang dengan dongeng adalah sama-sama merupakan ?"
    };

    String[] pilihan_jawaban = new String[]{
            "Prosa lama", "Prosa baru", "Drama", "Pentas",
            "Turki", "Arab", "India", "Indonesia",
            "Cerita Ramayana dan Mahabarata", "Cerita Kerajaan Mataram", "Kerajaan Demak", "Kerajaan Aceh",
            "Majalah", "Novel", "Cerpen", "Dongeng",
            "Animasi", "Cerpen", "Cerita Khayal", "Cerita Nyata",
    };
    String[] jawaban_benar = new String[]{
            "Prosa lama",
            "India",
            "Cerita Ramayana dan Mahabarata",
            "Dongeng",
            "Cerita Khayal",
    };
    MediaPlayer mpbenar, mpsalah;
    @BindView(R.id.btnnext)
    Button btnnext;
    @BindView(R.id.line1)
    LinearLayout line1;

    public Quiz_satuFragment() {
        // Required empty public constructor
    }

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_quiz_satu, container, false);
        unbinder = ButterKnife.bind(this, v);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);
        mpbenar = MediaPlayer.create(getContext(), R.raw.benar);
        mpsalah = MediaPlayer.create(getContext(), R.raw.salah);
        MainActivity.mediaPlayer.pause();


        benar = 0;
        salah = 0;
        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnnext)
    public void onViewClicked() {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) v.findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) {
                mpbenar.start();
                Toast.makeText(getContext(), "Jawaban Benar",
                        Toast.LENGTH_LONG).show();
                benar++;
            } else {
                mpsalah.start();
                Toast.makeText(getContext(), "Jawaban Salah",
                        Toast.LENGTH_LONG).show();
                salah++;
            }
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            } else {
                hasil = benar * 20;
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.enter_from_right).
                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).
                        replace(R.id.content,
                                new HasilFragment(),
                                HasilFragment.class.getSimpleName())
                        .addToBackStack(null).commit();
            }
        } else {
            Toast.makeText(getContext(), "Pilih Jawaban dulu", Toast.LENGTH_SHORT).show();
        }
    }


    public void onBackPressed() {
        Toast.makeText(getContext(), "Selesaikan Terlebih Dahulu Sebisanya", Toast.LENGTH_SHORT).show();
    }
}
