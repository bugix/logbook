package logbook.server.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class CsvFileCreator
 */
public class CsvFileGenerator extends HttpServlet implements SingleThreadModel{
	private static final long serialVersionUID = 1L;
       
    public CsvFileGenerator() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try
		{
					
			//System.out.println("At doGet()");
			String fileSeparator = System.getProperty("file.separator");
			String fileName = getServletContext().getRealPath(fileSeparator) +  "public/test.csv";
			
			File csvFile = new File(fileName);
			
			FileUtils.touch(csvFile);
			
			sendFile(response,csvFile ,fileName);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	private static void sendFile(HttpServletResponse response,File header,String fileName) throws IOException {
/*		
		ServletOutputStream stream = null;
		stream = response.getOutputStream();
		response.setContentType("application/x-download");
		response.addHeader("Content-Disposition", "inline; filename=\""
				+ fileName + "\"");
		
		response.setContentLength((int) header.length());
		if(header.length() > 0) {
			stream.write(new String(FileUtils.readFileToByteArray(header)).getBytes("UTF-16"));
		}
		stream.close();
		
	}*/


		ServletOutputStream stream = null;
		stream = response.getOutputStream();
		byte [] csv = FileUtils.readFileToByteArray(header);

		response.setContentType("text/csv"); 
		    
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\"");
		
		response.setContentLength(csv.length);
		if(csv.length > 0) {
			stream.write(csv);
		}
		stream.close(); 
	}
}