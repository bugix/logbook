package logbook.server.resourcedownloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.log4j.Logger;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;


public class ResourceDownloaderServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	private static Logger Log = Logger.getLogger(ResourceDownloaderServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		//String entity = request.getParameter("");
		
		//if(StringUtils.isNotBlank(entity)) {
			try {
				setResource(request, response);	
			} catch (IOException e) {
				Log.error("IO error in ResourceDownloaderServlet ",e);
			}
			catch (DocumentException e) {
				e.printStackTrace();
			}
			
			/*}else {
			Log.error("Entity is not valid : " + entity);
		}*/
	}
	
	
	public  void setResource(HttpServletRequest request,
			HttpServletResponse response) throws IOException, DocumentException {

		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		String fileName = "default.pdf";

		createPDF(os);
		//printPdf();
		sendFile(response, os.toByteArray(), fileName);
		os = null;
	}
	
	
	private void createPDF(OutputStream os) throws DocumentException, IOException {
//		String contextFileSeparator = "/";
		
		
		String fileSeparator = System.getProperty("file.separator");
		String File_To_Convert = getServletContext().getRealPath(fileSeparator) +  "public/assignment_sp_1.htm";
//		String File_To_Convert = getServletContext().getContextPath() + "/public/assignment_sp_1.html";
	 	//String File_To_Convert = "D:\\assignment_sp_1.htm";
        //String url = new File(File_To_Convert).toURI().toURL().toString();
        System.out.println("url : "+File_To_Convert);
        //String HTML_TO_PDF = "D:\\ConvertedFile.pdf";
       // OutputStream os = new FileOutputStream(HTML_TO_PDF);       
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(new File(File_To_Convert));      
        renderer.layout();
        renderer.createPDF(os);        
        os.close();
	}

	private void printPdf(){
		/*PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();  
        DocPrintJob printerJob = defaultPrintService.createPrintJob();  
        String fileSeparator = System.getProperty("file.separator");
        String File_To_Convert = getServletContext().getRealPath(fileSeparator) +  "public/assignment_sp_1.htm";
        File pdfFile = new File(File_To_Convert);  
        SimpleDoc simpleDoc = null;  
          
        try {  
            simpleDoc = new SimpleDoc(pdfFile.toURL(), DocFlavor.URL.AUTOSENSE, null);  
        } catch (MalformedURLException ex) {  
            ex.printStackTrace();  
        }  
        try {  
            printerJob.print(simpleDoc, null);  
        } catch (PrintException ex) {  
            ex.printStackTrace();  
        }  */
		/*
		FileInputStream psStream = null;  
        try {  
            psStream = new FileInputStream("some.pdf");  
            } catch (FileNotFoundException ffne) {  
              ffne.printStackTrace();  
            }  
            if (psStream == null) {  
                return;  
            }  
        DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;  
        Doc myDoc = new SimpleDoc(psStream, psInFormat, null);    
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();  
        PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);  
          
        // this step is necessary because I have several printers configured  
        PrintService myPrinter = null;  
        for (int i = 0; i < services.length; i++){  
            System.out.println("service found: "+svcName);  
            String svcName = services[i].toString();             
            if (svcName.contains("printer closest to me")){  
                myPrinter = services[i];  
                System.out.println("my printer found: "+svcName);  
                break;  
            }  
        }  
          
        if (myPrinter != null) {              
            DocPrintJob job = myPrinter.createPrintJob();  
            try {  
            job.print(myDoc, aset);  
              
            } catch (Exception pe) {pe.printStackTrace();}  
        } else {  
            System.out.println("no printer services found");  
        }  
   }  */
	}
	private static void sendFile(HttpServletResponse response, byte[] resource,
			String fileName) throws IOException {
		ServletOutputStream stream = null;
		stream = response.getOutputStream();
		response.setContentType("application/x-download");
		response.addHeader("Content-Disposition", "inline; filename=\""
				+ fileName + "\"");
		response.setContentLength((int) resource.length);
		if(resource.length > 0) {
			stream.write(resource);
		}
		stream.close();
	}

	
}
