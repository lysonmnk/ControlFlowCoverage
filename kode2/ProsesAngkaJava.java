public class ProsesAngkaJava {

    /**
     * Metode ini memproses dua nilai integer dan melakukan perulangan
     * berdasarkan nilai pertama, sambil mencetak output ke konsol.
     *
     * @param x Nilai integer pertama, digunakan sebagai batas atas perulangan.
     * @param y Nilai integer kedua, digunakan dalam kondisi awal.
     */
    public void prosesAngka(int x, int y) {
        // 1. Inisialisasi variabel counter
        int i = 0;

        // 2. Pengecekan kondisi awal
        if (x < y || y <= 0) {
            System.out.print("Kondisi Awal Terpenuhi");
            x = x + 10; // Nilai x diubah jika kondisi terpenuhi
        }

        // 3. Perulangan while berdasarkan nilai x
        while (i < x) {
            // Pengecekan apakah i adalah bilangan ganjil
            if (i % 2 != 0) {
                System.out.print("Ganjil");
            }
            i++; // Increment counter
        }

        // 4. Pesan akhir setelah loop selesai
        System.out.print("Selesai");
    }

    /**
     * Metode main untuk menjalankan dan menguji fungsi prosesAngka.
     */
    public static void main(String[] args) {
        ProsesAngkaJava pa = new ProsesAngkaJava();

        System.out.println("--- Menjalankan prosesAngka(3, 5) ---");
        pa.prosesAngka(3, 5); // Output yang sama seperti contoh C++
        System.out.println("\n"); // Baris baru untuk kerapian

        System.out.println("--- Menjalankan prosesAngka(1, -1) ---");
        pa.prosesAngka(1, -1);
        System.out.println("\n");
    }
}
