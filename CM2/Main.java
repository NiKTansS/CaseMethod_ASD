package CM2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListAntrian antrian = new LinkedListAntrian();
        QueueTransaksi riwayat = new QueueTransaksi(100);

        while (true) {
            System.out.println("\n=== SISTEM ANTRIAN KLINIK ===");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilih = sc.nextInt();
            sc.nextLine(); 

            switch (pilih) {
                case 1:
                    System.out.print("Nama Pasien: ");
                    String nama = sc.nextLine();
                    System.out.print("NIK: ");
                    String nik = sc.nextLine();
                    System.out.print("Keluhan: ");
                    String keluhan = sc.nextLine();
                    Pasien p = new Pasien(nama, nik, keluhan);
                    antrian.tambahPasien(p);
                    System.out.println(">> Pasien masuk ke dalam antrian.");
                    break;

                case 2:
                    System.out.println("\n-- Antrian Pasien --");
                    antrian.tampilAntrian();
                    break;

                case 3:
                    if (antrian.isEmpty()) {
                        System.out.println("Tidak ada pasien dalam antrian.");
                        break;
                    }
                    Pasien dilayani = antrian.layaniPasien();
                    System.out.println("Pasien " + dilayani.nama + " dipanggil");
                    System.out.print("Masukkan ID Dokter: ");
                    String idDokter = sc.nextLine();
                    System.out.print("Masukkan Nama Dokter: ");
                    String namaDokter = sc.nextLine();
                    System.out.print("Masukkan Durasi layanan (jam): ");
                    int durasi = sc.nextInt();
                    sc.nextLine();
                    Dokter d = new Dokter(idDokter, namaDokter);
                    TransaksiLayanan t = new TransaksiLayanan(dilayani, d, durasi);
                    riwayat.enqueue(t);
                    System.out.println(">> Pasien telah dilayani, transaksi berhasil dicatat.");
                    break;

                case 4:
                    System.out.println(">> Sisa pasien dalam antrian: " + antrian.sisaAntrian());
                    break;

                case 5:
                    System.out.println("\n-- Riwayat Transaksi --");
                    System.out.println("Daftar Transaksi:" );
                    riwayat.tampilRiwayat();
                    break;

                case 0:
                    System.out.println("Terima kasih.");
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
