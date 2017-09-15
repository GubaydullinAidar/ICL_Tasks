package ru.ICLTask;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.*;
import java.util.*;

public class FreeMarkerGenrateXMLFromObject {
	
	private static Configuration cfg = null;
	
	static{		
		// Freemarker below configuration object deprecated
		//Configuration cfg = new Configuration();
		//Please use this. To make it backward compatible. Please visit here for more info: 
		//http://freemarker.org/docs/api/freemarker/template/Configuration.html
		cfg = new Configuration(new Version("2.3.0"));
	}
	
	public static void main(String[] args) {

		try {
			// Load template
			Template template = cfg.getTemplate("src/main/resources/BuildXMLTemplate.ftl");

			// Create data for template
			Map<String, Object> templateData = new HashMap<String, Object>();
			templateData.put("name", "Java Freemarker");
			
			List<Author> authors = Arrays.asList(
					new Author( "Ivan", "Petrov", "ivan@r.ru" ),
					new Author( "Ivan", "Petrov", "ivan@r.ru" ),
					new Author( "Petr","Ivanov", "petr@r.ru" ) );

			Scanner scanner = new Scanner(System.in);
			System.out.println("Введите количество xml-файлов:");
			Integer num = scanner.nextInt();

			for (int i = 0; i < num; i++) {

			}

			templateData.put("authorDetails", authors[Math.random() * authors.size()]);

			// Write output on console example 1
			StringWriter out = new StringWriter();
			template.process(templateData, out);
			System.out.println( out.getBuffer().toString() );
			out.flush();
			
			// Write output on console example 2
			/*Writer out = new OutputStreamWriter(System.out);
			template.process(templateData, out);
			out.flush();*/

			// Write data to the file
			Writer file = new FileWriter(new File("C:\\Java\\ICL_Tasks\\BuildXMLTemplateXML.xml"));
			template.process(templateData, file);
			file.flush();
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
