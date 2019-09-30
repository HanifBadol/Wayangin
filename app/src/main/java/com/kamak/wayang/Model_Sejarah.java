package com.kamak.wayang;

public class Model_Sejarah {
    private String judul;

    private String ket;
    private String img;

    public static final String JUDUL = "JUDUL";
    public static final String KET = "ket";
    public static final String IMAGE="img";

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
