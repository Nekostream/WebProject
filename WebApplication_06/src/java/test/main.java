/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.UserDAO;
import DTO.UserDTO;

/**
 *
 * @author SideQuest
 */
public class main {

    public static void main(String []args){
        UserDTO u1 = new UserDTO("TLN01", "test_User", "AD", "khong_co_pass");
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.create(u1));
        
        for (int i = 0; i < 10; i++) {
             UserDTO ui = new UserDTO("USER"+i, "Nguyen Van "+i, "US", i+"testpassword");
             userDAO.create(ui);
        }
    }
        
    }
    

