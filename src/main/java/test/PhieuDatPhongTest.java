/*
 * @ (#) PhieuDatPhongTest.java       1.0     4/21/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package test;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 4/21/2024
 */

import dao.Impl.PhieuDatPhongImpl;
import dao.PhieuDatPhongDAO;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PhieuDatPhongTest {
    public static void main(String[] args) {
        PhieuDatPhongDAO phieuDatPhongDAO = new PhieuDatPhongImpl();
        boolean test1 = phieuDatPhongDAO.bookKaraokeRoom("KH.041123.001", "NV230001", "P0101    ", Time.valueOf("00:00:00"), Date.valueOf("2024-04-21"));
        if(test1 == true){
            System.out.println("Test 1 passed");
        }else System.out.println("Test 1 failed");
    }


}
