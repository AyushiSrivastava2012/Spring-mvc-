package miscellaneous;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
public class PutdataInDb {

	private static String ToWrite;
	private static String ToRead;

	public static void main(String [] args) throws Exception{
		ToRead="/Users/B0096708/Desktop/vm automation excel files/final to add to db/lat longs.xlsx";
		FileInputStream fileToRead = new FileInputStream(new File(ToRead));
		XSSFWorkbook workbookToRead = new XSSFWorkbook(fileToRead); 
		XSSFSheet sheetToRead = workbookToRead.getSheetAt(2);
		JdbcTemplate jdbcTemplate= new JdbcTemplate(getDataSource());
		//	try {
		for(Row row:sheetToRead){
			//int count=8;
			//System.out.print(row.getCell(1)+"    "+row.getCell(2)+"     "+row.getCell(3)+"    "+row.getCell(5)+"    ");
			//				for(Cell cell:row){
			////						if((cell.toString()).toLowerCase().compareTo("yes")==0){
			////							//System.out.print((int)row.getCell(54).getNumericCellValue()+","+row.getCell(5)+","+row.getCell(3)+","+row.getCell(7)+",");
			////							//System.out.println(sheetToRead.getRow(2).getCell(count)+";"+sheetToRead.getRow(1).getCell(count)+";"+sheetToRead.getRow(0).getCell(count)+",");
			////				       //     out.write((int)row.getCell(54).getNumericCellValue()+","+row.getCell(5)+","+row.getCell(3)+","+row.getCell(7)+","+sheetToRead.getRow(2).getCell(count)+";"+sheetToRead.getRow(1).getCell(count)+";"+sheetToRead.getRow(0).getCell(count)+"\n");
			////				        
			////						}
			//						count++;
			//				}
			try{  
				String querySearch="select * from  vm_user where olmId=?";
				String queryDeleteUser="delete from vm_user where olmId=? and role='STOREMANAGER'";
				String queryInsertLATLONG="insert into vm_location_master( STORECODE,MANAGERMOBILENO,MANAGEROLMID,CIRCLE,ADDRESS,STOREMANAGER,STORETYPE,LATITUDE,LONGITUDE,STORENAME,LOCATIONTYPE) Values(?,?,?,?,?,?,?,?,?,?,?)";
				String deleteLatLong="delete from vm_location_master where storecode=?";
				String QUERYINSERTVMUSER="INSERT INTO VM_USER (OLMID,NAME,MOBILENO,EMAIL,ROLE,USERLOCATION) VALUES(?,?,?,?,?,?)";
				String deleteMapping="delete from vm_store_element_mapping where storecode=?";
				//System.out.println(String.valueOf((int)row.getCell(0).getNumericCellValue())+" "+String.valueOf(row.getCell(1).getNumericCellValue()).replace(".","").replaceAll("E9", "")+" "+row.getCell(2).toString()+" "+row.getCell(3).toString()+""+row.getCell(4).toString()+""+row.getCell(5).toString()+""+row.getCell(6).toString()+""+row.getCell(7).toString()+""+row.getCell(8).toString()+""+row.getCell(9).toString()+""+row.getCell(10).toString());  
				Object params[]=new Object[]{row.getCell(0).toString().replace(".0", ""),row.getCell(1).toString().replace(".","").replaceAll("E9", ""),row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString(),row.getCell(5).toString(),row.getCell(6).toString(),row.getCell(7).toString(),row.getCell(8).toString(),row.getCell(9).toString(),row.getCell(10).toString()};
				//to delete vm user
				//int i=jdbcTemplate.update(new StringBuilder(queryDelete).toString(), new Object[]{row.getCell(0).toString()});
				//System.out.println(i); 
				//to insert vm_user
				//				Object params[]=new Object[]{row.getCell(0).toString(),row.getCell(3).toString(),(row.getCell(2).toString()).replace(".","").replaceAll("E9", ""),row.getCell(1).toString(),"STOREMANAGER",row.getCell(4).toString()};
				//				int i=jdbcTemplate.update(new StringBuilder(QUERYINSERTVMUSER).toString(),params );
				//				System.out.println(i); 
				System.out.println(row.getCell(0).toString().replace(".0", "")+" "+row.getCell(1).toString().replace(".","").replaceAll("E9", "")+" "+row.getCell(2).toString()+" "+row.getCell(3).toString()+" "+row.getCell(4).toString()+" "+row.getCell(5).toString()+" "+row.getCell(6).toString()+" "+row.getCell(7).toString()+" "+row.getCell(8).toString()+" "+row.getCell(9).toString()+" "+row.getCell(10).toString());
				int i=jdbcTemplate.update(new StringBuilder(deleteMapping).toString(),new Object[]{row.getCell(0).toString().replace(".0", "")} );
				System.out.println(i);
				System.out.println(row.getCell(0).toString().replace(".0", "")); 
				//System.out.println(row.getCell(0)+" "+row.getCell(1));

			}catch(Exception e){ System.out.println(e);}  


		}
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		finally{
		//			out.close();
		//		}




		//ToWrite="/Users/B0096708/Desktop/vm automation excel files/Workbook1.xlsx";
		//FileInputStream fileToWrite = new FileInputStream(new File(ToWrite));
		//XSSFWorkbook workbookToWrite = new XSSFWorkbook(fileToWrite); 
		//XSSFSheet sheetToWrite = workbookToWrite.getSheetAt(0);



		//BufferedWriter out= new BufferedWriter(new FileWriter(new File("/Users/B0096708/FileWritten.txt")));
		//Iterator<Row> rowIteratorToWrite = sheetToWrite.iterator();
		//rowIteratorToWrite.next();
		//Iterator<Row> rowIteratorToRead = sheetToRead.iterator();
		//rowIteratorToRead.next();
		//StoreCode	StoreName	Circle	Element Name	Element Ratio	Element Dimension	
		//		while(rowIteratorToRead.hasNext()){
		//			Row rowToWrite=rowIteratorToRead.next();
		//			Iterator<Cell> cellToRead = 
		//			rowIteratorToRead.next();
		//			while(rowIteratorToRead.hasNext()){
		//				Row row=rowIteratorToRead.next();
		//				if(row.getCell(0).getNumericCellValue()==rowToWrite.getCell(1).getNumericCellValue()){
		//					System.out.println(row.getCell(0).getNumericCellValue()+" "+rowToWrite.getCell(1).getNumericCellValue());
		//				}
		//			}
		//		}
		//campaign wall column 14
		//System.out.println("StoreCode	StoreName	Circle store type	Element Name 	Element Ratio	Element Dimension	");
		//
		//		for(Row row:sheetToRead){
		//			//System.out.print(row.getCell(13)+"   ");
		//			if(row.getCell(13) != null && row.getCell(13).toString().compareTo(" ")!=0){
		//				System.out.println(row.getCell(13).toString().split("X").length);
		//				if(row.getCell(13).toString().split("X").length>0)
		//				System.out.println(Math.round((Double.parseDouble(row.getCell(13).toString().split("X")[0])/Double.parseDouble(row.getCell(13).toString().split("X")[1]))));	
		//			}
		//			else{
		//				System.out.println("NA");
		//			}
		//		}



	}

	public static DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//		   dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		//		   dataSource.setUrl("jdbc:oracle:thin:@10.5.203.22:1528:TEST");
		//		   dataSource.setUsername("wincustomer");
		//		   dataSource.setPassword("wincustomer");

		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.5.251.31:1528:vmauto1");
		dataSource.setUsername("vmautomation");
		dataSource.setPassword("welcome#123");
		return dataSource;
	}

}
