package Details_of_Patients;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author QmArA
 */
public class PatientDetails extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String query = "SELECT Name, Address, Disease, Age, Blood_Group FROM HOSPITAL_ADMISSION";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<patients> patients = new ArrayList<>();
            
            while (rs.next()) {
                patients pt = new patients();
                pt.setName(rs.getString("name"));
                pt.setAge(rs.getInt("age"));
                pt.setDisease(rs.getString("disease"));
                pt.setAddress(rs.getString("address"));
                pt.setBlood_group(rs.getString("blood_group"));
                patients.add(pt);
            }
            System.out.println("Data Result ");
            st.close();
            request.setAttribute("patients", patients);
            RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            StringBuffer jb = new StringBuffer();
            String line = null;
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            String[] data = jb.toString().split("[&]");
            JSONObject obj = new JSONObject();
            for(String dat:data) {
                System.out.println(dat);
                obj.put(dat.split("[=]")[0], dat.split("[=]")[1]);
            }
            
            
            System.out.println(obj);
            String query = "INSERT INTO HOSPITAL_ADMISSION(Name, Address, Disease, Age, Blood_Group)" +
                "VALUES(?, ?, ?, ?, ?) ";
            PreparedStatement preparedStmt = getConnection().prepareStatement(query);
            preparedStmt.setString (1, obj.getString("name"));
            preparedStmt.setString (2, obj.getString("address"));
            preparedStmt.setString (3, obj.getString("disease"));
            preparedStmt.setInt    (4, Integer.parseInt(obj.getString("age")));
            preparedStmt.setString (5, obj.getString("bloodgroup"));
            
            // execute the preparedstatement
            int result = preparedStmt.executeUpdate();
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();  
            if(result > 0) {
                System.out.println("Inserted Successfully");
                out.print("<center>Data Inserted Successfully</center>");
            } else {
                out.print("Sorry Data is incorrect!");
            }
            RequestDispatcher rd=request.getRequestDispatcher("/NewPatient.jsp");
            rd.include(request, response);  
            getConnection().close();
        }catch(Exception ex) { ex.printStackTrace(); }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        ServletContext context = getServletContext();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(context.getInitParameter("mysqldb"),"root","root@123");
        return con;  
    }
}
