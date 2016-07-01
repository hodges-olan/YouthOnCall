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
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author co075oh
 */
public class MembersControl {

    // Define attributes
    String[] columns = {"ID", "Name", "Email", "Address", "City", "State", "Zip", "Phone", "Youth/Member"};
    
    public void createMember(String name, String email, String address, String city, String st, int zip, String phone, boolean youth) throws IOException {
        Members member = new Members();
        member.setName(name);
        member.setEmail(email);
        member.setAddress(address);
        member.setCity(city);
        member.setSt(st);
        member.setZip(zip);
        member.setPhone(phone);
        member.setYouth(youth);
        
        Gson membersGSON = new Gson();
        try (Socket socket = new Socket(YouthOnCallClient.SERVER,YouthOnCallClient.PORT)) {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintStream outputStream = new PrintStream(socket.getOutputStream());
            outputStream.println("createMember");
            outputStream.println(membersGSON.toJson(member));
        }
    }
    
    public void updateMember() {
        
    }
    
    public void retrieveMember() {
        
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
    
}
