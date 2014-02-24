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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xhtmlrenderer.pdf.ITextRenderer;

import ch.unibas.medizin.logbook.server.domain.Skill;
import ch.unibas.medizin.logbook.server.filter.AuthenticationFilter;
import ch.unibas.medizin.logbook.shared.SkillFilteredResult;

@SuppressWarnings("serial")
public class SkillPdfExport extends HttpServlet {

	private final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("SkillPdfExport");

		response.setContentType("application/pdf");

		Long studentId = new Long(request.getParameter("studentId"));
		Long mainClassificationId = new Long(request.getParameter("mainClassifcationId"));
		Long classificationTopicId = new Long(request.getParameter("classifcationId"));
		Long topicId = new Long(request.getParameter("topicId"));
		String fulltextSearch = request.getParameter("fullTextSearch");
		int chkAsc = new Integer(request.getParameter("chkAsc"));

		try {

			if (studentId == 0) {
				studentId = null;
			}
			if (mainClassificationId == 0) {
				mainClassificationId = null;
			}
			if (classificationTopicId == 0) {
				classificationTopicId = null;
			}
			if (topicId == 0) {
				topicId = null;
			}
			String fileName = createHtml(Skill.findMainClassificatonBySearchCriteria(studentId, mainClassificationId, classificationTopicId, topicId, fulltextSearch, chkAsc), studentId);

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			String pdffileName = "studentSkill" + studentId + ".pdf";

			createPDF(os, fileName);

			sendFile(response, os.toByteArray(), pdffileName);
			os = null;

		} catch (Exception e) {
			e.printStackTrace();
		}

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

	public Document createDocument() {
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			builderFactory.setValidating(true);
			DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Element createChildNode(String nodeName, String nodeValue, Document doc, Element parent) {
		Element element = doc.createElement(nodeName);// create node
		parent.appendChild(element); // append to its parent
		Text text2 = doc.createTextNode(nodeValue); // create Text node/ value
		element.appendChild(text2);
		return element;
	}

	public Element createEmptyChildNode(String nodeName, Document doc, Element parent) {
		Element element = doc.createElement(nodeName);// create node
		parent.appendChild(element); // append to its parent
		return element;
	}

	public String createHtml(SkillFilteredResult result, Long studentId) {
		Document doc = createDocument();

		Element root = doc.createElement("mainClassifications");

		// append root to document
		doc.appendChild(root);
		List<Skill> skills = result.getSkillList();

		Element classificationTopicsElement = null;
		Element topicsElement = null;
		Element skillsElement = null;

		for (int i = 0; i < skills.size(); i++) {
			Skill skill = skills.get(i);
			String topicDescription = skill.getTopic().getTopicDescription();
			String ctopicDescription = skill.getTopic().getClassificationTopic().getDescription();
			String mDescription = (skill.getTopic().getClassificationTopic().getMainClassification().getDescription());

			if (i == 0) {
				Element mainClassificationElement = createEmptyChildNode("mainClassification", doc, root);
				createChildNode("description", mDescription, doc, mainClassificationElement);

				classificationTopicsElement = createEmptyChildNode("classificationTopics", doc, mainClassificationElement);
				Element classificationTopicElement = createEmptyChildNode("classificationTopic", doc, classificationTopicsElement);
				createChildNode("description", ctopicDescription, doc, classificationTopicElement);

				topicsElement = createEmptyChildNode("topics", doc, classificationTopicElement);
				Element topicElement = createEmptyChildNode("topic", doc, topicsElement);
				createChildNode("description", topicDescription, doc, topicElement);
				skillsElement = createEmptyChildNode("skills", doc, topicElement);

			} else {

				if ((skill.getTopic().getClassificationTopic().getMainClassification().getId() != skills.get(i - 1).getTopic().getClassificationTopic().getMainClassification().getId())) {
					Element mainClassificationElement = createEmptyChildNode("mainClassification", doc, root);
					createChildNode("description", mDescription, doc, mainClassificationElement);

					classificationTopicsElement = createEmptyChildNode("classificationTopics", doc, mainClassificationElement);
					Element classificationTopicElement = createEmptyChildNode("classificationTopic", doc, classificationTopicsElement);
					createChildNode("description", ctopicDescription, doc, classificationTopicElement);

					topicsElement = createEmptyChildNode("topics", doc, classificationTopicElement);
					Element topicElement = createEmptyChildNode("topic", doc, topicsElement);
					createChildNode("description", topicDescription, doc, topicElement);
					skillsElement = createEmptyChildNode("skills", doc, topicElement);
				}

				else if ((skill.getTopic().getClassificationTopic().getId() != skills.get(i - 1).getTopic().getClassificationTopic().getId())) {
					if (!skill.getTopic().getClassificationTopic().getDescription().equals("Blank")) {

						Element classificationTopicElement = createEmptyChildNode("classificationTopic", doc, classificationTopicsElement);
						createChildNode("description", ctopicDescription, doc, classificationTopicElement);

						topicsElement = createEmptyChildNode("topics", doc, classificationTopicElement);
						Element topicElement = createEmptyChildNode("topic", doc, topicsElement);
						createChildNode("description", topicDescription, doc, topicElement);
						skillsElement = createEmptyChildNode("skills", doc, topicElement);
					}
				}

				else if ((skill.getTopic().getId() != skills.get(i - 1).getTopic().getId())) {

					Element topicElement = createEmptyChildNode("topic", doc, topicsElement);
					createChildNode("description", topicDescription, doc, topicElement);
					skillsElement = createEmptyChildNode("skills", doc, topicElement);

				}
			}

			Element skillElement = createEmptyChildNode("skill", doc, skillsElement);
			createChildNode("description", skill.getDescription(), doc, skillElement);

			String ctopicShortCut = "";
			String mainClassificationShortcut = "";
			if (skill.getTopic().getClassificationTopic().getShortcut() != null) {
				ctopicShortCut = skill.getTopic().getClassificationTopic().getShortcut();
			}

			if (skill.getTopic().getClassificationTopic().getMainClassification().getShortcut() != null) {
				mainClassificationShortcut = skill.getTopic().getClassificationTopic().getMainClassification().getShortcut();
			}

			createChildNode("shortcut", mainClassificationShortcut + " " + ctopicShortCut + " " + skill.getShortcut(), doc, skillElement);

			if (skill.getSkillLevel() != null) {
				createChildNode("skillLevel", skill.getSkillLevel().getLevelNumber().toString(), doc, skillElement);
			} else {
				createChildNode("skillLevel", "-", doc, skillElement);
			}

			Integer levelNum = Skill.findSkillLevelAcquired(studentId, skill.getId());
			if (levelNum != null) {
				createChildNode("skillLevelAcquired", levelNum.toString(), doc, skillElement);
			} else {
				createChildNode("skillLevelAcquired", "-", doc, skillElement);
			}
		}

		return saveXML(doc);
	}

	public String saveXML(Document doc) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);
			String xmlString = sw.toString();

