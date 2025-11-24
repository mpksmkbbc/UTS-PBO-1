/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produk.toko;

/**
 *
 * @author Caca Core
 */

// Kelas ProdukElektronik sebagai Subclass dari Superclass Produk 
// Menerapkan Inheritance
public class ProdukElektronik extends Produk { // Inheritance ditandai dengan fungsi extends
    // 3 atribut private spesifik subclass
    private String merek;
    private int garansiBulan;
    private String dayaWatt;

    // Constructor berparameter
    public ProdukElektronik(String kodeProduk, String nama, double harga, int stok, 
                            String merek, int garansiBulan, String dayaWatt) {
        super(kodeProduk, nama, harga, stok); // Memanggil constructor Superclass
        this.merek = merek;
        this.garansiBulan = garansiBulan;
        this.dayaWatt = dayaWatt;
    }

    // --- Getter/Setter Tambahan ---
    public String getMerek() {
        return merek;
    }
    
    public void setMerek(String merek) {
        this.merek = merek;
    }
    
    public int getGaransiBulan() {
        return garansiBulan;
    }
    
    public void setMerek(int garansiBulan) {
        this.garansiBulan = garansiBulan;
    }
    
    public String getDayaWatt() {
        return dayaWatt;
    }

    public void setDayaWatt(String dayaWatt) {
        this.dayaWatt = dayaWatt;
    }
    
    // Override method dari Superclass untuk menambahkan info spesifik Elektronik
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil method Superclass
        System.out.println("  Tipe: Elektronik");
        System.out.println("  Merek: " + merek);
        System.out.println("  Garansi: " + garansiBulan + " bulan");
        System.out.println("  Daya: " + dayaWatt);
    }

    // Method khusus untuk enghitung umur garansi yang tersisa dalam tahun
    public double hitungGaransiTersisa() {
        return (double) garansiBulan / 12;
    }
}