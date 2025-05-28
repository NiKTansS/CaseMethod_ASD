public class Mahasiswa {
  String nim;
  String nama;
  String prodi;

  // Constructor: Dipanggil saat membuat objek Mahasiswa baru
  Mahasiswa(String nimNiky, String nama, String prodi) { //Parameter
      nim = nimNiky;
      this.nama = nama;
      this.prodi = prodi;
  }
  //method
  void tampilMahasiswa() {
      System.out.println("NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi);
  }
}