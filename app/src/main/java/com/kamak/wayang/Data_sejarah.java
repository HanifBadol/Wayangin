package com.kamak.wayang;

import java.util.ArrayList;

public class Data_sejarah {

    public static String[][] list_sejarah = new String[][]{
            {"Pendahuluan",
                    "https://4.bp.blogspot.com/-DyFN3DnjilA/Wh5Lry5dMdI/AAAAAAAAFjo/OfaQsQEWpNcTdgPvNQJEmKDotDyiAbF4gCLcBGAs/w1200-h630-p-k-no-nu/gunungan%2Bwayang.png",
                    "Wayang adalah seni pertunjukkan asli Indonesia yang berkembang pesat di Pulau Jawa dan Bali. Pertunjukan ini juga populer di beberapa daerah seperti Sumatera dan Semenanjung Malaya juga memiliki beberapa budaya wayang yang terpengaruh oleh kebudayaan Jawa dan Hindu. UNESCO, lembaga yang membawahi kebudayaan dari PBB, pada 7 November 2003 menetapkan wayang sebagai pertunjukkan bayangan boneka tersohor dari Indonesia, sebuah warisan mahakarya dunia yang tak ternilai dalam seni bertutur (Masterpiece of Oral and Intangible Heritage of Humanity).\n" +
                            "Tak ada bukti yang menunjukkan wayang telah ada sebelum agama Hindu menyebar di Asia Selatan. Diperkirakan seni pertunjukan dibawa masuk oleh pedagang India."},
            {"Masuknya Wayang ke Indonesia",
                    "https://www.schoolpouringrights.com/wp-content/uploads/2018/01/11-765x510.jpg"
                    ,"UNESCO, lembaga yang membawahi kebudayaan dari PBB, pada 7 November 2003 menetapkan wayang sebagai pertunjukkan bayangan boneka tersohor dari Indonesia, sebuah warisan mahakarya dunia yang tak ternilai dalam seni bertutur (Masterpiece of Oral and Intangible Heritage of Humanity).\n" +
                    "Tak ada bukti yang menunjukkan wayang telah ada sebelum agama Hindu menyebar di Asia Selatan. Diperkirakan seni pertunjukan dibawa masuk oleh pedagang India.\n"},
            {"Hindu dan Wayang",
                    "https://purbakalasmaga.files.wordpress.com/2011/05/semar-gareng-petruk-bagong.jpg",
                    "Namun, Ketika agama Hindu masuk ke Indonesia dan menyesuaikan kebudayaan yang sudah ada, seni pertunjukan ini menjadi media efektif menyebarkan agama Hindu. Pertunjukan wayang menggunakan cerita Ramayana dan Mahabharata."},
            {"Wali 9 dan Wayang",
                    "https://1.bp.blogspot.com/-sqRo7GayX5k/VFibL57dgJI/AAAAAAAAXNs/r-2z_5z-Ap4/s1600/Sejarah-hubungan-wayang-kulit-dengan-Wali-Songo.png",
                    "Para Wali Sembilan di Jawa, sudah membagi wayang menjadi tiga. Wayang Kulit di timur, wayang wong di Jawa Tengah dan wayang golek di Jawa Barat. Adalah Raden Patah dan Sunan Kali Jaga yang berjasa besar. Carilah wayang di Jawa Barat, golek ono dalam bahasa jawi, sampai ketemu wong nya isi nya yang di tengah, jangan hanya ketemu kulit nya saja di Timur di wetan wiwitan. Mencari jati diri itu di Barat atau Kulon atau kula yang ada di dalam dada hati manusia. Maksud para Wali terlalu luhur dan tinggi filosofi nya. Wayang itu tulen dari Jawa asli, pakeliran itu artinya pasangan antara bayang bayang dan barang asli nya. Seperti dua kalimah syahadat. Adapun Tuhan masyrik wal maghrib itu harus di terjemahkan ke dalam bahasa jawa dulu yang artinya wetan kawitan dan kulon atau kula atau saya yang ada di dalam. Carilah tuhan yang kawitan pertama dan yang ada di dalam hati manusia. (sik)"}
    };

    public static ArrayList<Model_Sejarah> getListData(){
        Model_Sejarah model_sejarah=null;
        ArrayList<Model_Sejarah>list=new ArrayList<>();
        for (int x=0;x<list_sejarah.length;x++){
            model_sejarah=new Model_Sejarah();
            model_sejarah.setJudul(list_sejarah[x][0]);
            model_sejarah.setKet(list_sejarah[x][2]);
            model_sejarah.setImg(list_sejarah[x][1]);


            list.add(model_sejarah);
        }
        return list;
    }
}
