import java.util.ArrayList;
import java.util.Scanner;

public class PenilaianMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //menambahkan objek mahasiswa ke dalam list daftarmahasiswa
        Mahasiswa m1 = new Mahasiswa("22001", "Ali Rahman", "Informatika");//menampilkan data mhs yg sudah dideklarasikan sebelumnya
        Mahasiswa m2 = new Mahasiswa("22002", "Budi Santoso", "Informatika");
        Mahasiswa m3 = new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis");

        //menambhkan objek matkul ke list daftarmatkul
        MataKuliah mk1 = new MataKuliah("MK001", "Struktur Data", 3);//Membuat 3 mata kuliah dengan kode, nama, dan SKS.
        MataKuliah mk2 = new MataKuliah("MK002", "Basis Data", 3);
        MataKuliah mk3 = new MataKuliah("MK003", "Desain Web", 3);

        ArrayList<Penilaian> dataNilai = new ArrayList<>();//Menyimpan semua objek Penilaian dalam sebuah list.
        dataNilai.add(new Penilaian(m1, mk1, 80, 85, 90));
        dataNilai.add(new Penilaian(m1, mk2, 60, 75, 70));
        dataNilai.add(new Penilaian(m2, mk1, 75, 70, 80));
        dataNilai.add(new Penilaian(m3, mk2, 85, 90, 95));
        dataNilai.add(new Penilaian(m3, mk3, 80, 90, 65));

        int pilihan;
        do {
            System.out.println("\n=== MENU SISTEM AKADEMIK ===");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("\nDaftar Mahasiswa:");
                    m1.tampilMahasiswa();
                    m2.tampilMahasiswa();
                    m3.tampilMahasiswa();
                    break;
                case 2:
                    System.out.println("\nDaftar Mata Kuliah:");
                    mk1.tampilMatakuliah();
                    mk2.tampilMatakuliah();
                    mk3.tampilMatakuliah();
                    break;
                case 3:
                    System.out.println("\nData Penilaian:");
                    for (Penilaian p : dataNilai) {
                        p.tampilPenilaian();
                    }
                    break;
                case 4:
                System.out.println("\nData Penilaian:");
                // Konversi ArrayList ke array biasa
                Penilaian[] nilaiArray = dataNilai.toArray(new Penilaian[0]);
                
                // shorting Bubble sort sederhana (descending), mengurutkan nilai besar ke kecil berdasarkan nilaiakhir
                for (int i = 0; i < nilaiArray.length - 1; i++) {
                    for (int j = 0; j < nilaiArray.length - 1 - i; j++) {
                        if (nilaiArray[j].nilaiAkhir > nilaiArray[j+1].nilaiAkhir) {
                            // Tukar posisi
                            Penilaian temp = nilaiArray[j];
                            nilaiArray[j] = nilaiArray[j+1];
                            nilaiArray[j+1] = temp;
                        }
                    }
                }
                
                // Tampilkan hasil, menyimpan objek, dari
                for (Penilaian p : nilaiArray) {
                    p.tampilPenilaian();
                }
                break;
                case 5: //searching linear search, mencari nim yang dicari
                    System.out.print("Masukkan NIM mahasiswa yang dicari: ");
                    String cariNIM = sc.next();
                    boolean ditemukan = false;
                
                    // Cek mahasiswa berdasarkan NIM dari daftar penilaian
                    for (Penilaian p : dataNilai) {
                        if (p.mahasiswa.nim.equals(cariNIM)) {
                            System.out.println("Mahasiswa Ditemukan: ");
                            p.mahasiswa.tampilMahasiswa(); // Menampilkan data mahasiswa
                            ditemukan = true;
                            break; // Keluar loop setelah ditemukan
                        }
                    }
                
                    if (!ditemukan) { //false
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.\n");
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.\n");
            }
        } while (pilihan != 0);

        sc.close();
    }
}