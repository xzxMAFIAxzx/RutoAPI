package org.example;

import bean.User;
import dao.inter.UserDaoInter;
public class Main {
    public static void main(String[] args)throws Exception {
        UserDaoInter userDao= Context.instanceUserDao();
        System.out.println(userDao.getAll());
    }
}