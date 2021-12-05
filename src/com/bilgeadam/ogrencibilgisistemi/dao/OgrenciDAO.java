package com.bilgeadam.ogrencibilgisistemi.dao;

import com.bilgeadam.ogrencibilgisistemi.dto.Ogrenci;
import com.bilgeadam.ogrencibilgisistemi.vt.VTBaglanti;

import java.sql.*;
import java.sql.SQLException;

public class OgrenciDAO {

    public static boolean ekle(Ogrenci ogr) throws SQLException, ClassNotFoundException {

        Connection conn = VTBaglanti.baglantiGetir();

        //Statement st = conn.createStatement();
        //int sonuc = st.executeUpdate("insert into ogrenci(ad, soyad, kredi) values()");
        String sorgu = "insert into ogrenci(ad, soyad, kredi) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sorgu);

        ps.setString(1, ogr.getAd());
        ps.setString(2, ogr.getSoyad());
        ps.setDouble(3, ogr.getKredi());

        int sonuc = ps.executeUpdate();

        VTBaglanti.baglantiKapat(conn);

        if (sonuc > 0) {
            System.out.println("INSERT: " + sonuc + " başarıyla gerçekleşti.");
            return true;
        } else {
            return false;
        }

    }

}
