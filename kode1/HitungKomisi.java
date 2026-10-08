// 1.
public class HitungKomisi {
    // 2.
    public double getKomisi(int totalPenjualan, boolean isMember) {
        // 3.
        double komisi = 0.0;
        // 4.
        if (totalPenjualan > 1000 && isMember) {
            // 5.
            komisi = 0.20;
        // 6.
        } else {
            // 7.
            if (totalPenjualan > 500) {
                // 8.
                komisi = 0.10;
            // 9.
            } else {
                // 10.
                komisi = 0.05;
            }
        }
        // 11.
        return komisi;
    }
// 12.
}