			String path = getServletConfig().getServletContext().getRealPath("/logbook/gwt/logbook/");
			String fileName = path + "/" + System.currentTimeMillis() + ".xml";
			logger.debug("Path: " + fileName);

			File file = new File(fileName);
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));

			bw.write(xmlString);
			bw.flush();
			bw.close();

			String htmlFileName = convertXmlToHtml(fileName);

			return htmlFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String convertXmlToHtml(String fileName) {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			String xslPath = getServletConfig().getServletContext().getRealPath("/logbook/gwt/logbook/skill.xsl");
			Source xslDoc = new StreamSource(xslPath);
			Source xmlDoc = new StreamSource(fileName);

			String path = getServletConfig().getServletContext().getRealPath("/logbook/gwt/logbook/");
			String outputFileName = path + "/" + System.currentTimeMillis() + ".html";
			logger.debug("Path: " + outputFileName);
			OutputStream htmlFile = new FileOutputStream(outputFileName);

			Transformer transformer = tFactory.newTransformer(xslDoc);
			transformer.setErrorListener(new ErrorListener() {

				@Override
				public void warning(TransformerException exception) throws TransformerException {
					logger.error("Warning", exception);
				}

				@Override
				public void fatalError(TransformerException exception) throws TransformerException {
					logger.error("fatal Error.", exception);
				}

				@Override
				public void error(TransformerException exception) throws TransformerException {
					logger.error("Error", exception);
				}
			});
			transformer.transform(xmlDoc, new StreamResult(htmlFile));
			htmlFile.close();
			File xmlFile = new File(fileName);
			xmlFile.delete();
			return outputFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void createPDF(OutputStream os, String htmlFileName) {
		logger.debug("url : " + htmlFileName);

		try {
			ITextRenderer renderer = new ITextRenderer();
			logger.debug("Skill PDF Export->Create PDF->File name: " + htmlFileName);
			renderer.setDocument(new File(htmlFileName));
			renderer.layout();
			renderer.createPDF(os);
			os.close();
		} catch (Exception e) {
			logger.error("Error in SkillPdfExport", e);
		}
	}
}
