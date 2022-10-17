package dao;

import bll.UserAccount;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class UserLoginDaoImpl implements UserLoginDao {
    private ArrayList<String> dataList;
    //check the authenticated or not value from the form reading values from text file
    @Override
    public boolean checkUser(UserAccount ul) throws IOException {
        boolean found = false;
        try {
            FileReader fr = new FileReader("UserLoginDetails.txt");
            BufferedReader br = new BufferedReader(fr);
     
            String line = null;
            String[] splt = null;
            while ((line = br.readLine()) != null) {
                splt = line.split(",");
                //as we store username and password in 2nd and 3rd index while adding user;check those
                if (splt[2].equals(ul.getUsername()) && splt[3].equals(ul.getPassword())) {
                    ul.setRole(splt[4]);
                    found = true;
                    break;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return found;
    }
    
    @Override
    public void updateUser(UserAccount ul) throws IOException {

        try{
            DatabaseDao dd = new DatabaseDaoImpl();
            
            try{
                dataList = dd.getDataFromFile("UserLoginDetails.txt");

            }
            catch(Exception e){
                System.out.println(e);
            }
            ArrayList<String> list = dataList;
            for (int i = 0; i < dataList.size(); i++) {

                String[] storedData;
                
              
                storedData = list.get(i).split(",");   
                
                //update isLoggedin of ul to 1 
                if (storedData[2].equals(ul.getUsername()) && storedData[3].equals(ul.getPassword())) {
                    
                    storedData[5] = "1";
                    list.set(i, storedData[0] + "," + storedData[1] + "," + storedData[2] + "," + storedData[3] + "," + storedData[4] + "," + storedData[5]);
                }   
                else{
                    storedData[5] = "0";
                    list.set(i, storedData[0] + "," + storedData[1] + "," + storedData[2] + "," + storedData[3] + "," + storedData[4] + "," + storedData[5]);
                    
                }
                
                
            }
            dd.writeToFile( "UserLoginDetails.txt", list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
