package com.mitocode.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/archivo")
public class ArchivoServlet extends HttpServlet {

	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpg");
		
		//Con la siguiente linea se especifica que la salida es un adjunto por tanto se descargará la imagen, sino se especifica se visualziará la imagen en el browser
		resp.setHeader("Content-Disposition", "attachment; filename=\"nombreImagen.jpg\"");
		
		ServletOutputStream out = resp.getOutputStream();
		
		//Es necesario crear la carpeta /resources/image y colocar el archivo. Esto en src/main/webapp
		String ruta = "/resources/image/imagen.jpg";//esta imagen se coloca a la altura de la carpeta webapp, dado que es lo que está visible al proyecto
		InputStream in = getServletContext().getResourceAsStream(ruta);
		
		//Los buffered son clases que permiten leer y escribir en bloque, para no estar haciendolo byte a byte
		BufferedInputStream bin = new BufferedInputStream(in);//Canal que va leyendo la imagen
		BufferedOutputStream bout = new BufferedOutputStream(out);//canal que va escribiendo en la imagen
		
		int ch = 0;
		
		while((ch = bin.read()) != -1) {//lee en bloques hasta que no haya más que leer
			bout.write(ch);
		}
		
		//cerramos para liberar recursos y que no se sature el ancho de banda
		bin.close();
		in.close();
		bout.close();
		out.close();
	}
	*/
	
	//descargar PDF
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/pdf");
		
		//Con la siguiente linea se especifica que la salida es un adjunto por tanto se descargará el pdf, sino se especifica se visualziará el PDF en el browser
		resp.setHeader("Content-Disposition", "attachment; filename=\"nombrePdf.pdf\"");		
		
		ServletOutputStream out = resp.getOutputStream();
		
		//Es necesario crear la carpeta /resources/image y colocar el archivo. Esto en src/main/webapp
		String ruta = "/resources/pdf/servlets.pdf";//esta imagen se coloca a la altura de la carpeta webapp, dado que es lo que está visible al proyecto
		InputStream in = getServletContext().getResourceAsStream(ruta);
		
		//Los buffered son clases que permiten leer y escribir en bloque, para no estar haciendolo byte a byte
		BufferedInputStream bin = new BufferedInputStream(in);//Canal que va leyendo la imagen
		BufferedOutputStream bout = new BufferedOutputStream(out);//canal que va escribiendo en la imagen
		
		int ch = 0;
		
		while((ch = bin.read()) != -1) {//lee en bloques hasta que no haya más que leer
			bout.write(ch);
		}
		
		//cerramos para liberar recursos y que no se sature el ancho de banda
		bin.close();
		in.close();
		bout.close();
		out.close();
	}

	
	
}
