package finalproject;
import java.util.Scanner;
public class FinalProject {
public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // Deklarasi
        boolean pilihModeEror;
        String[] barang = new String[10];
        int[] harga = new int[10];
        String[] produkLaris = new String [5];
        int[] jumlahLaris = new int[5];
        int[][] Total = new int [10][6];
        String keranjang[][] = new String [10][3];
        String [][]laporanProduk = new String [10][3];
        int laporanHarga[][] = new int [10][6];
        String dicari, produkTerlaris;
        int pilih_mode = 0, pilihKasir = 0,pilihOwner = 0, pilihAdmin = 0, indeks= 0;
        int hapus = 0, Laporan = 0, harga_laris = 0, hargaAkhir = 0, kuantitas= 0, jumlah = 7, tambahKeranjang= 0, cariLagi= 0;;
        int uang = 0, kembalian = 0, dibeli= 0;
        int ulangProgram = 0;
        
        // Assign Daftar Produk
        barang[0] =    "Roti";       harga[0] =  18000;
        barang[1] =    "Susu";       harga[1] =   3000;
        barang[2] =     "Teh";       harga[2] =  22000;
        barang[3] =    "Kopi";       harga[3] =   5000;
        barang[4] =  "Sprite";       harga[4] =   6000;
        barang[5] = "Biskuit";       harga[5] =  12000;
        barang[6] =   "Rokok";       harga[6] =  18000;
        
