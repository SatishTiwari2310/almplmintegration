package com.agile.px;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

import sun.font.CreatedFontTracker;

import com.agile.api.APIException;
import com.agile.api.AgileSessionFactory;
import com.agile.api.IAgileSession;
import com.agile.api.IAttachmentFile;
import com.agile.api.IFileFolder;
import com.agile.api.IItem;
import com.agile.api.IProgram;
import com.agile.api.IRow;
import com.agile.api.ITable;
import com.agile.api.ItemConstants;
import com.agile.api.ProgramConstants;
import com.plm.alm.ws.ALMServiceImplProxy;

public class Test {
	
	public static void main(String [] args){
		String itemNumber = null;
		String projectNumber = "PGM00004";
		String desc = null;
		
		
		File file = new File("file://INBASDPC06054/ALMFiles/StepsNew.doc");
		
		System.out.println(file.getName());
		
	/*	try {
			
			IAgileSession session = createAgileSession("admin","badari","http://inbasdpc06054.techmahindra.com:7001/Agile");
			IProgram projectObj = (IProgram) session.getObject(IProgram.OBJECT_TYPE, projectNumber);
			//IProgram projectObj = (IProgram)info.getDataObject();
			
			projectNumber = projectObj.getName();
			ITable contentTable = projectObj.getRelationship();
			Iterator<?> it = contentTable.iterator();
			while(it.hasNext()){
				IRow row = (IRow)it.next();
				IItem item = (IItem)row.getReferent();
				desc = item.getValue(ItemConstants.ATT_TITLE_BLOCK_DESCRIPTION).toString();
				itemNumber = item.getName();
			}
			
			ITable attatchmentsTable = projectObj.getTable(ProgramConstants.TABLE_ATTACHMENTS);
			Iterator it1 = attatchmentsTable.iterator();
			while(it1.hasNext())
			{
				IRow row1 = (IRow)it1.next();
				InputStream inputStream = ((IAttachmentFile) row1).getFile();
				IFileFolder folderNo = (IFileFolder) row1.getReferent();
				System.out.println("Folder Number>> " +folderNo);
				String fileName = row1.getValue(ProgramConstants.ATT_ATTACHMENTS_FILE_NAME).toString();
				//String fileExt = row1.getValue(ProgramConstants.ATT_ATTACHMENTS_FILE_TYPE).toString();
				
				File file = new File("D:\\"+fileName);
				System.out.println(file);
				String filePath = file.getAbsolutePath();
				System.out.println("File Path>> " +filePath);
				writeInputStreamToFile(file.getAbsolutePath(), inputStream);
				ALMServiceImplProxy pp=new ALMServiceImplProxy();
				
				String response = pp.createHWPart(projectNumber, itemNumber, desc, file.getName(), filePath, "text/plain", true);
				System.out.println(response);
				//result = new ActionResult(ActionResult.STRING, response);
				
			}
			
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	  public static IAgileSession createAgileSession(String sUsername,
	            String sPassword, String sURL) throws APIException {

	        HashMap<Integer, String> hmInputAttrs = new HashMap<Integer, String>();
	        hmInputAttrs.put(AgileSessionFactory.USERNAME, sUsername);
	        hmInputAttrs.put(AgileSessionFactory.PASSWORD, sPassword);
	        
	        AgileSessionFactory instance = AgileSessionFactory.getInstance(sURL);

	        return instance.createSession(hmInputAttrs);
	    }
	
	
	public static void writeInputStreamToFile(String outputFile, InputStream inputStream) throws IOException {

		OutputStream outputStream = null;

		outputStream = new FileOutputStream(new File(outputFile));
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}

		if (inputStream != null) {
			inputStream.close();
		}
		if (outputStream != null) {
			outputStream.close();
		}

	}

}
