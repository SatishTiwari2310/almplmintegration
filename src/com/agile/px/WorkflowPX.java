package com.agile.px;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import com.agile.api.APIException;
import com.agile.api.IAgileSession;
import com.agile.api.IAttachmentFile;
import com.agile.api.ICell;
import com.agile.api.IFileFolder;
import com.agile.api.IItem;
import com.agile.api.INode;
import com.agile.api.IProgram;
import com.agile.api.IRow;
import com.agile.api.ITable;
import com.agile.api.ItemConstants;
import com.agile.api.ProgramConstants;
import com.plm.alm.ws.ALMServiceImplProxy;

//import com.test.client.TestClient;

public class WorkflowPX implements IEventAction{

	@Override
	public EventActionResult doAction(IAgileSession session, INode node, IEventInfo eventInfo) {
		ActionResult result = null;
		IWFChangeStatusEventInfo info = (IWFChangeStatusEventInfo)eventInfo;
		String itemNumber = null;
		String projectNumber = null;
		String desc = null;


		try {
			IProgram projectObj = (IProgram)info.getDataObject();
			if(projectObj.getValue(ProgramConstants.ATT_GENERAL_INFO_NAME).toString().equalsIgnoreCase("Build")){
				String createSWPartFlag = projectObj.getValue(ProgramConstants.ATT_PAGE_TWO_LIST01).toString();
				System.out.println("CreateSWPart >>"+createSWPartFlag);
				if(createSWPartFlag.equalsIgnoreCase("Yes")){
					ICell cell = (ICell)projectObj.getCell(ProgramConstants.ATT_GENERAL_INFO_PARENT);
					IProgram parentObj = (IProgram)cell.getReferent();
					projectNumber = parentObj.getName();
					System.out.println("Project Number >>"+projectNumber);
					ITable contentTable = parentObj.getRelationship();
					Iterator<?> it = contentTable.iterator();
					while(it.hasNext()){
						IRow row = (IRow)it.next();
						IItem item = (IItem)row.getReferent();
						desc = item.getValue(ItemConstants.ATT_TITLE_BLOCK_DESCRIPTION).toString();
						itemNumber = item.getName();
						System.out.println("HW Item Number" +itemNumber);
					}

					ITable attatchmentsTable = parentObj.getTable(ProgramConstants.TABLE_ATTACHMENTS);
					Iterator it1 = attatchmentsTable.iterator();
					while(it1.hasNext())
					{
						IRow row1 = (IRow)it1.next();
						InputStream inputStream = ((IAttachmentFile) row1).getFile();
						IFileFolder folderNo = (IFileFolder) row1.getReferent();
						System.out.println("Folder Number>> " +folderNo);
						String fileName = row1.getValue(ProgramConstants.ATT_ATTACHMENTS_FILE_NAME).toString();
						//String fileExt = row1.getValue(ProgramConstants.ATT_ATTACHMENTS_FILE_TYPE).toString();

						//
						File file = new File("E:\\ALMFiles\\"+fileName);
						
						//String
						System.out.println("FileName>>"+file.getName());
						//	String filePath = file.getAbsolutePath();
						//System.out.println("File Path>> " +filePath);
						//System.out.println(file.getAbsolutePath());
						writeInputStreamToFile(file.getAbsolutePath(), inputStream);
						ALMServiceImplProxy pp=new ALMServiceImplProxy();
						System.out.println("ProjectNumber"+projectNumber);

						System.out.println("itemNumber"+itemNumber);
						System.out.println("desc >>"+desc);
						String filePath = "\\\\INBASDPC06054\\ALMFiles\\"+file.getName();
						System.out.println("File Path >>"+filePath);
						String response = pp.createHWPart(projectNumber, itemNumber, desc, file.getName(), filePath, "application/msword", true);
						System.out.println(response);


						result = new ActionResult(ActionResult.STRING, response);
					}
				} else {
					result = new ActionResult(ActionResult.STRING, "No Action Required");
				}
			} else {
				result = new ActionResult(ActionResult.STRING, "No Changes");
			}


		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return new EventActionResult(eventInfo, result);
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



