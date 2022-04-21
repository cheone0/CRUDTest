package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.BoardDTO;

public class MemberDAO {
   
   private DataSource dataFactory;
   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;
   
   public MemberDAO() {
      
      try {
         Context ctx = new InitialContext();
         dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/bbs");
         conn = dataFactory.getConnection();
      } catch (NamingException | SQLException e) {
         e.printStackTrace();
      }
      
   }
   
   public void dbClose() {
      if(rs != null) {
         try {
            rs.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      
      if(pstmt != null) {
         try {
            pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      
      if(conn != null) {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   
   

   

}
