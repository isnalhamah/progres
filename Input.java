/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.Blob;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Input {
    
    Connection con = Connect.getConnection();
    String nomor, nama, artist, tahun, status, text, img;
    
    public Input(JTextField nomor, JTextField nama, JTextField artist, JTextField tahun, String img, String status, JTextArea text){
        this.nomor = nomor.getText();
        this.nama = nama.getText();
        this.artist = artist.getText();
        this.tahun = tahun.getText();
        this.status = status;
        this.text = text.getText();
        this.img = img;
    }
        
     public void input(){
         String input = "INSERT INTO `art`(`no`, `nama`, `artist`, `tahun`, `gambar`, `jenis`, `deskripsi`) VALUES (?, ?, ?, ?, ?, ?, ?)";
         try(PreparedStatement stmt = con.prepareStatement(input)){
            stmt.setString(1, nomor);
            stmt.setString(2, nama);
            stmt.setString(3, artist);
            stmt.setString(4, tahun);
            stmt.setString(5, img);
            stmt.setString(6, status);
            stmt.setString(7, text);
             

             
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
         }catch(Exception e){
             System.out.println("Error during image insertion: " + e.getMessage());
         }
     }  
}
