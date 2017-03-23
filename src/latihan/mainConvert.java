package tugas;
import java.util.Scanner;
public class mainConvert {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        Scanner on = new Scanner (System.in);
        
        int pilihan;
        do{
             System.out.println("Menu :"
                + "\n1. Konversi angka ke String"
                + "\n2. Konversi string ke angka"
                + "\n3. Exit");
             System.out.print("Masukan Pilihan : ");
             pilihan = in.nextInt();
            switch(pilihan){
                case 1 : 
                    convert pa = new convert ();
                    System.out.print("Masukan angka(1-1000) : ");
                    int x = in.nextInt();
                    pa.setAngka(x);
                    break;
                case 2:
                    convert ph = new convert ();
                    System.out.print("Masukan huruf : ");
                    String q = on.nextLine();
                    ph.setKata(q);
                    break;
                case 3 :
                    System.out.println("Anda keluar dari program");
                    break;
                    
                default : System.out.println("Tidak Ditemukan!!!"); 
            }
        }while(pilihan!=3);
    }
}

class convert {
    private long angka;
    private int awal;
    private int tengah;
    private int akhir;
    private String sebut;
    private int cek = 0;

    String satuan[] = {"satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh"};

    public convert() {
    }
    public void setAngka(int a) {
        if (a <= 10) {
            System.out.println(satuan[a - 1]);
        } else if (a == 11) {
            System.out.println("sebelas");
        } else if (a == 100) {
            System.out.println("seratus");
        } else if (a == 1000) {
            System.out.println("seribu");
        } else if (a > 11 && a < 20) {
            int b = a % 10;
            System.out.println(satuan[b - 1] + " belas");
        } else if (a >= 20 && a < 100) {
            int c = a / 10;
            int d = a % 10;
            if (a % 10 == 0) {
                System.out.println(satuan[c - 1] + " puluh");
            } else {
                System.out.println(satuan[c - 1] + " puluh " + satuan[d - 1]);
            }
        } else if (a > 100 && a <= 110) {
            int e = a % 100;
            System.out.println("seratus " + satuan[e - 1]);
        } else if (a == 111){
            System.out.println("seratus sebelas");
        } else if (a > 111 && a < 120){
            int f = a % 110;
            System.out.println("seratus " + satuan[f - 1] + " belas");
        } else if (a >= 120 && a < 200){
            int g = a % 100;
            int h = g / 10;
            int i = g % 10;
            if (g % 10 == 0){
                System.out.println("seratus " + satuan[h-1] + " puluh");
            } else {
                System.out.println("seratus " + satuan[h-1] + " puluh " + satuan[i-1]);
            }
        } else if (a >= 200 && a < 1000){
            int j = a / 100;
            int k = a % 100;
            int l = k / 10;
            int m = k % 10;
            if (a % 100 == 0){
                System.out.println(satuan[j-1] + " ratus");
            } else if (k % 10 == 0){
                System.out.println(satuan[j-1] + " ratus " + satuan[l-1] + " puluh");
            } else {
                System.out.println(satuan[j-1] + " ratus " + satuan[l-1] + " puluh " + satuan[m-1]);
            }
        }
    }

    public void setKata(String a) {
        a.toLowerCase();
        
        for (int i = 0; i < satuan.length; i++) {
            if ((satuan[i].equals(a))) {
                int satuan = i + 1;
                System.out.println(satuan);
                this.cek = 1;
                break;
            } else if (a.contains(satuan[i]) && a.contains("belas")) {
                int belasan = (i + 1) + 10;
                System.out.println(belasan);
                this.cek = 1;
                break;
            } else if (a.equals("sebelas")) {
                System.out.println("11");
                this.cek = 1;
                break;
            } else if (a.equals("seratus")) {
                System.out.println("100");
                this.cek = 1;
                break;
            } else if (a.equals("seribu")) {
                System.out.println("1000");
                this.cek = 1;
                break;
            }
        }
        if (a.contains("puluh")){
        String split[] = a.split("\\s");
        if (cek == 0) {
            for (int i = 0; i < satuan.length; i++) {
                if (split[0].contains(satuan[i])) {
                    this.awal = (i + 1) * 10;
                    break;
                }
            }
            if (split.length == 3) {
                for (int j = 0; j < satuan.length; j++) {
                    if (split[2].contains(satuan[j])) {
                        this.akhir = j + 1;
                    }
                }
            }
            System.out.println(this.akhir + this.awal);
        }
        } else if (a.contains("ratus")) {
        String split[] = a.split("\\\\s");
        if (cek == 0) {
            for (int i = 0; i < satuan.length; i++) {
                if (split[0].contains(satuan[i])) {
                    this.awal = (i + 1)* 100;
                    break;
                }
            }
            if (split.length == 3) {
                for (int j = 0; j < satuan.length; j++) {
                    if (split[2].contains(satuan[j])) {
                        this.tengah = (j + 1) * 10;
                    }
                }
            }
            if (split.length == 5) {
                for (int k = 0; k < satuan.length; k++) {
                    if (split[4].contains(satuan[k])) {
                        this.tengah = k + 1;
                    }
                }
            }
            System.out.println(this.akhir + this.tengah + this.awal);
        }
        }
    }
}