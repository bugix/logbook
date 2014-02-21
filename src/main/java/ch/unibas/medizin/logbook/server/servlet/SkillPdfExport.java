package ch.unibas.medizin.logbook.server.servlet;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xhtmlrenderer.pdf.ITextRenderer;

import ch.unibas.medizin.logbook.server.domain.Skill;
import ch.unibas.medizin.logbook.shared.SkillFilteredResult;

public class SkillPdfExport   extends HttpServlet {

	
	private static Logger Log = Logger.getLogger(SkillPdfExport.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Log.info("SkillPdfExport");
		
		response.setContentType("application/pdf");
		
	//	 response.setContentType("application/x-download");
		// response.setHeader("Content-Disposition", "attachment; filename=" + "assignment_student_"+osceId+".html");
		
		Long studentId=new Long(request.getParameter("studentId"));
		Long mainClassificationId=new Long(request.getParameter("mainClassifcationId"));
		Long classificationTopicId=new Long(request.getParameter("classifcationId"));
		Long topicId=new Long(request.getParameter("topicId"));
		String fulltextSearch=request.getParameter("fullTextSearch");
		int chkAsc=new Integer(request.getParameter("chkAsc"));
		
		
	    try{
	    	
	    	if(studentId==0)
	    	{
	    		studentId=null;
	    	}
	    	if(mainClassificationId==0)
	    	{
	    		mainClassificationId=null;
	    	}
	    	if(classificationTopicId==0)
	    	{
	    		classificationTopicId=null;
	    	}
	    	if(topicId==0)
	    	{
	    		topicId=null;
	    	}
	    	String fileName=createHtml(Skill.findMainClassificatonBySearchCriteria(studentId, mainClassificationId, classificationTopicId, topicId, fulltextSearch, chkAsc), studentId);
	    	//createPDF(response.getOutputStream(),Skill.findMainClassificatonBySearchCriteria(studentId, mainClassificationId, classificationTopicId, topicId, fulltextSearch, chkAsc));
	/*    	OutputStream out = response.getOutputStream();
			FileInputStream in = new FileInputStream(fileName);
			
			
			
			byte[] buffer = new byte[4096];
			int length;
			while ((length = in.read(buffer)) > 0){
			    out.write(buffer, 0, length);
			}
			in.close();
			
			File htmlFile=new File(fileName);
			htmlFile.delete();
			out.flush();*/
	    	
	    	
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			String pdffileName = "studentSkill"+studentId+".pdf";

			createPDF(os,fileName);
			//printPdf();
			sendFile(response, os.toByteArray(), pdffileName);
			os = null;
	        
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	   
	    	
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
	
	public  org.w3c.dom.Document createDocument()
	{
		try{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setValidating(true);
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
       
        org.w3c.dom.Document doc = docBuilder.newDocument();
        return doc;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        
	}
	
	public  Element createChildNode(String nodeName,String nodeValue,org.w3c.dom.Document doc,Element parent)
	{
		 Element element = doc.createElement(nodeName);//create  node
		 parent.appendChild(element);	//append to its parent
	        Text text2 = doc.createTextNode(nodeValue);	//create Text node/ value
	        element.appendChild(text2); 
	        return element;
	}
	public Element createEmptyChildNode(String nodeName,org.w3c.dom.Document doc,Element parent)
	{
		 Element element = doc.createElement(nodeName);//create  node
		 parent.appendChild(element);	//append to its parent
	      //  Text text2 = doc.createTextNode(nodeValue);	//create Text node/ value
	    //    element.appendChild(text2); 
	        return element;
	}
	
	public String createHtml(SkillFilteredResult result,Long studentId)
	{
		 org.w3c.dom.Document doc=createDocument();
		
		Element root = doc.createElement("mainClassifications");
		
		//append root to document
		doc.appendChild(root);
		List<Skill> skills=result.getSkillList();
		
		Element classificationTopicsElement=null;
		Element topicsElement=null;
		Element skillsElement=null;

		for(int i=0;i<skills.size();i++)
		{
			Skill skill=skills.get(i);
			String topicDescription=skill.getTopic().getTopicDescription();
			String ctopicDescription=skill.getTopic().getClassificationTopic().getDescription();
			String mDescription=(skill.getTopic().getClassificationTopic().getMainClassification().getDescription());
			
			
		
			
			if(i==0)
			{
				 Element mainClassificationElement=createEmptyChildNode("mainClassification",doc,root);
				 createChildNode("description", mDescription, doc, mainClassificationElement);
				 
				  classificationTopicsElement=createEmptyChildNode("classificationTopics",doc,mainClassificationElement);
				 Element classificationTopicElement=createEmptyChildNode("classificationTopic",doc,classificationTopicsElement);
				 createChildNode("description", ctopicDescription, doc, classificationTopicElement);
				 
				  topicsElement=createEmptyChildNode("topics",doc,classificationTopicElement);
				 Element topicElement=createEmptyChildNode("topic",doc,topicsElement);
				 createChildNode("description", topicDescription, doc, topicElement);
				  skillsElement=createEmptyChildNode("skills",doc,topicElement);

			}
			else
			{
				
				 if( ( skill.getTopic().getClassificationTopic().getMainClassification().getId() != skills.get(i-1).getTopic().getClassificationTopic().getMainClassification().getId()))
					{
						Element mainClassificationElement=createEmptyChildNode("mainClassification",doc,root);
						 createChildNode("description", mDescription, doc, mainClassificationElement);
						 
						  classificationTopicsElement=createEmptyChildNode("classificationTopics",doc,mainClassificationElement);
						 Element classificationTopicElement=createEmptyChildNode("classificationTopic",doc,classificationTopicsElement);
						 createChildNode("description", ctopicDescription, doc, classificationTopicElement);
						 
						  topicsElement=createEmptyChildNode("topics",doc,classificationTopicElement);
						 Element topicElement=createEmptyChildNode("topic",doc,topicsElement);
						 createChildNode("description", topicDescription, doc, topicElement);
						 skillsElement=createEmptyChildNode("skills",doc,topicElement);
					}
				
				else if( ( skill.getTopic().getClassificationTopic().getId() != skills.get(i-1).getTopic().getClassificationTopic().getId()))
					{
					if(!skill.getTopic().getClassificationTopic().getDescription().equals("Blank"))
					{
						
						 Element classificationTopicElement=createEmptyChildNode("classificationTopic",doc,classificationTopicsElement);
						 createChildNode("description", ctopicDescription, doc, classificationTopicElement);
						 
						  topicsElement=createEmptyChildNode("topics",doc,classificationTopicElement);
						 Element topicElement=createEmptyChildNode("topic",doc,topicsElement);
						 createChildNode("description", topicDescription, doc, topicElement);
						 skillsElement=createEmptyChildNode("skills",doc,topicElement);
					}
					}
				 
				 else if( ( skill.getTopic().getId() != skills.get(i-1).getTopic().getId()))
					{
						
						 Element topicElement=createEmptyChildNode("topic",doc,topicsElement);
						 createChildNode("description", topicDescription, doc, topicElement);
						 skillsElement=createEmptyChildNode("skills",doc,topicElement);
						
					}
				
			}
			
			
			Element skillElement=createEmptyChildNode("skill",doc,skillsElement);
			createChildNode("description", skill.getDescription(), doc, skillElement);
			
			String ctopicShortCut="";
			String mainClassificationShortcut="";
			if(skill.getTopic().getClassificationTopic().getShortcut() !=null)
				ctopicShortCut=skill.getTopic().getClassificationTopic().getShortcut();
			
			if(skill.getTopic().getClassificationTopic().getMainClassification().getShortcut() !=null)
				mainClassificationShortcut=skill.getTopic().getClassificationTopic().getMainClassification().getShortcut();
			
			
			createChildNode("shortcut", mainClassificationShortcut+ " "+ ctopicShortCut +" "+skill.getShortcut(), doc, skillElement);
			
			if(skill.getSkillLevel() != null)
				createChildNode("skillLevel", skill.getSkillLevel().getLevelNumber().toString(), doc, skillElement);
			else 
				createChildNode("skillLevel", "-", doc, skillElement);
			
			Integer levelNum=Skill.findSkillLevelAcquired(studentId, skill.getId());
			if(levelNum !=null)
				createChildNode("skillLevelAcquired", levelNum.toString(), doc, skillElement);
			else
				createChildNode("skillLevelAcquired", "-", doc, skillElement);
			
			
		}
		
		
		return saveXML(doc);
		
	}
	
	
	
	
	public String saveXML(org.w3c.dom.Document doc)
	{
		try{
			TransformerFactory factory = TransformerFactory.newInstance();
	        Transformer transformer = factory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        StringWriter sw = new StringWriter();
	        StreamResult result = new StreamResult(sw);
	        DOMSource source = new DOMSource(doc);
	        transformer.transform(source, result);
	        String xmlString = sw.toString();

	       // File file = new File("osMaEntry/gwt/unibas/"+System.currentTimeMillis()+".xml");
	        String path=getServletConfig().getServletContext().getRealPath("/logbook/gwt/logbook/");
	        String fileName=path+"/"+System.currentTimeMillis()+".xml";
	        Log.info("Path: " + fileName);
	        
	        File file = new File(fileName);
	        file.createNewFile();
	        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"UTF-8"));

	        bw.write(xmlString);
	        bw.flush();
	        bw.close();
	        
	        
	        String htmlFileName=convertXmlToHtml(fileName);
	        
	        return htmlFileName;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String convertXmlToHtml(String fileName)
	{
		 try
	        {
			 
			 	
			 	
	            TransformerFactory tFactory = TransformerFactory.newInstance();
	            String xslPath=getServletConfig().getServletContext().getRealPath("/logbook/gwt/logbook/skill.xsl");
	            Source xslDoc = new StreamSource(xslPath);
	            Source xmlDoc = new StreamSource(fileName);
	            
	            String path=getServletConfig().getServletContext().getRealPath("/logbook/gwt/logbook/");
	            String outputFileName =path +"/"+System.currentTimeMillis()+".html";
	            Log.info("Path: " + outputFileName);    
	            OutputStream htmlFile = new FileOutputStream(outputFileName);

	            Transformer transformer = tFactory.newTransformer(xslDoc);
	            transformer.setErrorListener(new ErrorListener() {
					
					@Override
					public void warning(TransformerException exception)
							throws TransformerException {
						Log.info("Warning.");
						
						Log.error("Warning", exception);
					}
					
					@Override
					public void fatalError(TransformerException exception)
							throws TransformerException {
						Log.info("fatal Error.");
						Log.error("fatal Error.", exception);
					}
					
					@Override
					public void error(TransformerException exception)
							throws TransformerException {
						Log.info("Error.");	
						Log.error("Error", exception);
					}
				});
	            transformer.transform(xmlDoc, new StreamResult(htmlFile));
	            htmlFile.close();
	            File xmlFile=new File(fileName);
	            xmlFile.delete();
	           return outputFileName;
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return null;
	        }
	}
	
	private void createPDF(OutputStream os,String htmlFileName) {
//		String contextFileSeparator = "/";
		
		
	//	String fileSeparator = System.getProperty("file.separator");
	//	String File_To_Convert = getServletContext().getRealPath(fileSeparator) +  "public/assignment_sp_1.htm";
//		String File_To_Convert = getServletContext().getContextPath() + "/public/assignment_sp_1.html";
	 	//String File_To_Convert = "D:\\assignment_sp_1.htm";
        //String url = new File(File_To_Convert).toURI().toURL().toString();
		Log.info("url : "+htmlFileName);
        //String HTML_TO_PDF = "D:\\ConvertedFile.pdf";
       // OutputStream os = new FileOutputStream(HTML_TO_PDF);  
        
     /*   File myhtml = new File(htmlFileName);
        FileInputStream fileinput = null;
        BufferedInputStream mybuffer = null;
        DataInputStream datainput = null;

        fileinput = new FileInputStream(myhtml);
        mybuffer = new BufferedInputStream(fileinput);
        datainput = new DataInputStream(mybuffer);

        while (datainput.available() != 0) {
        	
        	if(datainput.readLine().)
        	System.out.println(datainput.readLine());
        	}
*/
        try {
	        ITextRenderer renderer = new ITextRenderer();
	        Log.info("Skill PDF Export->Create PDF->File name: " + htmlFileName);
	        renderer.setDocument(new File(htmlFileName));      
	        renderer.layout();
	        renderer.createPDF(os);  
	        os.close();
        }catch (Exception e) {
        	Log.error("Error in SkillPdfExport",e);
        }
	}
	
/*	public void createPDF(ServletOutputStream outputStream,SkillFilteredResult result) throws Exception
	{
		Log.info("mainClassifications size" +result.getTotalSkill());
		
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter.getInstance(document, outputStream);
		document.open();
		List<Skill> skills=result.getSkillList();
		for(int i=0;i<skills.size();i++)
		{
			Skill skill=skills.get(i);
			String topicDescription=skill.getTopic().getTopicDescription();
			String ctopicDescription=skill.getTopic().getClassificationTopic().getDescription();
			StringBuilder mDescription=new StringBuilder(skill.getTopic().getClassificationTopic().getMainClassification().getDescription());
			
			
			if(i==0)
			{
				
				
				for(int j=mDescription.length();j<150;j++)
				{
					mDescription.append(" ");
				}
			
				Chunk mChunk=new Chunk(mDescription.toString(),new Font(FontFamily.HELVETICA, 22));
				mChunk.setBackground(BaseColor.GREEN);
				
				Paragraph mParaGraph=new Paragraph();
				mParaGraph.add(mChunk);
				
				
				
				document.add(mParaGraph);
				//document.add(new Paragraph(mDescription,new Font(FontFamily.HELVETICA, 22)));
				document.add(new Paragraph(ctopicDescription,new Font(FontFamily.HELVETICA, 18, Font.BOLD)));
				document.add(new Paragraph(topicDescription,new Font(FontFamily.HELVETICA, 14, Font.BOLD)));
			}
			else
			{
				if( ( skill.getTopic().getId() != skills.get(i-1).getTopic().getId()))
				{
					
					document.add(new Paragraph(topicDescription,new Font(FontFamily.HELVETICA, 14, Font.BOLD)));
					
				}
				else if( ( skill.getTopic().getClassificationTopic().getId() != skills.get(i-1).getTopic().getClassificationTopic().getId()))
					{
					if(!skill.getTopic().getClassificationTopic().getDescription().equals("Blank"))
					{
						document.add(new Paragraph(ctopicDescription,new Font(FontFamily.HELVETICA, 18, Font.BOLD)));
					}
					}
				else if( ( skill.getTopic().getClassificationTopic().getMainClassification().getId() != skills.get(i-1).getTopic().getClassificationTopic().getMainClassification().getId()))
				{
					document.add(new Paragraph(mDescription.toString(),new Font(FontFamily.HELVETICA, 22, Font.BOLD,BaseColor.GREEN)));
				}
			}
			
		}
		
		
        
        document.close();
	}*/
}
