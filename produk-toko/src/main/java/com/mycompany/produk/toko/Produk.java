/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produk.toko;

import java.text.DecimalFormat;

/**
 *
 * @author Caca Core
 */

// Kelas Produk sebegai Superclass
// Menerapkan Encapsulation dan Constructor berparameter
public class Produk {
    // Encapsulation Atribut private minimal 3 atribut
    private String kodeProduk;  
    private String nama;
    private double harga;
    private int stok; // Atribut tambahan

    // Constructor berparameter
    public Produk(String kodeProduk, String nama, double harga, int stok) {
        // Class dan Object
        this.kodeProduk = kodeProduk;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // --- Getter dan Setter (Enkapsulasi) ---
    public String getKodeProduk() {
        return kodeProduk;
    }
    
    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
     
    public double getHarga() {
        return harga;
    }
    
    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println("Stok tidak boleh negatif.");
        }
    }

    // Method Tambahan (Minimal 2)
    // Method untuk menampilkan informasi dasar produk
    public void tampilkanInfo() {
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        System.out.println("  Kode: " + kodeProduk);
        System.out.println("  Nama: " + nama);
        System.out.println("  Harga: Rp" + formatter.format(harga));
        System.out.println("  Stok: " + stok);
    }

    // Method untuk mengecek status ketersediaan stok
    public boolean cekKetersediaan() {
        return this.stok > 0;
    }
}