import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pasien {
    int id;
    String nama;
    String jenisKelamin;
    int usia;
    String alamat;
    String keluhan;
    String riwayat;
    LocalDateTime waktuKedatangan;
    int urgensi; // 1 = kritis, 2 = sedang, 3 = ringan

    public Pasien(int id, String nama, String jenisKelamin, int usia, String alamat, String keluhan, String riwayat,
            LocalDateTime waktuKedatangan, int urgensi) {
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
            LocalDateTime waktuKedatangan, int urgensi) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.usia = usia;
        this.alamat = alamat;
        this.keluhan = keluhan;
        this.riwayat = riwayat;
        this.waktuKedatangan = waktuKedatangan;
        this.urgensi = urgensi;
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

    public LocalDateTime getWaktuKedatangan() {
        return waktuKedatangan;
    }

    public void setWaktuKedatangan(LocalDateTime waktuKedatangan) {
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
