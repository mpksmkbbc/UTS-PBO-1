/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produk.toko;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

/**
 *
 * @author Caca Core
 */

// Kelas Transaksi sebagai Class Relasi
// Menerapkan Composition terhadap Produk
public class Transaksi {
    // Atribut private
    private String idTransaksi;
    private String tanggal;
    // Relasi antar Kelas menggunakan Composition (Transaksi memiliki daftar Produk)
    private List<Produk> daftarProdukDibeli; 
    private double totalHarga; // Atribut tambahan untuk menyimpan total

    // Constructor berparameter
    public Transaksi(String idTransaksi, String tanggal) {
        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        // Composition untuk Daftar produk dibuat dan dikelola oleh Transaksi
        this.daftarProdukDibeli = new ArrayList<>(); 
        this.totalHarga = 0;
    }

    // --- Getter dan Setter ---
    public String getIdTransaksi() {
        return idTransaksi;
    }
    
    public String getTanggal() {
        return tanggal;
    }
    
    public List<Produk> daftarProdukuDibeli() {
        return daftarProdukDibeli;
    }
    
    public double totalHarga() {
        return totalHarga;
    }
    
    // Method untuk menambahkan produk ke dalam transaksi dengan menerapkan Association Transaksi menggunakan objek Produk
    public void tambahProduk(Produk produk) {
        daftarProdukDibeli.add(produk);
        totalHarga += produk.getHarga();
    }

    // Method untuk menampilkan detail transaksi beserta total
    public void tampilkanDetail() {
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        System.out.println("\n--- Detail Transaksi ID: " + idTransaksi + " ---");
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Produk yang Dibeli:");
        if (daftarProdukDibeli.isEmpty()) {
            System.out.println("  (Belum ada produk)");
        }
        for (Produk p : daftarProdukDibeli) {
            System.out.printf("  - %s (%s) @ Rp%s%n", p.getNama(), p.getKodeProduk(), formatter.format(p.getHarga()));
        }
        System.out.println("------------------------------------");
        System.out.printf("TOTAL PEMBELIAN: Rp%s%n", formatter.format(totalHarga));
        System.out.println("------------------------------------");
    }
}