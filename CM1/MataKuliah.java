public class MataKuliah {
  String kodeMK;
  String namaMK; //variabel class
  int sks;
//MEMBUAT OBJEK BARU
  MataKuliah(String kodeMK, String namaMK, int sks) {
      this.kodeMK = kodeMK;
      this.namaMK = namaMK; //parameter
      this.sks = sks;
  } //membedakan variabel class dgn parameter  
  void tampilMatakuliah() {
      System.out.println("Kode MK: " + kodeMK + " | Nama: " + namaMK + " | SKS: " + sks);
  }
}