package miscellaneous;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
public class ReadFromExcelAndWriteInExcel {

	private static String ToWrite;
	private static String ToRead;

	public static void main(String [] args) throws Exception{
		ToRead="/Users/B0096708/Desktop/vm automation excel files/final to add to db/WorkbookWithStoreElementDetailswrittenOR-B2C.csv";
		FileInputStream fileToRead = new FileInputStream(new File(ToRead));
		//		XSSFWorkbook workbookToRead = new XSSFWorkbook(fileToRead); 
		//		XSSFSheet sheetToRead = workbookToRead.getSheetAt(3);
		JdbcTemplate jdbcTemplate= new JdbcTemplate(getDataSource());

		String splitBy = ",";
		String insertStoreMapping="insert into vm_store_element_mapping (ID,STORECODE,ELEMENTTYPEID,CIRCLE,STORENAME,ELEMENTNAME,ELEMENTRATIO,ELEMENTDIMENSION) values(?,?,?,?,?,?,?,?)"; 
		BufferedReader br = new BufferedReader(new FileReader(ToRead));
		Connection conn=getDataSource().getConnection();
		PreparedStatement ps = conn.prepareStatement(insertStoreMapping);
		//batch update
		final int batchSize = 300;
		int count = 0;
		String line = null;
		while((line = br.readLine()) !=null){
			String[] b = line.split(splitBy);
			String k=UUID.randomUUID().toString();
			System.out.println(k+","+b[0]+","+b[7]+","+"DELHI"+","+b[1]+","+b[4]+","+b[5]+","+b[6]);
			//Object params[]=new Object[]{ ,b[0],b[7],"DELHI",b[1],b[4],b[5],b[6]};
//			ps.setString(1, k);
//			ps.setString(2, b[0]);
//			ps.setString(3, b[7]);
//			ps.setString(4, "DELHI");
//			ps.setString(5, b[1]);
//			ps.setString(6, b[4]);
//			ps.setString(7, b[5]);
//			ps.setString(8, b[6]);
			//int i=jdbcTemplate.update(new StringBuilder(insertStoreMapping).toString(),params );
//			ps.addBatch();
//			if(++count % batchSize == 0) {
//				ps.executeBatch();
//			}
		}
//		ps.executeBatch(); // insert remaining records
//		ps.close();
//		conn.close();
		br.close();
		fileToRead.close();

		//	try {
		//		for(Row row:sheetToRead){
		//			try{  [
		//				String querySearch="select * from  vm_user where olmId=?";
		//				String queryDelete="delete from vm_user where olmId=? and role='STOREMANAGER'";
		//				String queryInsertLATLONG="insert into vm_location_master( STORECODE,MANAGERMOBILENO,MANAGEROLMID,CIRCLE,ADDRESS,STOREMANAGER,STORETYPE,LATITUDE,LONGITUDE,STORENAME,LOCATIONTYPE) Values(?,?,?,?,?,?,?,?,?,?,?)";
		//				String deleteLatLong="delete from vm_store_element_mapping where storecode=?";
		//				String QUERYINSERTVMUSER="INSERT INTO VM_USER (OLMID,NAME,MOBILENO,EMAIL,ROLE,USERLOCATION) VALUES(?,?,?,?,?,?)";
		//				//int i=jdbcTemplate.update(new StringBuilder(insertStoreMapping).toString(),params );
		//				//System.out.println(row.getCell(35).toString().replace(".0", "")+" "+i); 
		//				//				System.out.println(row.getCell(0).toString().replace(".0", "")+" "+row.getCell(1).toString().replace(".","").replaceAll("E9", "")+" "+row.getCell(2).toString()+" "+row.getCell(3).toString()+" "+row.getCell(4).toString()+" "+row.getCell(5).toString()+" "+row.getCell(6).toString()+" "+row.getCell(7).toString()+" "+row.getCell(8).toString()+" "+row.getCell(9).toString()+" "+row.getCell(10).toString());
		//				//				int i=jdbcTemplate.update(new StringBuilder(queryInsertLATLONG).toString(),params );
		//				//				System.out.println(i); 
		//				//				System.out.println(row.getCell(0)+" "+row.getCell(1));
		//				//				if(row.getCell(1) == null){
		//				//					System.out.println(row.getCell(0));
		//				//				}
		//
		//			}catch(Exception e){ System.out.println(e);}  
		//
		//		}

		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		finally{
		//			out.close();
		//		}


		//			ToRead="/Users/B0096708/Desktop/vm automation excel files/final to add to db/FR_OR_element details_New format_Delhi.xlsx";
		//			ToWrite="/Users/B0096708/Desktop/vm automation excel files/final to add to db/WorkbookWithStoreElementDetailswrittenOR-B2C2.csv";
		//			FileInputStream fileRead = new FileInputStream(new File(ToRead));
		//			XSSFWorkbook workbookToREad = new XSSFWorkbook(fileRead); 
		//XSSFSheet sheetToRead = workbookToREad.getSheetAt(0);


		//	File fileTowrite= new File(ToWrite); 
		//	BufferedWriter out= new BufferedWriter(new FileWriter(fileTowrite));
		//	
		//	//StoreCode	StoreName	Circle	Element Name	Element Ratio	Element Dimension	
		//	System.out.println("StoreCode	StoreName	Circle store type	Element Name 	Element Ratio	Element Dimension	\n");
		//	out.write("StoreCode	StoreName	Circle store type	Element Name 	Element Ratio	Element Dimension	");
		//	//out.flush();
		//	for(Row row:sheetToRead){
		//		int count=0;
		//		for(Cell cell:row){
		//			//System.out.println(cell.getRow().getCell(cell.getColumnIndex()).toString().toLowerCase()+sheetToRead.getRow(3).getCell(count));
		//			if(cell.getRow().getCell(cell.getColumnIndex()).toString().toLowerCase().compareTo("yes")==0  ){
		//				out.write(row.getCell(56).toString().replace(".0", "")+","+row.getCell(3).toString()+","+"DELHI"+",");
		//				out.write("OR-B2C"+","+sheetToRead.getRow(3).getCell(count)+","+sheetToRead.getRow(1).getCell(count)+","+sheetToRead.getRow(2).getCell(count)+","+sheetToRead.getRow(0).getCell(count)+"\n");
		//				System.out.print(row.getCell(56).toString().replace(".0", "")+"  "+row.getCell(3).toString()+"  "+"DELHI"+" ");
		//				System.out.println("OR-B2C"+"  "+sheetToRead.getRow(3).getCell(count)+"  "+sheetToRead.getRow(1).getCell(count)+"  "+sheetToRead.getRow(2).getCell(count)+"  "+sheetToRead.getRow(0).getCell(count)+"  ");
		////				out.write(row.getCell(34).toString().replace(".0", "")+","+row.getCell(4).toString()+","+"DELHI"+",");
		////				out.write("FR-B2C"+","+sheetToRead.getRow(3).getCell(count)+","+sheetToRead.getRow(1).getCell(count)+","+sheetToRead.getRow(2).getCell(count)+","+sheetToRead.getRow(0).getCell(count)+"\n");
		////				System.out.print(row.getCell(34).toString().replace(".0", "")+","+row.getCell(4).toString()+","+"DELHI"+",");
		////				System.out.println("FR-B2C"+","+sheetToRead.getRow(3).getCell(count)+","+sheetToRead.getRow(1).getCell(count)+","+sheetToRead.getRow(2).getCell(count)+","+sheetToRead.getRow(0).getCell(count));
		//			}
		//			count++;
		//		}
		//	}
		//	out.close();
		//	//campaign wall column 14
		////	System.out.println("StoreCode	StoreName	Circle store type	Element Name 	Element Ratio	Element Dimension	");
		//	
		////			for(Row row:sheetToRead){
		////				//System.out.print(row.getCell(13)+"   ");
		////				if(row.getCell(13) != null && row.getCell(13).toString().compareTo(" ")!=0){
		////					System.out.println(row.getCell(13).toString().split("X").length);
		////					if(row.getCell(13).toString().split("X").length>0)
		////					System.out.println(Math.round((Double.parseDouble(row.getCell(13).toString().split("X")[0])/Double.parseDouble(row.getCell(13).toString().split("X")[1]))));	
		////				}
		////				else{
		////					System.out.println("NA");
		////				}
		////			}
		//


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
