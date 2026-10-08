/**
 * Test runner sederhana (tanpa library eksternal) untuk Kode 1 - HitungKomisi.
 * Setiap test case merujuk ke tabel pelacakan (traceability) pada laporan.
 *
 * SC = Statement Coverage, DC = Decision Coverage, C/DC = Condition/Decision Coverage
 */
public class HitungKomisiTest {

    private static int passed = 0;
    private static int failed = 0;

    private static void check(String id, String kriteria, int total, boolean member, double expected) {
        double actual = new HitungKomisi().getKomisi(total, member);
        boolean ok = Math.abs(actual - expected) < 1e-9;
        if (ok) passed++; else failed++;
        System.out.printf("%-6s [%-8s] input=(%4d, %-5s) expected=%.2f actual=%.2f -> %s%n",
                id, kriteria, total, member, expected, actual, ok ? "PASS" : "FAIL");
    }

    public static void main(String[] args) {
        System.out.println("=== Statement Coverage (SC) ===");
        check("TC-S1", "SC", 1500, true,  0.20); // node 3,4,5,11
        check("TC-S2", "SC",  700, false, 0.10); // node 3,4,7,8,11
        check("TC-S3", "SC",  300, false, 0.05); // node 3,4,7,10,11

        System.out.println("\n=== Decision Coverage (DC) ===");
        check("TC-D1", "DC", 1500, true,  0.20); // D1 = True
        check("TC-D2", "DC",  700, false, 0.10); // D1 = False, D2 = True
        check("TC-D3", "DC",  300, false, 0.05); // D1 = False, D2 = False

        System.out.println("\n=== Condition/Decision Coverage (C/DC) ===");
        check("TC-C1", "C/DC", 1500, true,  0.20); // C1=T, C2=T, D1=T
        check("TC-C2", "C/DC", 1500, false, 0.10); // C1=T, C2=F, D1=F, C3=T, D2=T
        check("TC-C3", "C/DC",  300, false, 0.05); // C1=F, D1=F, C3=F, D2=F

        System.out.println("\n=== Tambahan: nilai batas (boundary) ===");
        check("TC-B1", "Boundary", 1000, true,  0.10); // 1000 > 1000 = False
        check("TC-B2", "Boundary", 1001, true,  0.20);
        check("TC-B3", "Boundary",  500, true,  0.05); // 500 > 500 = False
        check("TC-B4", "Boundary",  501, false, 0.10);

        System.out.printf("%nHasil: %d PASS, %d FAIL%n", passed, failed);
        if (failed > 0) System.exit(1);
    }
}
