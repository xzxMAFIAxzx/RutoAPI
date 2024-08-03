package org.example;

import dao.inter.EmploymentHistoryDaoInter;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDaoInter;

public class Main {
    public static void main(String[] args)throws Exception {
        EmploymentHistoryDaoInter dao= Context.instanceEmploymentHistoryDao();
        System.out.println(dao.getAllEmploymentHistoryByUserId(4));
    }
}