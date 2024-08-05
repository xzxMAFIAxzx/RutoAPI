package org.example;

import dao.inter.EmploymentHistoryDaoInter;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDaoInter;

public class Main {
    public static void main(String[] args)throws Exception {
        UserSkillDaoInter dao= Context.instanceUserSkillDao();
        System.out.println(dao.getAllSkillByUserId(4));
    }
}