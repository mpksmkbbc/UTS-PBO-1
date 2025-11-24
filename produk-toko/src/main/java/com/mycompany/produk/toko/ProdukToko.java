/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.produk.toko;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Caca Core
 */

// Menerapkan menu berbasis teks, Class & Object, dan Polymorphism
public class ProdukToko {
    
    // Koleksi objek Produk dan Transaksi
    private static List<Produk> katalogProduk = new ArrayList<>();
    private static List<Transaksi> daftarTransaksi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int counterTrx = 1;

    public static void main(String[] args) {
        // Data Awal
        katalogProduk.add(new ProdukElektronik("EL001", "Smartphone X", 8000000, 15, "Samsung", 12, "10W"));
        katalogProduk.add(new ProdukPakaian("PK001", "T-shirt Premium", 120000, 50, "M", "Katun", "Putih"));
        katalogProduk.add(new ProdukElektronik("EL002", "Headphone ANC", 1500000, 5, "Sony", 6, "1W"));

        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Masukkan pilihan: ");
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
                prosesPilihan(pilihan);
            } catch (NumberFormatException e) {
                System.out.println("\n Masukkan harus berupa angka.");
                pilihan = 0;
            }
        } while (pilihan != 7);
        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\n=============================================");
        System.out.println("    APLIKASI KATALOG PRODUK TOKO    ");
        System.out.println("=============================================");
        System.out.println("1. Tambah Data Produk Baru");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Cari Data Produk (Kode)");
        System.out.println("4. Ubah Data Stok Produk");
        System.out.println("5. Cek Status Data Ketersediaan");
        System.out.println("6. Buat Transaksi Pembelian");
        System.out.println("7. Keluar dari Program");
        System.out.println("---------------------------------------------");
    }

    private static void prosesPilihan(int pilihan) {
        switch (pilihan) {
            case 1: tambahDataProduk(); break;
            case 2: tampilkanDataProduk(); break;
            case 3: cariDataProduk(); break;
            case 4: ubahDataStok(); break;
            case 5: cekStatusData(); break;
            case 6: buatTransaksi(); break;
            case 7: System.out.println("\nProgram selesai. Sampai jumpa!"); break;
            default: System.out.println("\n Pilihan tidak valid.");
        }
    }
    
    // Method untuk mencari produk berdasarkan kode produk
    private static Produk cariProduk(String kode) {
        for (Produk p : katalogProduk) {
            if (p.getKodeProduk().equalsIgnoreCase(kode)) {
                return p;
            }
        }
        return null;
    }

    // Method untuk tambah data produk
    private static void tambahDataProduk() {
        // Implementasi Class & Object
        System.out.println("\n--- Tambah Produk Baru ---");
        System.out.print("Tipe (1: Elektronik, 2: Pakaian): ");
        String tipe = scanner.nextLine();
        
        System.out.print("Kode Produk: "); 
        String kode = scanner.nextLine();
        
        // Validasi inpur data
        if (cariProduk(kode) != null) { 
            System.out.println("Kode sudah ada."); 
            return; 
        }

        System.out.print("Nama: "); 
        String nama = scanner.nextLine();
        System.out.print("Harga (Rp): "); 
        double harga = Double.parseDouble(scanner.nextLine());
        System.out.print("Stok: "); 
        int stok = Integer.parseInt(scanner.nextLine());

        if (tipe.equals("1")) {
            System.out.print("Merek: "); 
            String merek = scanner.nextLine();
            System.out.print("Garansi (bulan): "); 
            int garansi = Integer.parseInt(scanner.nextLine());
            System.out.print("Daya (Watt): "); 
            String daya = scanner.nextLine();
            katalogProduk.add(new ProdukElektronik(kode, nama, harga, stok, merek, garansi, daya));
        } else if (tipe.equals("2")) {
            System.out.print("Ukuran: "); 
            String ukuran = scanner.nextLine();
            System.out.print("Jenis Bahan: "); 
            String bahan = scanner.nextLine();
            System.out.print("Warna: "); 
            String warna = scanner.nextLine();
            katalogProduk.add(new ProdukPakaian(kode, nama, harga, stok, ukuran, bahan, warna));
        } else {
            System.out.println("Tipe produk tidak valid."); return;
        }

        System.out.println("\n Produk baru berhasil ditambahkan!");
    }

    // Method untuk menampilkan data produk berdasarkan tipe objek
    private static void tampilkanDataProduk() {
        if (katalogProduk.isEmpty()) { 
            System.out.println("\n Katalog produk kosong."); 
            return; 
        }
        
        System.out.println("\n--- Daftar Semua Produk ---");
        for (Produk p : katalogProduk) {
            p.tampilkanInfo(); 
            System.out.println("---------------------------------");
        }
    }
    
    // Method untuk mencari data produk
    private static void cariDataProduk() {
        // Implementasi Atribut dan Method
        System.out.print("\nMasukkan Kode Produk yang dicari: ");
        String kode = scanner.nextLine();
        Produk produkDitemukan = cariProduk(kode);

        if (produkDitemukan != null) {
            System.out.println("\n Produk Ditemukan:");
            produkDitemukan.tampilkanInfo();
            // Penggunaan method spesifik subclass
            if (produkDitemukan instanceof ProdukPakaian) {
                System.out.println("  Saran Perawatan: " + ((ProdukPakaian) produkDitemukan).saranPerawatan());
            }
        } else {
            System.out.println("\nProduk tidak ditemukan.");
        }
    }
    
    // Method untuk ubah data stok
    private static void ubahDataStok() {
        // Implementasi Encapsulation (setter)
        System.out.print("\nMasukkan Kode Produk yang diubah stoknya: ");
        String kode = scanner.nextLine();
        Produk produk = cariProduk(kode);

        if (produk != null) {
            System.out.println("Stok Saat Ini: " + produk.getStok());
            System.out.print("Masukkan jumlah stok baru: ");
            try {
                int stokBaru = Integer.parseInt(scanner.nextLine());
                produk.setStok(stokBaru); // Menggunakan setter untuk menjaga enkapsulasi
                System.out.println("Stok produk " + produk.getNama() + " berhasil diubah.");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input stok tidak valid.");
            }
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }
    
    // Method untuk cek status data produk
    private static void cekStatusData() {
        // Implementasi 2. Method (cekKetersediaan)
        System.out.print("\nMasukkan Kode Produk yang dicek statusnya: ");
        String kode = scanner.nextLine();
        Produk produk = cariProduk(kode);

        if (produk != null) {
            System.out.println("\nProduk: " + produk.getNama() + " (Stok: " + produk.getStok() + ")");
            if (produk.cekKetersediaan()) { // Memanggil method cek ketersediaan
                System.out.println("STATUS: TERSEDIA.");
            } else {
                System.out.println("STATUS: TIDAK TERSEDIA (Stok Habis).");
            }
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    private static void buatTransaksi() {
        // Implementasi Relasi antar Kelas (Composition)
        String idTrx = "TRX" + String.format("%03d", counterTrx++);
        String tanggal = "23/11/2025"; // Tanggal statis

        // 1. Membuat objek Transaksi baru (Composition)
        Transaksi newTrx = new Transaksi(idTrx, tanggal);

        boolean lanjut = true;
        while (lanjut) {
            System.out.print("Masukkan Kode Produk dibeli (atau 'selesai'): ");
            String kodeBeli = scanner.nextLine();

            if (kodeBeli.equalsIgnoreCase("selesai")) {
                lanjut = false;
            } else {
                Produk produkBeli = cariProduk(kodeBeli);
                if (produkBeli != null && produkBeli.cekKetersediaan()) {
                    // Menambahkan produk ke Transaksi (Association)
                    newTrx.tambahProduk(produkBeli);
                    produkBeli.setStok(produkBeli.getStok() - 1); // Kurangi stok
                    System.out.println("Produk ditambahkan! Stok sisa: " + produkBeli.getStok());
                } else if (produkBeli != null) {
                    System.out.println("[ERROR] Stok " + produkBeli.getNama() + " habis.");
                } else {
                    System.out.println("[ERROR] Produk tidak ditemukan.");
                }
            }
        }

        if (newTrx.getIdTransaksi().equals(idTrx)) {
            daftarTransaksi.add(newTrx);
            newTrx.tampilkanDetail();
            System.out.println("Transaksi berhasil dicatat!");
        }
    }
}