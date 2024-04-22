/*
 * @ (#) TaiKhoanTest.java       1.0     4/22/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package test;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 4/22/2024
 */

import dao.Impl.TaiKhoanImpl;
import dao.TaiKhoanDAO;

public class TaiKhoanTest {
    public static void main(String[] args) {
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanImpl();
//        System.out.println(taiKhoanDAO.getAllTaiKhoan());
           System.out.println(taiKhoanDAO.getTaiKhoan("luongtandat", "Dat123456@"));
    }
}
