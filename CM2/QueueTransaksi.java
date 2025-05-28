package CM2;

public class QueueTransaksi {
  TransaksiLayanan[] data;
  int front, rear, size;

  public QueueTransaksi(int kapasitas) {
    data = new TransaksiLayanan[kapasitas];
    front = rear = -1;
    size = 0;
  }

  public boolean isFull() {
    return size == data.length;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void enqueue(TransaksiLayanan t) {
    if (isFull()) {
      System.out.println("Riwayat transaksi penuh!");
      return;
    }
    rear = (rear + 1) % data.length;
    data[rear] = t;
    if (front == -1) front = 0;
    size++;
  }

  public void tampilRiwayat() {
    if (isEmpty()) {
      System.out.println("Belum ada transaksi.");
      return;
    }
    int i = front;
    for (int j = 0; j < size; j++) {
      data[i].tampilkanTransaksi();
      i = (i + 1) % data.length;
      }
  }
}
