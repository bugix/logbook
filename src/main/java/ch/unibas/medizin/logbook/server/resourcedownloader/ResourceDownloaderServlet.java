package ch.unibas.medizin.logbook.server.resourcedownloader;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		try {
			setResource(request, response);
		} catch (IOException e) {
			Log.error("IO error in ResourceDownloaderServlet ", e);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void setResource(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		String fileName = "default.pdf";

		createPDF(os);

		sendFile(response, os.toByteArray(), fileName);
		os = null;
	}

	private void createPDF(OutputStream os) throws DocumentException, IOException {
		String fileSeparator = System.getProperty("file.separator");
		String File_To_Convert = getServletContext().getRealPath(fileSeparator) + "public/assignment_sp_1.htm";
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocument(new File(File_To_Convert));
		renderer.layout();
		renderer.createPDF(os);
		os.close();
	}

	private static void sendFile(HttpServletResponse response, byte[] resource, String fileName) throws IOException {
		ServletOutputStream stream = null;
		stream = response.getOutputStream();
		response.setContentType("application/x-download");
		response.addHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
		response.setContentLength(resource.length);
		if (resource.length > 0) {
			stream.write(resource);
		}
		stream.close();
	}
}
