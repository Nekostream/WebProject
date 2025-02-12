/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.UserDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr.Debug
 */
public class UserDAO implements I_DAO<UserDTO,String>{

    @Override
    public boolean create(UserDTO entity) {
        String sql ="INSERT [dbo].[tblUsers] ([userID], [fullName], [roleID], [password])"
                + "VALUES(N'" + entity.getUserID() + "', N'" + entity.getFullName() + "', N'" + entity.getRoleId() + "', N'" + entity.getPassword() + "')";
        try{
            Connection con = DBUtils.getConnection();
            Statement st = con.createStatement();
           int n = st.executeUpdate(sql);
           
           return n>0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<UserDTO> readAll() {
        List<UserDTO> list =new ArrayList<UserDTO>();
        String sql ="Select * From tblUser";
        try{
            Connection con = DBUtils.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                UserDTO user = new UserDTO(
                rs.getString("userID"),rs.getString("fullName"),
                rs.getString("roleID"),rs.getString("password"));
                
               list.add(user);
            }
        }catch (ClassNotFoundException | SQLException ex){
             Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public UserDTO readbyID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UserDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
