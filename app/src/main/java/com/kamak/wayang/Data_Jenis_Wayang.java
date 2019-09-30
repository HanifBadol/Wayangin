package com.kamak.wayang;

import java.util.ArrayList;

public class Data_Jenis_Wayang {
    public static String[][] list_sejarah = new String[][]{
            {"Wayang Orang",
                    "https://wisatasolo.id/en/wp-content/uploads/2018/12/wayang-orang-700x450.png"
                    , "Wayang orang disebut juga dengan istilah wayang wong (bahasa Jawa) adalah wayang yang dimainkan dengan menggunakan orang sebagai tokoh dalam cerita wayang tersebut. Wayang orang diciptakan oleh Sultan Hamangkurat I pada tahun 1731. Sesuai dengan nama sebutannya, wayang tersebut tidak lagi dipergelarkan dengan memainkan boneka-boneka wayang (wayang kulit yang biasanya terbuat dari bahan kulit kerbau ataupun yang lain), akan tetapi menampilkan manusia-manusia sebagai pengganti boneka-boneka wayang tersebut. Mereka memakai pakaian sama seperti hiasan-hiasan yang dipakai pada wayang kulit. Supaya bentuk muka atau bangun muka mereka menyerupai wayang kulit (kalau dilihat dari samping), sering kali pemain wayang orang ini diubah/dihias mukanya dengan tambahan gambar atau lukisan. Cerita-cerita yang diangkat dalam wayang orang berbasis kepada due epic cerita kolosal yaitu Mahabharata dan Ramayana. Hal yang menarik dari pertunjukan wayang orang ini adalah adanya tari kolosal atau individu per pemain di setiap jeda cerita. Selain itu wayang orang juga menampilkan tokoh punakawan sebagai pencair suasana yang merupakan penggambaran keadaan kawulo alit atau masyarakat secara umum dan abdi dalem. Pertunjukan wayang orang yang masih ada saat ini, salah satunya adalah wayang orang Barata (di kawasan Pasar Senen, Jakarta), Taman Mini Indonesia Indah, Taman Sriwedari Solo, Ngesti Pandawa di Taman Budaya Raden Saleh Semarang, dan lain-lain."
            },
            {"Wayang Golek",
                    "https://www.schoolpouringrights.com/wp-content/uploads/2018/01/11-765x510.jpg"
                   ,"Wayang golek merupakan salah satu dari ragam kesenian wayang yang terbuat dari bahan kayu yang merupakan hasil perkembangan wayang kulit dari keterbatasan waktu supaya dapat ditampilkan pada siang atau malam hari. Pertama kali diperkenalkan oleh Sunan Kudus di daerah Kudus (dikenal Wayang Menak), Cirebon (dikenal Wayang cepak) lalu Parahyangan. Wayang golek sangat populer di wilayah Jawa Barat, daerah penyebarannya terbentang luas dari Cirebon hingga Banten"
                    },
            {"Wayang Kulit",
                    "https://cdn.imgbin.com/2/15/18/imgbin-semar-wayang-kulit-punokawan-cepot-others-illustration-of-person-s-face-3eFSPjSg9XJG1L7UT07w3emQR.jpg",
            " Wayang kulit adalah seni tradisional Indonesia yang terutama berkembang di Jawa. Wayang berasal dari kata 'Ma Hyang' yang artinya menuju kepada roh spiritual, dewa, atau Tuhan Yang Maha Esa. Ada juga yang mengartikan wayang adalah istilah bahasa Jawa yang bermakna 'bayangan', hal ini disebabkan karena penonton juga bisa menonton wayang dari belakang kelir atau hanya bayangannya saja. Wayang kulit dimainkan oleh seorang dalang yang juga menjadi narator dialog tokoh-tokoh wayang, dengan diiringi oleh musik gamelan yang dimainkan sekelompok nayaga dan tembang yang dinyanyikan oleh para pesinden.\n" +
                    "    Dalang memainkan wayang kulit di balik kelir, yaitu layar yang terbuat dari kain putih, sementara di belakangnya disorotkan lampu listrik atau lampu minyak (blencong), sehingga para penonton yang berada di sisi lain dari layar dapat melihat bayangan wayang yang jatuh ke kelir. Untuk dapat memahami cerita wayang (lakon), penonton harus memiliki pengetahuan akan tokoh-tokoh wayang yang bayangannya tampil di layar.Pertunjukan wayang kulit telah diakui oleh UNESCO pada tanggal 7 November 2003, sebagai karya kebudayaan yang mengagumkan dalam bidang cerita narasi dan warisan yang indah dan berharga ( Masterpiece of Oral and Intangible Heritage of Humanity"}};

    public static ArrayList<Model_Wayang> getListData(){
        Model_Wayang model_wayang=null;
        ArrayList<Model_Wayang>list=new ArrayList<>();
        for (int x=0;x<list_sejarah.length;x++){
            model_wayang=new Model_Wayang();
            model_wayang.setJudul(list_sejarah[x][0]);
            model_wayang.setKet(list_sejarah[x][2]);
            model_wayang.setImg(list_sejarah[x][1]);


            list.add(model_wayang);
        }
        return list;
    }
}
