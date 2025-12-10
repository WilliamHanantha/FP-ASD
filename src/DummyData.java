import java.util.ArrayList;

public class DummyData {

        public static ArrayList<Pasien> getDataPasien() {
                ArrayList<Pasien> list = new ArrayList<>();

                list.add(new Pasien(
                                1,
                                "Andi Saputra",
                                "Laki-laki",
                                34,
                                "Jl. Kenangan No. 10",
                                "Sesak Nafas",
                                "Asma",
                                "08:15",
                                1));

                list.add(new Pasien(
                                2,
                                "Budi Hartono",
                                "Laki-laki",
                                28,
                                "Jl. Merdeka No. 5",
                                "Demam Tinggi",
                                "Riwayat Tipes",
                                "10:18",
                                2));

                list.add(new Pasien(
                                3,
                                "Citra Lestari",
                                "Perempuan",
                                22,
                                "Jl. Mawar No. 3",
                                "Luka Robek",
                                "Tidak ada",
                                "12:20",
                                3));

                list.add(new Pasien(
                                4,
                                "Dewi Anggraini",
                                "Perempuan",
                                45,
                                "Jl. Melati No. 8",
                                "Nyeri Dada",
                                "Jantung",
                                "14:37",
                                1));

                list.add(new Pasien(
                                5,
                                "Eko Prasetyo",
                                "Laki-laki",
                                31,
                                "Jl. Pinang No. 2",
                                "Pusing",
                                "Migrain",
                                "14:25",
                                3));

                list.add(new Pasien(
                                6,
                                "Fajar Nugroho",
                                "Laki-laki",
                                27,
                                "Jl. Cemara No. 11",
                                "Kecelakaan ringan",
                                "Tidak ada",
                                "09:50",
                                2));

                list.add(new Pasien(
                                7,
                                "Gita Maulida",
                                "Perempuan",
                                19,
                                "Jl. Flamboyan No. 4",
                                "Patah Tulang",
                                "Riwayat cedera",
                                "06:10",
                                1));

                list.add(new Pasien(
                                8,
                                "Hari Santoso",
                                "Laki-laki",
                                40,
                                "Jl. Garuda No. 12",
                                "Batuk dan Flu",
                                "Asma Ringan",
                                "18:44",
                                3));

                list.add(new Pasien(
                                9,
                                "Indah Permata",
                                "Perempuan",
                                29,
                                "Jl. Anggrek No. 21",
                                "Mual dan Muntah",
                                "Lambung",
                                "21:58",
                                2));

                list.add(new Pasien(
                                10,
                                "Joko Priyono",
                                "Laki-laki",
                                55,
                                "Jl. Elang No. 7",
                                "Kehilangan Kesadaran",
                                "Hipertensi",
                                "17:02",
                                1));

                list.add(new Pasien(
                                11,
                                "Joko Widodo",
                                "Laki-laki",
                                55,
                                "Jl. Elang No. 7",
                                "Kehilangan Kesadaran",
                                "Hipertensi",
                                "17:02",
                                1));

                Pasien.updateCounter(list);
                return list;
        }
}
