    import java.io.ByteArrayOutputStream;
    import java.io.PrintStream;

    /**
     * Test runner sederhana (tanpa library eksternal) untuk Kode 2 - ProsesAngkaJava.
     * Output konsol ditangkap lalu dibandingkan dengan output yang diharapkan
     * sesuai tabel pelacakan (traceability) pada laporan.
     */
    public class ProsesAngkaJavaTest {

        private static int passed = 0;
        private static int failed = 0;

        private static String run(int x, int y) {
            PrintStream original = System.out;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            System.setOut(new PrintStream(buffer));
            try {
                new ProsesAngkaJava().prosesAngka(x, y);
            } finally {
                System.setOut(original);
            }
            return buffer.toString();
        }

        private static String ganjil(int n) {
            return "Ganjil".repeat(n);
        }

        private static void check(String id, String keterangan, int x, int y, String expected) {
            String actual = run(x, y);
            boolean ok = actual.equals(expected);
            if (ok) passed++; else failed++;
            System.out.printf("%-3s (x=%3d, y=%3d) %s -> %s%n", id, x, y, ok ? "PASS" : "FAIL", keterangan);
            System.out.println("      expected: " + expected);
            System.out.println("      actual  : " + actual);
        }

        public static void main(String[] args) {
            // T1: if#1 True (x<y), x menjadi 13, i = 0..12 -> ganjil: 1,3,5,7,9,11 (6 kali)
            check("T1", "Branch 2T, 5T, 5F, 6T, 6F", 3, 5,
                    "Kondisi Awal Terpenuhi" + ganjil(6) + "Selesai");

            // T2: if#1 False (x>=y dan y>0), x tetap 2, i = 0..1 -> ganjil: 1 (1 kali)
            check("T2", "Branch 2F, 5T, 5F, 6T, 6F", 2, 1,
                    ganjil(1) + "Selesai");

            // T3: if#1 True lewat y<=0 (x<y = F, y<=0 = T), x menjadi 11, i = 0..10 -> ganjil: 5 kali
            check("T3", "Kondisi x<y=F, y<=0=T", 1, -1,
                    "Kondisi Awal Terpenuhi" + ganjil(5) + "Selesai");

            // T4: loop tidak pernah dimasuki: x<y=F, y<=0=T, x menjadi -5, (0 < -5) = False
            check("T4", "While False sejak awal", -15, -20,
                    "Kondisi Awal Terpenuhi" + "Selesai");

            System.out.printf("%nHasil: %d PASS, %d FAIL%n", passed, failed);
            if (failed > 0) System.exit(1);
        }
    }
