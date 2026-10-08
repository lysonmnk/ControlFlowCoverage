# PPMPL W5S3 - Whitebox Testing: Control Flow Coverage

Kode dan test untuk modul praktikum PPMPL (11S3135) Session 5/03, IT Del.

## Isi
- `kode1/HitungKomisi.java` - Kode 1 (sesuai modul)
- `kode1/HitungKomisiTest.java` - test case SC, DC, C/DC + nilai batas
- `kode2/ProsesAngkaJava.java` - Kode 2 (sesuai modul, lengkap dengan `main`)
- `kode2/ProsesAngkaJavaTest.java` - test case T1..T4 (output konsol diverifikasi)
- `cfg/` - gambar Control Flow Graph (PNG)

## Menjalankan
Butuh JDK 11 atau lebih baru.

- Linux/macOS: `./run.sh`
- Windows: `run.bat`

Atau manual:

    cd kode1 && javac *.java && java HitungKomisiTest
    cd ../kode2 && javac *.java && java ProsesAngkaJavaTest && java ProsesAngkaJava

Tanpa library eksternal (tidak perlu JUnit/Maven). Program test keluar dengan kode 1 jika ada test gagal.

## Test case ringkas
Kode 1 (`getKomisi(totalPenjualan, isMember)`):

| Kriteria | Test case (totalPenjualan, isMember) -> komisi |
|---|---|
| SC dan DC | (1500, true) -> 0.20; (700, false) -> 0.10; (300, false) -> 0.05 |
| C/DC | (1500, true) -> 0.20; (1500, false) -> 0.10; (300, false) -> 0.05 |

Kode 2 (`prosesAngka(x, y)`):

| ID | (x, y) | Tujuan |
|---|---|---|
| T1 | (3, 5) | D1 True; coverage T1: SC 100%, Branch 83,33%, Condition 62,5% |
| T2 | (2, 1) | D1 False; bersama T1 -> Branch Coverage 100% |
| T3 | (1, -1) | C1 False, C2 True; bersama T1, T2 -> Condition Coverage 100% |
| T4 | (-15, -20) | loop tidak pernah dimasuki |
