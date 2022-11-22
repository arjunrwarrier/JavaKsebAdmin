import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.sql.*;


public class KsebAdmin {
    public static void main(String[] args) {
        int choice, consumerCode;
        String consumerName, consumerPhone, consumerEmail, consumerAddress;

        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Kseb Consumer Management");
            System.out.println("1.Add Consumer ");
            System.out.println("2.Search Consumer ");
            System.out.println("3.Delete Consumer ");
            System.out.println("4.Update Consumer ");
            System.out.println("5.View all Consumers ");
            System.out.println("6.Generate Bill ");
            System.out.println("7.View Bill  ");
            System.out.println("8.Top two high bill paying consumers  ");
            System.out.println("9.Exit ");
            System.out.println("Enter your choice:  ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Add Consumer");
                    System.out.println("Enter the consumer code: ");
                    consumerCode = input.nextInt();
                    System.out.println("Enter Consumer Name: ");
                    consumerName = input.next();
                    System.out.println("Enter Consumer Phone: ");
                    consumerPhone = input.next();
                    System.out.println("Enter Consumer Email Id: ");
                    consumerEmail = input.next();
                    System.out.println("Enter Consumer Address: ");
                    consumerAddress = input.next();


                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql = "INSERT INTO `consumer`(`consumerCode`, `consumerName`, `consumerPhone`, `consumerEmail`, `consumerAddress`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1,consumerCode);
                        stmt.setString(2,consumerName);
                        stmt.setString(3,consumerPhone);
                        stmt.setString(4,consumerEmail);
                        stmt.setString(5,consumerAddress);
                        stmt.executeUpdate();
                        System.out.println("Data inserted successfully.");
                    }
                    catch (Exception e ){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("Search Consumer");
                    System.out.println("Enter the Consumer Code/Name/Phone to search: ");
                    String searchOption = input.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "SELECT `consumerCode`, `consumerName`, `consumerPhone`, `consumerEmail`, `consumerAddress` FROM `consumer` WHERE `consumerCode` ='"+searchOption+"'  OR `consumerName`='"+searchOption+"' OR `consumerPhone` ='"+searchOption+"' ";

                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getConsumerCode = rs.getString("consumerCode");
                            String getConsumerName = rs.getString("consumerName");
                            String getConsumerPhone = rs.getString("consumerPhone");
                            String getConsumerEmail = rs.getString("consumerEmail");
                            String getConsumerAddress = rs.getString("consumerAddress");

                            System.out.println("Consumer Code="+getConsumerCode);
                            System.out.println("Consumer Name="+getConsumerName);
                            System.out.println("Consumer Phone="+getConsumerPhone);
                            System.out.println("Consumer Email="+getConsumerEmail);
                            System.out.println("Consumer Address="+getConsumerAddress);

                        }


                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    break;
                case 3:
                    System.out.println("Delete Consumer");

                    System.out.println("Enter the consumer code to delete: ");
                    consumerCode = input.nextInt();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "DELETE FROM `consumer` WHERE `consumerCode` = "+consumerCode;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Consumer Data deleted successfully.");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }


                    break;
                case 4:
                    System.out.println("Update Consumer");
                    System.out.println("Enter the consumer code: ");
                    consumerCode = input.nextInt();

                    System.out.println("Enter Consumer Name to update: ");
                    consumerName = input.next();
                    System.out.println("Enter Consumer Phone to update: ");
                    consumerPhone = input.next();
                    System.out.println("Enter Consumer Email Id to update: ");
                    consumerEmail = input.next();
                    System.out.println("Enter Consumer Address to update: ");
                    consumerAddress = input.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "UPDATE `consumer` SET `consumerName`='"+consumerName+"',`consumerPhone`='"+consumerPhone+"',`consumerEmail`='"+consumerEmail+"',`consumerAddress`='"+consumerAddress+"' WHERE `consumerCode` = "+consumerCode;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Consumer Data updated successfully.");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }



                    break;
                case 5:
                    System.out.println("View all Consumers");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql = "SELECT `consumerCode`, `consumerName`, `consumerPhone`, `consumerEmail`, `consumerAddress` FROM `consumer` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getConsumerCode = rs.getString("consumerCode");
                            String getConsumerName = rs.getString("consumerName");
                            String getConsumerPhone = rs.getString("consumerPhone");
                            String getConsumerEmail = rs.getString("consumerEmail");
                            String getConsumerAddress = rs.getString("consumerAddress");

