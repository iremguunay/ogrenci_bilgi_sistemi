package com.bilgeadam.ogrencibilgisistemi.test;

import com.bilgeadam.ogrencibilgisistemi.dao.OgrenciDAO;
import com.bilgeadam.ogrencibilgisistemi.dto.Ogrenci;

import java.sql.SQLException;

public class OgrenciDAOTest {
    public static void main(String[] args) {

        Ogrenci ogr = new Ogrenci();
        ogr.setAd("Melike");
        ogr.setSoyad("Şahin");
        ogr.setKredi(1500.00);

        try {
            boolean sonuc = OgrenciDAO.ekle(ogr);

            if (sonuc)
                System.out.println("Başarıyla eklendi");
            else
                System.out.println("Ekleme başarısız oldu!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
