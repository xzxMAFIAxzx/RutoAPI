package org.example;

import bean.User;
import dao.inter.UserDaoInter;
public class Main {
    public static void main(String[] args)throws Exception {
        UserDaoInter userDao= Context.instanceUserDao();
//        List<User>list = userDao.getAll();
//        userDao.removeUser(2);
//        List<User>list2 = userDao.getAll();
//        System.out.println("list="+list);
//        System.out.println("list2="+list2);

        User u = userDao.getById(5);
        u.setId(2);
        userDao.updateUser(u);
    }
}