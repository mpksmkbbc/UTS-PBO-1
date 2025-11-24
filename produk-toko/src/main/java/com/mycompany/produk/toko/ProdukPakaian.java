/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produk.toko;

/**
 *
 * @author Caca Core
 */
// Kelas ProdukPakaian sebagai Subclass dari Superclass Produk
// Menerapkan Inheritance
public class ProdukPakaian extends Produk { // Inheritance
    // 3 atribut private spesifik subclass
    private String ukuran;
    private String jenisBahan;
    private String warna;

    // Constructor berparameter
    public ProdukPakaian(String kodeProduk, String nama, double harga, int stok, 
                         String ukuran, String jenisBahan, String warna) {
        super(kodeProduk, nama, harga, stok); // Memanggil constructor Superclass
        this.ukuran = ukuran;
        this.jenisBahan = jenisBahan;
        this.warna = warna;
    }

    // --- Getter/Setter Tambahan ---
    public String getUkuran() {
        return ukuran;
    }
    
    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }
    
    public String getJenisBahan() {
        return jenisBahan;
    }
    
    public void setJenisBahan(String jenisBahan) {
        this.jenisBahan = jenisBahan;
    }
    
    public String getWarna() {
        return warna;
    }
    
    public void setWarna(String warna) {
        this.warna = warna;
    }
    
    // Override method dari Superclass untuk menambahkan info spesifik Pakaian
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  Tipe: Pakaian");
        System.out.println("  Ukuran: " + ukuran);
        System.out.println("  Bahan: " + jenisBahan);
        System.out.println("  Warna: " + warna);
    }

    // Method untuk memberikan saran perawatan berdasarkan jenis bahan
    public String saranPerawatan() {
        if (jenisBahan.toLowerCase().contains("katun")) {
            return "Dapat dicuci mesin.";
        } else if (jenisBahan.toLowerCase().contains("sutra")) {
            return "Cuci kering atau cuci tangan.";
        } else {
            return "Periksa label produk.";
        }
    }
}