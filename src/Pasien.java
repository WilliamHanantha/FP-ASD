import java.util.ArrayList;

public class Pasien {
    int id;
    static int counter = 1;
    String nama;
    String jenisKelamin;
    int usia;
    String alamat;
    String keluhan;
    String riwayat;
    String waktuKedatangan;
    int urgensi; // 1 = kritis, 2 = sedang, 3 = ringan

    public Pasien(int id, String nama, String jenisKelamin, int usia, String alamat, String keluhan, String riwayat,
            String waktuKedatangan, int urgensi) {
        this.id = id;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.usia = usia;
        this.alamat = alamat;
        this.keluhan = keluhan;
        this.riwayat = riwayat;
        this.waktuKedatangan = waktuKedatangan;
        this.urgensi = urgensi;
    }

    public Pasien(String nama, String jenisKelamin, int usia, String alamat, String keluhan, String riwayat,
            String waktuKedatangan, int urgensi) {
        this.id = counter++;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.usia = usia;
        this.alamat = alamat;
        this.keluhan = keluhan;
        this.riwayat = riwayat;
        this.waktuKedatangan = waktuKedatangan;
        this.urgensi = urgensi;
    }

    public static void updateCounter(ArrayList<Pasien> list) {
        int max = 0;
        for (Pasien p : list) {
            if (p.getId() > max) max = p.getId();
        }
        counter = max + 1;  // supaya tidak bentrok
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getRiwayat() {
        return riwayat;
    }

    public void setRiwayat(String riwayat) {
        this.riwayat = riwayat;
    }

    public String getWaktuKedatangan() {
        return waktuKedatangan;
    }

    public void setWaktuKedatangan(String waktuKedatangan) {
        this.waktuKedatangan = waktuKedatangan;
    }

    public int getUrgensi() {
        return urgensi;
    }

    public void setUrgensi(int urgensi) {
        this.urgensi = urgensi;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }
}
