package org.example;

import dao.inter.EmploymentHistoryDaoInter;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDaoInter;

public class Main {
    public static void main(String[] args)throws Exception {
        UserDaoInter dao= Context.instanceUserDao();
        System.out.println(dao.getById(1));
    }
}