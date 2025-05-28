
public class Penilaian {
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;
    double nilaiTugas;
    double nilaiUTS;
    double nilaiUAS;
    double nilaiAkhir;

    Penilaian(Mahasiswa mahasiswa, MataKuliah mataKuliah, double tugas, double uts, double uas) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilaiTugas = tugas;
        this.nilaiUTS = uts;
        this.nilaiUAS = uas;
        hitungNilaiAkhir();
    }

    public Penilaian() {
    }
    
    
    void tampilPenilaian() {
        System.out.print(mahasiswa.nama + " | ");
        System.out.print(mataKuliah.namaMK + " | ");
        System.out.println("Nilai Akhir: " + nilaiAkhir);
    }

    void hitungNilaiAkhir() {
        nilaiAkhir = (nilaiTugas * 0.3) + (nilaiUTS * 0.3) + (nilaiUAS * 0.4); //shorting
    }
}