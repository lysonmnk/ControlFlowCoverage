#!/bin/sh
# Compile dan jalankan semua test (Kode 1 dan Kode 2).
# Butuh JDK 11+ (javac). Jika javac tidak ada, dicoba lewat modul jdk.compiler.
cd "$(dirname "$0")" || exit 1
if command -v javac >/dev/null 2>&1; then JC="javac"; else JC="java -m jdk.compiler/com.sun.tools.javac.Main"; fi
OUT="$(mktemp -d)"

echo "################ KODE 1 - HitungKomisi ################"
$JC -d "$OUT/k1" kode1/*.java || exit 1
java -cp "$OUT/k1" HitungKomisiTest || exit 1

echo
echo "################ KODE 2 - ProsesAngkaJava ################"
$JC -d "$OUT/k2" kode2/*.java || exit 1
java -cp "$OUT/k2" ProsesAngkaJavaTest || exit 1
echo
echo "--- main() ProsesAngkaJava ---"
java -cp "$OUT/k2" ProsesAngkaJava
rm -rf "$OUT"