        while (ulangProgram != 1) { 
          
            pilihModeEror = true;
            
            while (pilihModeEror == true) {
                
                System.out.println("");
                System.out.println("=============================  TOKO RAYHAN  =============================");
                System.out.println("");
                System.out.println("Pilih menu");
                System.out.println("1 = Kasir");
                System.out.println("2 = Admin");
                System.out.println("3 = Owner");
                System.out.print("pilih : ");
                pilih_mode = input.nextInt();
                System.out.println("");
                switch (pilih_mode) {
                    
                
                    case 1:
                        do {
                            System.out.println("");
                            System.out.println("============================= MODE KASIR =============================");
                            System.out.println("");
                            System.out.println("Pilih menu");
                            System.out.println("1. Tampil daftar harga");
                            System.out.println("2. Cari ");
                            System.out.println("3. Keluar");
                            System.out.print("pilih : ");
                            pilihKasir = input.nextInt();
                            System.out.println("");
                            
                            switch (pilihKasir) {
                                
                         
                                case 1 :
                                    System.out.println("");
                                    System.out.println("DAFTAR HARGA PRODUK");
                                    System.out.println("No.\tproduk\t harga");
                                    for (int i = 0; i < jumlah; i++) {
                                        System.out.println((i+1) + "." + "\t" + barang[i] + "\t" + harga[i]);
                                    }
                                
                                    
                                    System.out.println("");
                                    do {
                                        System.out.println("Ingin membuat / menambah order?");
                                        System.out.println("1. Ya");
                                        System.out.println("2. Tidak");
                                        System.out.print("Input : ");
                                        tambahKeranjang = input.nextInt();
                                        
                                        if (tambahKeranjang == 1) {
                                            System.out.print("Produk diorder : ");
                                            dibeli = input.nextInt();
                                            System.out.print("berapa : ");
                                            kuantitas = input.nextInt();
                                            keranjang[indeks][0] = barang[dibeli - 1];
                                            Total[indeks][0] = harga[dibeli - 1];
                                            Total[indeks][2] = kuantitas;
                                            Total[indeks][4] = Total[indeks][0] * Total[indeks][2];
                       
                                            indeks++;
                                        }
                                    } while(tambahKeranjang != 2);
                                    
                                    System.out.println("");
                                    
                                    System.out.println("BAYAR");
                                    System.out.println("No.\tNama Produk\tHarga\tKuantitas\tTotal");
                                    for (int i = 0; i < 10; i++) {
                                        if (keranjang[i][0] != null) {
                                            System.out.println((i + 1) + ".\t" + keranjang[i][0] + "\t" + Total[i][0] + "\t" + Total[i][2] + "\t" + Total[i][4]);
                                            hargaAkhir = hargaAkhir + Total[i][4];
                                        }
                                    }
                                    System.out.println("Total Harga : " + hargaAkhir);
                                    System.out.print("Terbayar :  ");
                                    uang = input.nextInt();
                                    kembalian = uang - hargaAkhir;
                                    System.out.println("Kembalian : " + kembalian);
          
                                    break;
                        
                                case 2 : 
                                    System.out.println("------------------------ CARI PRODUK ------------------------");
                                    while (cariLagi != 2){
                                        System.out.print("cari produk : ");
                                        dicari = input.next();
                                        mCari(barang, harga, dicari);
                                        System.out.print("Konfirmasi pesan (ketik angka) : ");
                                        dibeli = input.nextInt();
                                        System.out.print("berapa : ");
                                        kuantitas = input.nextInt();
                                        keranjang[indeks][0] = barang[dibeli - 1];
                                        Total[indeks][0] = harga[dibeli - 1];
                                        Total[indeks][2] = kuantitas;
                                        Total[indeks][4] = Total[indeks][0] * Total[indeks][2];
                                        indeks++;
                                        
                                        System.out.println("");
                                        System.out.println("cari lagi?");
                                        System.out.println("1. Ya");
                                        System.out.println("2. Tidak");
                                        System.out.print("pilih : ");
                                        cariLagi = input.nextInt();
                                        System.out.println(""); 
                                    }
                                   
                                    System.out.println("STRUK PEMBELIAN");
                                    System.out.println("No.\tNamaProduk\tHarga\tKuantitas\tTotal");
                                    for (int i = 0; i < 10; i++) {
                                        if (keranjang[i][0] != null) {
                                            System.out.println((i + 1) + ".\t" + keranjang[i][0] + "\t" + Total[i][0] + "\t" + Total[i][2] + "\tRp " + Total[i][4]);
                                            hargaAkhir = hargaAkhir + Total[i][4];
                                        }
                                    }
                                    System.out.println("Total Harga :" + hargaAkhir);
                                    System.out.print("Terbayar : "             );
                                    uang = input.nextInt();
                                    kembalian = uang - hargaAkhir;
                                    System.out.println("Kembalian : " + kembalian);
                               
                                    break;
                            }
                        } while (pilihKasir != 3);
                        pilihModeEror = false;
                        break;
                        
                 
                    case 2:
                        do {
                            System.out.println("");
                            System.out.println("============================= MODE ADMIN =============================");
                            System.out.println("");
                            System.out.println("Pilih menu");
                            System.out.println("1. Tampilkan daftar harga");
                            System.out.println("2. Tambah produk");
                            System.out.println("3. Hapus produk");
                            System.out.println("4. Keluar");
                            System.out.print("pilih : ");
                            pilihAdmin = input.nextInt();
                            System.out.println("");
                            switch (pilihAdmin) {
                                
                              
                                case 1 :
                                    System.out.println("");
                                    System.out.println("-------------------- DAFTAR HARGA PRODUK --------------------");
                                    System.out.println("No.\tproduk     \t harga");
                                    for (int i = 0; i < jumlah; i++) {
                                        System.out.println((i+1) + "." + "\t" + barang[i] + "\t Rp " + harga[i]);
                                    }
                                    System.out.println("-------------------------------------------------------------");
                                    System.out.println("");
                                    break;
                          
                                case 2 :
                                    System.out.println("------------------------ TAMBAH PRODUK ------------------------");
                                    System.out.print("Nama Produk : ");
                                    barang[jumlah] = input.next();
                                    System.out.print("Harga Produk : ");
                                    harga[jumlah] = input.nextInt();
                                    System.out.println("");
                                    System.out.println("Produk telah ditambahkan");
                                    jumlah++;
                                    break;
                                    
                      
                                case 3 :
                                    System.out.println("------------------------ HAPUS PRODUK ------------------------");
                                    System.out.print("Cari Produk : ");
                                    dicari = input.next();
                                    mCari(barang, harga, dicari);
                                    System.out.print("Konfirmasi hapus (ketik angka) : ");
                                    hapus = input.nextInt();
                                    for (int i = hapus - 1; i < jumlah - 1; i++) {
                                        barang[i] = barang[i + 1];
                                        harga[i] = harga[i + 1];
                                    }
                                    jumlah--;
                                    System.out.println("Produk telah dihapus");
                                    System.out.println("");
                                    break;
                            }
                        } while (pilihAdmin != 4);
                        pilihModeEror = false;
                        break;
                        
             
                    case 3:
                        do {
                            System.out.println("");
                            System.out.println("============================= MODE OWNER =============================");
                            System.out.println("");
                            System.out.println("Pilih menu");
                            System.out.println("1. Tampilkan laporan harga");
                            System.out.println("2. Tampilkan produk terlaris");
                            System.out.println("3. Keluar mode owner");
                            System.out.print("pilih : ");
                            pilihOwner = input.nextInt();
                            System.out.println("");

                            switch (pilihOwner) {
                                case 1:
                                    if (indeks == 0) {
                                        System.out.println("Belum ada barang yang terjual.");
                                    } else {
                                        laporanProduk[Laporan][0] = barang[dibeli - 1];
                                        laporanHarga[Laporan][0] = kuantitas;
                                        laporanHarga[Laporan][1] = hargaAkhir;
                                        System.out.println("");

                                        System.out.println("LAPORAN PENJUALAN HARIAN");

                                        System.out.println("No.\tNama Produk\tHarga\tKuantitas\tTotal");
                                        for (int i = 0; i < 10; i++) {
                                            if (keranjang[i][0] != null) {
                                                System.out.println((i + 1) + ".\t" + keranjang[i][0] + "\t" + Total[i][0] + "\t" + Total[i][2] + "\t" + Total[i][4]);
                                            }
                                        }

                                        System.out.println("Total Harga : " + hargaAkhir);
                                        System.out.println("");
                                    }
                                    break;

                                case 2:
                                    System.out.println("");
                                    System.out.println("DAFTAR PRODUK TERLARIS");
                                    System.out.println("No.\tNama Produk\tTerjual");
                                    produkLaris = barang;
                                    for (int i = 0; i < 5; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            if (Total[2][j] < Total[2][j + 1]) {
                                                harga_laris = Total[2][j];
                                                Total[2][j] = Total[2][j + 1];
                                                Total[2][j + 1] = harga_laris;
                                                produkTerlaris = produkLaris[j];
                                                produkLaris[j] = produkLaris[j + 1];
                                                produkLaris[j + 1] = produkTerlaris;
                                            }
                                        }
                                    }
                                    for (int i = 0; i < 5; i++) {
                                        System.out.println((i + 1) + ".\t" + produkLaris[i] + "\t" + Total[i][2]);
                                    }
                                    break;

                                case 3:
                                    System.out.println("Keluar mode owner");
                                    break;

                                default:
                                    System.out.println("Pilihan error, masukkan angka yang tepat!");
                                    break;
                            }
                        } while (pilihOwner != 3);
                        pilihModeEror = false;
                        break;
                                    }
                System.out.println("Keluar dari TOKO RAYHAN?");
                System.out.println("1 = ya");
                System.out.println("2 = Kembali");
                System.out.print("piliht : ");
                ulangProgram = input.nextInt();
            }
        }
    }
    
    static int mCari (String produk[], int harga[], String dicari) {
        String[] cariProduk = new String[7];
        int[] cariHarga = new int[7];
        String statusAda = null;
        int indeks = 0;
        int iDicari = 0;
        for (int i = 0; i < produk.length ; i++) {
            if (produk[i] != null && produk[i].indexOf(dicari) == 0) {
                cariProduk[indeks] = produk[i];
                cariHarga[indeks] = harga[i];
                indeks++;
                System.out.println("");
                System.out.println("No.\tproduk\t harga");
                System.out.println((i + 1) + "." + "\t" + produk[i] + "\t Rp " + harga[i]);
                statusAda = "ya";
                System.out.println("");
            }
        }
        if (statusAda != "ya") {
            System.out.println("Status : Produk tidak terdaftar");
        }
        for (int i = 0; i < produk.length; i++) {
            if (dicari == produk[i]) {
                iDicari = i;
            }
        }
        return iDicari;
    }
}
