package com.mail.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import archivohandler.ManejadorDeArchivos;
import archivohandler.MdaException;
import permutador.Permutador;

@SpringBootApplication
public class MailApiApplication {

	public static void main(String[] args) throws MdaException, DocumentException, FileNotFoundException {
		
		Permutador perm = new Permutador();
		perm.permutation("Hola");
		//ManejadorDeArchivos mda = new ManejadorDeArchivos();
		//mda.guardarArchivo("c:/keys/datos.txt", perm.getPerm());
		
		Document doc = new Document();
		FileOutputStream ficheroPdf = new FileOutputStream("c:/keys/fichero.pdf");
		PdfWriter.getInstance(doc,ficheroPdf).setInitialLeading(20);
		doc.open();
		for (String p : perm.getPerm()) {
			doc.add(new Paragraph(p));
		}
		doc.close();
		
		SpringApplication.run(MailApiApplication.class, args);
	}
}