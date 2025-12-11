import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pasien> data = CsvLoader.loadPasien("src/Data_Pasien.csv");
        // System.out.println("DATA LOADED: " + data.size());

        while (true) {
            System.out.println();
            System.out.println("=== Sistem Antrian IGD ===");
            System.out.println("Function : ");
            System.out.println("- (1) Show All Pasien");
            System.out.println("- (2) Search Pasien");
            System.out.println("- (3) Sort Pasien");
            System.out.println("- (4) Prioritas Pasien");
            System.out.println("- (5) Tambah Pasien");
            System.out.println("- (6) Stop");
            int fungsi = sc.nextInt();
            sc.nextLine();
            if (fungsi == 1) {
                showAllPasien(data);
            } else if (fungsi == 2) {
                // code search
                System.out.print("\nMasukkan ID atau nama pasien yang ingin dicari: ");
                String search = sc.nextLine();
                ArrayList<Pasien> hasil = linearSearchPasien(data, search);
                if (hasil != null) {
                    printPasien(hasil);
                } else {
                    System.out.println("Pasien " + search + " Tidak ditemukan.");
                }
            } else if (fungsi == 3) {
                // code sort
                System.out.println("Urutkan pasien berdasarkan apa?");
                System.out.println("1 = Urgensi");
                System.out.println("2 = Waktu Kedatangan");
                System.out.println("3 = Usia");
                int filter = sc.nextInt();
                selectionSort(data, filter);
                if (filter == 1) {
                    System.out.println("=== Data Pasien Dengan Urgensi Dari Paling Tinggi ===");
                } else if (filter == 2) {
                    System.out.println("=== Data Pasien Dengan Waktu Kedatangan Dari Paling Awal ===");
                } else if (filter == 3) {
                    System.out.println("=== Data Pasien Dengan Usia Dari Paling Muda ===");
                }
                for (Pasien p : data) {
                    if (filter == 1) {
                        System.out.println("ID: " + p.getId() +
                                " | Nama: " + p.getNama() +
                                " | Urgensi: " + p.getUrgensi());
                    } else if (filter == 2) {
                        System.out.println("ID: " + p.getId() +
                                " | Nama: " + p.getNama() +
                                " | Waktu Kedatangan: " + p.getWaktuKedatangan().toString().replace("T", " "));
                    } else if (filter == 3) {
                        System.out.println("ID: " + p.getId() +
                                " | Nama: " + p.getNama() +
                                " | Usia: " + p.getUsia());
                    }
                }
            } else if (fungsi == 4) {
                prioritasPasien(data, sc);
            } else if (fungsi == 5) {
                System.out.println("\nMasukkan Data Pasien");

                System.out.print("Nama : ");
                String nama = sc.nextLine();

                System.out.print("Jenis Kelamin : ");
                String jk = sc.nextLine();

                System.out.print("Usia : ");
                int usia = sc.nextInt();
                sc.nextLine();

                System.out.print("Alamat : ");
                String alamat = sc.nextLine();

                System.out.print("Keluhan : ");
                String keluhan = sc.nextLine();

                System.out.print("Riwayat Penyakit : ");
                String riwayat = sc.nextLine();

                System.out.print("Urgensi (1-3) : ");
                int urgensi = sc.nextInt();
                sc.nextLine();

                while (urgensi < 1 || urgensi > 3) {
                    System.out.print("Masukkan urgensi valid (1-3): ");
                    urgensi = sc.nextInt();
                    sc.nextLine();
                }

                int id = generateNextId(data);

                Pasien newPasien = new Pasien(
                        id,
                        nama,
                        jk,
                        usia,
                        alamat,
                        keluhan,
                        riwayat,
                        LocalDateTime.now(),
                        urgensi);

                data.add(newPasien);

                try {
                    CsvLoader.appendPasien("src/Data_Pasien.csv", newPasien);
                    System.out.println("Pasien berhasil ditambahkan");
                } catch (Exception e) {
                    System.out.println("Gagal menambahkan pasien");
                    e.printStackTrace();
                }

            } else if (fungsi == 6) {
                break;
            } else {
                System.out.println("Masukkan angka (function) yang tersedia");
            }
        }

        sc.close();
    }

    public static void showAllPasien(ArrayList<Pasien> list) {
        System.out.println("===== DAFTAR PASIEN IGD =====");

        for (Pasien p : list) {
            System.out.println("----------------------------------------");
            System.out.println("ID              : " + p.getId());
            System.out.println("Nama            : " + p.getNama());
            System.out.println("Jenis Kelamin   : " + p.getJenisKelamin());
            System.out.println("Alamat          : " + p.getAlamat());
            System.out.println("Keluhan         : " + p.getKeluhan());
            System.out.println("Riwayat         : " + p.getRiwayat());
            System.out.println("Usia            : " + p.getUsia());
            System.out.println("Kedatangan      : " + p.getWaktuKedatangan());
            System.out.println("Urgensi (1-3)   : " + p.getUrgensi());
        }

        System.out.println("----------------------------------------");
    }

    public static ArrayList<Pasien> linearSearchPasien(ArrayList<Pasien> list, String search) {
        ArrayList<Pasien> hasil = new ArrayList<>();

        // 1. Coba parse ke int untuk cari ID
        try {
            int idDicari = Integer.parseInt(search);
            for (Pasien p : list) {
                if (p.getId() == idDicari) {
                    hasil.add(p);
                }
            }
        } catch (NumberFormatException e) {
            // berarti bukan angka → lanjut cari nama
        }

        // 2. Cari berdasarkan nama (case-insensitive)
        for (Pasien p : list) {
            if (p.getNama().toLowerCase().contains(search.toLowerCase())) {
                hasil.add(p);
            }
        }
        if (hasil.isEmpty()) {
            return null;
        } else {
            return hasil;
        }
    }

    // =======================
    // PRINT DATA PASIEN
    // =======================
    public static void printPasien(ArrayList<Pasien> p) {
        System.out.println("\n=== Data Pasien Ditemukan ===");
        for (Pasien pasien : p) {
            System.out.println("ID              : " + pasien.getId());
            System.out.println("Nama            : " + pasien.getNama());
            System.out.println("Jenis Kelamin   : " + pasien.getJenisKelamin());
            System.out.println("Alamat          : " + pasien.getAlamat());
            System.out.println("Keluhan         : " + pasien.getKeluhan());
            System.out.println("Riwayat         : " + pasien.getRiwayat());
            System.out.println("Kedatangan      : " + pasien.getWaktuKedatangan());
            System.out.println("Urgensi (1-3)   : " + pasien.getUrgensi());
            System.out.println("==============================");
        }
    }

    public static void selectionSort(ArrayList<Pasien> list, int filter) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int indexMin = i;

            if (filter == 1) {
                for (int j = i + 1; j < n; j++) {
                    if (list.get(j).getUrgensi() < list.get(indexMin).getUrgensi()) {
                        indexMin = j;
                    }
                }
            } else if (filter == 2) {
                for (int j = i + 1; j < n; j++) {
                    if (list.get(j).getWaktuKedatangan()
                            .isBefore(list.get(indexMin).getWaktuKedatangan())) {
                        indexMin = j;
                    }
                }
            } else if (filter == 3) {
                for (int j = i + 1; j < n; j++) {
                    if (list.get(j).getUsia() < list.get(indexMin).getUsia()) {
                        indexMin = j;
                    }
                }
            }

            // swap
            Pasien temp = list.get(i);
            list.set(i, list.get(indexMin));
            list.set(indexMin, temp);
        }
    }

    public static int generateNextId(ArrayList<Pasien> data) {
        if (data.isEmpty())
            return 1;
        return data.get(data.size() - 1).getId() + 1;
    }

    public static void prioritasPasien(ArrayList<Pasien> data, Scanner sc) {

        PriorityQueue<Pasien> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.getUrgensi() != b.getUrgensi()) {
                        return Integer.compare(a.getUrgensi(), b.getUrgensi()); 
                    }
                    return a.getWaktuKedatangan()
                            .compareTo(b.getWaktuKedatangan());
                });

        pq.addAll(data);

        if (pq.isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        Pasien next = pq.peek();
        System.out.println("\n=== Pasien urutan selanjutnya ===");
        System.out.println(next.getNama() + " | Urgensi " + next.getUrgensi() + " | Waktu Kedatangan "
                + next.getWaktuKedatangan().toString().replace("T", " "));

        System.out.print("Sudah masuk IGD? (y/n): ");
        String j = sc.nextLine();

        if (j.equalsIgnoreCase("y")) {
            pq.poll();
            data.removeIf(p -> p.getId() == next.getId());
            CsvLoader.savePasien(data);
            System.out.println("Pasien masuk IGD & dihapus dari antrian.");
        }
    }

}
