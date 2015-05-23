package mision_1;
import org.apache.poi.hssf.usermodel.*;
import java.io.*;

public class Operaciones {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prestamo a=new Prestamo();
		Integer j=2;
		Float[] temp=new Float[48];
		a.setNumero_cuota(1200);
		a.setValor(15000.00f);
		a.setInteres_anual(0.36f);
		a.calculo_tasa();
		a.setMeses(24);
		a.calculo_amortizacion();
		a.calculo_cuota_mensual();
		HSSFWorkbook libro=new HSSFWorkbook();
		HSSFSheet hoja1=libro.createSheet("Hoja de prueba");
		HSSFRow fila=hoja1.createRow(j);
		HSSFCell celda=fila.createCell(1);
		HSSFRichTextString texto=new HSSFRichTextString("Numero de cuota");
		celda.setCellValue(texto);
		celda=fila.createCell(2);
		texto=new HSSFRichTextString("Amortizacion");
		celda.setCellValue(texto);
		celda=fila.createCell(3);
		texto=new HSSFRichTextString("Interes mensual");
		celda.setCellValue(texto);
		for(int i=4;i<52;i++){
			celda=fila.createCell(i);
			texto=new HSSFRichTextString("Cuota Mes"+(i-3));
			celda.setCellValue(texto);
		}
		temp=a.getValor_cuota();
		j=j+1;
		fila=hoja1.createRow(j);
		celda=fila.createCell(1);
		texto=new HSSFRichTextString(String.valueOf(a.getNumero_cuota()));
		celda.setCellValue(texto);
		celda=fila.createCell(2);
		texto=new HSSFRichTextString(String.valueOf(a.getAmortizacion()));
		celda.setCellValue(texto);
		celda=fila.createCell(3);
		texto=new HSSFRichTextString(String.valueOf(a.getInteres_mensual()));
		celda.setCellValue(texto);
		for(int i=0;i<a.getMeses();i++){
			celda=fila.createCell(i+4);	
			texto=new HSSFRichTextString(String.valueOf(temp[i]));
			celda.setCellValue(texto);
		}
		j=j+1;
		a.setMeses(36);
		a.calculo_amortizacion();
		a.calculo_cuota_mensual();
		fila=hoja1.createRow(j);
		temp=a.getValor_cuota();
		celda=fila.createCell(1);
		texto=new HSSFRichTextString(String.valueOf(a.getNumero_cuota()));
		celda.setCellValue(texto);
		celda=fila.createCell(2);
		texto=new HSSFRichTextString(String.valueOf(a.getAmortizacion()));
		celda.setCellValue(texto);
		celda=fila.createCell(3);
		texto=new HSSFRichTextString(String.valueOf(a.getInteres_mensual()));
		celda.setCellValue(texto);
		for(int i=0;i<a.getMeses();i++){
			celda=fila.createCell(i+4);	
			texto=new HSSFRichTextString(String.valueOf(temp[i]));
			celda.setCellValue(texto);
		}
		j=j+1;
		a.setMeses(48);
		a.calculo_amortizacion();
		a.calculo_cuota_mensual();
		fila=hoja1.createRow(j);
		temp=a.getValor_cuota();
		celda=fila.createCell(1);
		texto=new HSSFRichTextString(String.valueOf(a.getNumero_cuota()));
		celda.setCellValue(texto);
		celda=fila.createCell(2);
		texto=new HSSFRichTextString(String.valueOf(a.getAmortizacion()));
		celda.setCellValue(texto);
		celda=fila.createCell(3);
		texto=new HSSFRichTextString(String.valueOf(a.getInteres_mensual()));
		celda.setCellValue(texto);
		for(int i=0;i<a.getMeses();i++){
			celda=fila.createCell(i+4);	
			texto=new HSSFRichTextString(String.valueOf(temp[i]));
			celda.setCellValue(texto);
		}
		for(int i=0;i<(48+3);i++){
			hoja1.autoSizeColumn(i+1);
		}
		try{
			FileOutputStream arch=new FileOutputStream("Mision_1.xls");
			libro.write(arch);
			arch.close();
			libro.close();
		}
		catch(Exception e){
			System.out.println("No esta bien");		
		}
	}
}
