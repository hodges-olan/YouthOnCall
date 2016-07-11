/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Control;

import com.google.gson.Gson;
import Client.App.YouthOnCallClient;
import Client.Model.Members;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author co075oh
 */
public class MembersControl {

    // Define attributes
    String[] columns = {"ID", "Name", "Email", "Address", "City", "State", "Zip", "Phone", "Youth/Member"};
    
    public void createMember(String name, String email, String address, String city, String st, int zip, String phone, boolean youth, String password) throws IOException {
        Members member = new Members();
        member.setName(name);
        member.setEmail(email);
        member.setAddress(address);
        member.setCity(city);
        member.setSt(st);
        member.setZip(zip);
        member.setPhone(phone);
        member.setYouth(youth);
        member.setPassword(this.hashPassword(password));
        
        Gson membersGSON = new Gson();
        try (Socket socket = new Socket(YouthOnCallClient.SERVER,YouthOnCallClient.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("createMember");
            outputStream.println(membersGSON.toJson(member));
        }
    }
    
    public void updateMember(Members member) throws IOException {
        Gson memberGSON = new Gson();
        try (Socket socket = new Socket(YouthOnCallClient.SERVER, YouthOnCallClient.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("updateMember");
            outputStream.println(memberGSON.toJson(member, Members.class));
        }
    }
    
    public Members retrieveMember(int memberID) throws IOException {
        Members member;
        String memberJSON;
        Gson memberGSON = new Gson();
        try (Socket socket = new Socket(YouthOnCallClient.SERVER, YouthOnCallClient.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("retrieveMember");
            outputStream.println(memberID);
            memberJSON = inputStream.nextLine();
            member = memberGSON.fromJson(memberJSON, Members.class);
        }
        return member;
    }
    
    public Object[][] retrieveAllMembers() throws IOException {
        List<Members> allMembers;
        String allMembersJSON;
        Gson allMembersGSON = new Gson();
        try (Socket socket = new Socket(YouthOnCallClient.SERVER,YouthOnCallClient.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("retrieveAllMembers");
            allMembersJSON = inputStream.nextLine();
            allMembers = allMembersGSON.fromJson(allMembersJSON, new TypeToken<List<Members>>(){}.getType());
        }
        
        int i = 0;
        Object[][] members = new Object[allMembers.size()][];
        for (Members member : allMembers) {
            Object[] individualMember = {
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getAddress(),
                member.getCity(),
                member.getSt(),
                member.getZip(),
                member.getPhone(),
                member.isYouth()
            };
            members[i] = individualMember;
            i++;
        }
        return members;
    }
    
    public void retrieveAllYouth() {
        
    }
    
    public String[] retrieveColumns() {
        return columns;
    }

    private String hashPassword(String password) {
        String hashedPassword = "nopassword";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] byteData = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(MembersControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashedPassword;
    }
    
}