                            System.out.println("Consumer Code="+getConsumerCode);
                            System.out.println("Consumer Name="+getConsumerName);
                            System.out.println("Consumer Phone="+getConsumerPhone);
                            System.out.println("Consumer Email="+getConsumerEmail);
                            System.out.println("Consumer Address="+getConsumerAddress+"\n");

                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }


                    break;
                case 6:
                    System.out.println("Generate Bill");
                    //getting current month and year
                    GregorianCalendar date = new GregorianCalendar();
                    int currentMonth = date.get(Calendar.MONTH);
                    int currentYear = date.get(Calendar.YEAR);
                    currentMonth = currentMonth+1;

                    try {
                        //Deleting data
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb", "root", "");
                        String sql = "DELETE FROM `bill` WHERE `month`= '" + currentMonth + "'AND `year`= '" + currentYear + "'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        //getting id
                        String sql1 = "SELECT `id` FROM `consumer` ";
                        Statement stmt1 = con.createStatement();
                        ResultSet rs = stmt1.executeQuery(sql1);
                        while (rs.next()) {
                            int id = rs.getInt("id");
                            //getting sum of unit
                            String sql2 = "select SUM(`unit`) from usages where month(datetime) = '"+currentMonth+"' AND year(datetime) = '"+currentYear+"' AND `consumerid` ='"+id+"'";
                            Statement stmt2 = con.createStatement();
                            ResultSet rs1 = stmt2.executeQuery(sql2);
                            while (rs1.next()) {
                                //finding totalunit
                                int totalUnit = rs1.getInt("SUM(`Unit`)");
                                //int status = 0;
                                int totalBill = totalUnit * 5;
                                //generating random number for invoice
                                int min = 10000;
                                int max = 99999;
                                int invoice = (int)(Math.random() * (max - min + 1) + min);
                                //inserting data
                                String sql3 = "INSERT INTO `bill`(`consumerid`, `month`, `year`, `bill`, `paidstatus`, `billdate`, `totalunit`, `duedate`, `invoice`) VALUES (?,?,?,?,?,now(),?,now()+ interval 14 day,?)";
                                PreparedStatement stmt3 = con.prepareStatement(sql3);
                                stmt3.setInt(1, id);
                                stmt3.setInt(2, currentMonth);
                                stmt3.setInt(3, currentYear);
                                stmt3.setInt(4, totalBill);
                                stmt3.setInt(5, 0);
                                stmt3.setInt(6, totalUnit);
                                stmt3.setInt(7, invoice);
                                stmt3.executeUpdate();
                            }
                        }

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    System.out.println("Bill Generated Successfully.");

                    break;
                case 7:
                    System.out.println("View Bill");

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql = "SELECT  b.`consumerid`, b.`month`, b.`year`, b.`bill`, b.`paidstatus`, b.`billdate`, b.`totalunit`, b.`duedate`, b.`invoice`,c.consumerCode,c.consumerName FROM `bill` b JOIN consumer c ON b.consumerid=c.id";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getConsumerId = rs.getString("consumerid");
                            String getMonth= rs.getString("month");
                            String getYear = rs.getString("year");
                            String getBill = rs.getString("bill");
                            String getPaidStatus = rs.getString("paidstatus");
                            String getbilldate = rs.getString("billdate");
                            String getTotalUnit = rs.getString("totalunit");
                            String getDueDate = rs.getString("duedate");
                            String getInvoice = rs.getString("invoice");
                            String getConsumerCode = rs.getString("consumerCode");
                            String getConsumerName = rs.getString("consumerName");

                            System.out.println("Consumer Id="+getConsumerId);
                            System.out.println("Month="+getMonth);
                            System.out.println("Year="+getYear);
                            System.out.println("Bill ="+getBill);
                            System.out.println("PaidStatus ="+getPaidStatus);
                            System.out.println("Bill Date ="+getbilldate);
                            System.out.println("Total Unit ="+getTotalUnit);
                            System.out.println("Due Date ="+getDueDate);
                            System.out.println("Invoice ="+getInvoice);
                            System.out.println("Consumer Code ="+getConsumerCode);
                            System.out.println("Consumer Name="+getConsumerName+"\n");

                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }



                    break;
                case 8:
                    System.out.println("Top two high bill paying consumers");

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksebdb","root","");
                        String sql = "SELECT c.consumerName,c.consumerAddress,b.`totalunit`, b.`bill` FROM bill b JOIN consumer c ON b.consumerid = c.id GROUP BY `bill` ORDER BY `bill` DESC LIMIT 2";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getConsumerName = rs.getString("consumerName");
                            String getConsumerAddress = rs.getString("consumerAddress");
                            String getTotalUnit= rs.getString("totalunit");
                            String getBill = rs.getString("bill");


                            System.out.println("Consumer Name="+getConsumerName);
                            System.out.println("Consumer Address="+getConsumerAddress);
                            System.out.println("Total Unit="+getTotalUnit);
                            System.out.println("Amount  ="+getBill+"\n");


                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }




                    break;
                case 9:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct choice");


            }
        }
    }
}
