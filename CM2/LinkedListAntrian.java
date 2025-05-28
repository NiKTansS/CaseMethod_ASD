package CM2;

public class LinkedListAntrian {
  Node head, tail;

   public void tambahPasien(Pasien p) {
    Node baru = new Node(p);
    if (head == null) {
      head = tail = baru;
    } else {
      tail.next = baru;
      tail = baru;
    }
  }

  public Pasien layaniPasien() {
    if (head == null) return null;
    Pasien p = head.data;
    head = head.next;
    if (head == null) tail = null;
    return p;
  }

  public void tampilAntrian() {
    System.out.println("Antrian Pasien: ");
    Node bantu = head;
    while (bantu != null) {
      System.out.println("Nama pasien: " + bantu.data.nama);
      System.out.println("NIK: " + bantu.data.nik);
      System.out.println("Keluhan: " + bantu.data.keluhan);
      bantu = bantu.next;
    }
  }

  public int sisaAntrian() {
    int count = 0;
    Node bantu = head;
    while (bantu != null) {
        count++;
        bantu = bantu.next;
    }
    return count;
  }
  
  public boolean isEmpty() {
    return head == null;
  }
}
