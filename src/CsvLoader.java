import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CsvLoader {

    public static ArrayList<Pasien> loadPasien(String path) {
        ArrayList<Pasien> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            boolean skipHeader = true;

            while ((line = br.readLine()) != null) {

                // skip header
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                if (line.trim().isEmpty())
                    continue;

                String[] c = parseCSVLine(line);

                Pasien p = new Pasien(
                        Integer.parseInt(c[0]), // id
                        c[1], // nama
                        c[2], // jk
                        Integer.parseInt(c[3]), // umur
                        c[4], // alamat
                        c[5], // keluhan
                        c[6], // riwayat
                        LocalDateTime.parse(c[7], formatter), // waktu
                        Integer.parseInt(c[8]) // urgensi
                );

                list.add(p);
            }

            System.out.println("Total Pasien: " + list.size());

        } catch (Exception e) {
            System.err.println("❌ Gagal load CSV!");
            e.printStackTrace();
        }

        return list;
    }

    // =====================
    // CSV PARSER (handle koma & quote)
    // =====================
    private static String[] parseCSVLine(String line) {
        ArrayList<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder cur = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '"') {
                inQuotes = !inQuotes;
            } else if (ch == ',' && !inQuotes) {
                result.add(cur.toString().trim());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }

        result.add(cur.toString().trim());
        return result.toArray(new String[0]);
    }

    public static void appendPasien(String path, Pasien p) throws IOException {
        try (FileWriter fw = new FileWriter(path, true)) {

            fw.append("\n" +
                    p.getId() + "," +
                    quote(p.getNama()) + "," +
                    quote(p.getJenisKelamin()) + "," +
                    p.getUsia() + "," +
                    quote(p.getAlamat()) + "," +
                    quote(p.getKeluhan()) + "," +
                    quote(p.getRiwayat()) + "," +
                    p.getWaktuKedatangan().format(formatter) + "," +
                    p.getUrgensi());
        }
    }

    public static void savePasien(ArrayList<Pasien> data) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("src/Data_Pasien.csv"))) {

            // header
            pw.println("id,nama,jenis_kelamin,usia,alamat,keluhan,riwayat,waktu_kedatangan,urgensi");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            for (Pasien p : data) {
                pw.println(
                        p.getId() + "," +
                                quote(p.getNama()) + "," +
                                quote(p.getJenisKelamin()) + "," +
                                p.getUsia() + "," +
                                quote(p.getAlamat()) + "," +
                                quote(p.getKeluhan()) + "," +
                                quote(p.getRiwayat()) + "," +
                                p.getWaktuKedatangan().format(formatter) + "," +
                                p.getUrgensi());
            }

        } catch (IOException e) {
            System.out.println("Gagal menyimpan CSV");
            e.printStackTrace();
        }
    }

    private static String quote(String value) {
        if (value.contains(",") || value.contains("\"")) {
            value = value.replace("\"", "\"\"");
            return "\"" + value + "\"";
        }
        return value;
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
