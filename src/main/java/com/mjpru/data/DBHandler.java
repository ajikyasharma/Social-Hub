package com.mjpru.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mjpru.beans.Chat;
import com.mjpru.beans.Friend;
import com.mjpru.beans.User;
import com.mjpru.beans.Wpost;

public class DBHandler {
    
	String message="";
	public String getMessage() {
		return message;
	}
	public void save(User user)
	{
		message="";
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="insert into users values(?,?,?);";
	    	  PreparedStatement st= cn.prepareStatement(query);
	    	  st.setString(1, user.getEmail());
	    	  st.setString(2, user.getPassword());
	    	  st.setString(3, user.getName());
	    	  st.executeUpdate();
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
	}
	
	public void save(Friend friend)
	{
		message="";
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="insert into friends(sender, rec, status, dor) values(?,?,?,?);";
	    	  PreparedStatement st= cn.prepareStatement(query);
	    	  st.setString(1, friend.getSender());
	    	  st.setString(2, friend.getRec());
	    	  st.setInt(3, friend.getStatus());
	    	  st.setString(4, friend.getDor());
	    	  st.executeUpdate();
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
	}
	
	
	
	public ArrayList<Wpost> getPosts(String email){
		
		ArrayList<String> friends= getFriends(email);
		friends.add(email.toUpperCase());
		ArrayList<Wpost> wposts= new ArrayList<>();
        message="";
		

		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="select * from wpost order by wid desc";
	    	  PreparedStatement st= cn.prepareStatement(query);
	
              ResultSet result= st.executeQuery();
              while(result.next()) {
                 int wid= result.getInt(1);
                 String message= result.getString(2);
                 String sender= result.getString(3);
                 String dop= result.getString(4);
                 if(friends.contains(sender.toUpperCase())) 
                 {
                	 Wpost wpost= new Wpost(wid, message, sender, dop);
                	 wposts.add(wpost);
                 }        
              }
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
		
		
		
		return wposts;
	}
	public void save(Wpost wpost)
	{
		message="";
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="insert into wpost(message, sender, dop) values(?,?,?);";
	    	  PreparedStatement st= cn.prepareStatement(query);
	    	  st.setString(1, wpost.getMessage());
	    	  st.setString(2, wpost.getSender());
	    	  st.setString(3, wpost.getDop());
	    	  st.executeUpdate();
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
	}
	
	public User getUser(String email)
	{
		User user= null;
		message="";
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="select * from users where email=?";
	    	  PreparedStatement st= cn.prepareStatement(query);
	    	  st.setString(1, email);
              ResultSet result= st.executeQuery();
              if(result.next())
              user= new User(result.getString(1), result.getString(2), result.getString(3));
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
		
		return user;
	}
	
	
	public ArrayList<Friend> getPendingRequests(String email){
		
               

		message="";
		
		ArrayList<Friend> friends = new ArrayList<>();
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="select * from friends where rec=? and status =0 order by fid desc";
	    	  PreparedStatement st= cn.prepareStatement(query);
	    	  st.setString(1,email);
              ResultSet result= st.executeQuery();
              while(result.next()) {
                 int fid= result.getInt(1);
                 String sender= result.getString(2);
                 String rec= result.getString(3);
                 int status= result.getInt(4);
                 String dor= result.getString(5);
                 
                 Friend friend= new Friend(fid, status, sender,rec, dor);
                 friends.add(friend);
                 
                              
              }
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
		
		return friends;
		
	}
	
	public ArrayList<String> getFriends(String email){
		
        

		message="";
		
		ArrayList<String> friends = new ArrayList<>();
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="select * from friends where (rec=? or sender=?) and status =1 order by fid desc";
	    	  PreparedStatement st= cn.prepareStatement(query);
	    	  st.setString(1,email);
	    	  st.setString(2,email);
              ResultSet result= st.executeQuery();
              while(result.next()) {
                 int fid= result.getInt(1);
                 String sender= result.getString(2);
                 String rec= result.getString(3);
                 int status= result.getInt(4);
                 String dor= result.getString(5);
                 
                 if(sender.toUpperCase().equals(email.toUpperCase())) {
                	 friends.add(rec.toUpperCase());
                 }
                 else
                 {
                	 friends.add(sender.toUpperCase());
                 }
                 
                              
              }
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
		
		return friends;
		
	}
	public void update(User user)
	{
		message="";
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="update users set password =?, name=? where email=?;";
	    	  PreparedStatement st= cn.prepareStatement(query);
                System.out.println("Kya haal chaal");
	    	  st.setString(1, user.getPassword());
	    	  st.setString(2, user.getName());
	    	  st.setString(3, user.getEmail());
	    	  st.executeUpdate();
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
	}
	
	public void acceptRequest(int fid)
	{
		message="";
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="update friends set status=1 where fid=?;";
	    	  PreparedStatement st= cn.prepareStatement(query);
	    	  st.setInt(1, fid);
	    	  st.executeUpdate();
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
	}
	
	public void rejectRequest(int fid)
	{
		message="";
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="update friends set status=2 where fid=?;";
	    	  PreparedStatement st= cn.prepareStatement(query);
	    	  st.setInt(1, fid);
	    	  st.executeUpdate();
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
	}
	
	
	public ArrayList<Chat> getMessages(String sender1, String reciver1){
		
//		ArrayList<String> friends= getFriends(email);
//		friends.add(email.toUpperCase());
		ArrayList<Chat> chats= new ArrayList<>();
        message="";
		

		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="select * from chat where (sender=? and reciver=?) or (sender=? and reciver=?)";
	    	  PreparedStatement st= cn.prepareStatement(query);
	           st.setString(1, sender1);
	           st.setString(2, reciver1);
	           st.setString(3, reciver1);
	           st.setString(4, sender1);
              ResultSet result= st.executeQuery();
              while(result.next()) {
                  String sender= result.getString(1);
                  String reciver= result.getString(2);
                  String message= result.getString(3);
                  String dop= result.getString(4);
                  

                	 Chat chat= new Chat(sender, reciver, message, dop);
                	 chats.add(chat);       
              }
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
		
		
		
		return chats;
	}
	
	public void save(Chat chat)
	{
		message="";
		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/Social_Hub?user=root & password=kitkat");
	    	  String query ="insert into chat values(?,?,?,?);";
	    	  PreparedStatement st= cn.prepareStatement(query);
	    	  st.setString(1, chat.getSender());
	    	  st.setString(2, chat.getReciver());
	    	  st.setString(3, chat.getMessage());
	    	  st.setString(4, chat.getDom());
	    	  st.executeUpdate();
	    	  cn.close();

	    	  
	    	  
	      }
	      catch(Exception ex)
	      {
	    	 message= ex.getMessage();
	    	 System.out.println(message);
	      }
	}
	
	
}

