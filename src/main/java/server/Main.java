/*
 * @ (#) Main.java       1.0     4/18/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package server;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 4/18/2024
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("mssql").createEntityManager();
    }
}
