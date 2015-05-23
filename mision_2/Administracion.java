package mision_2;
import java.io.FileOutputStream;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Administracion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vendedor a[]=new Vendedor[5];
		Integer j=2;
		String c;
		List <Double> temp=new ArrayList<Double>();
		Scanner entrada=new Scanner(System.in);
		Scanner entrada2=new Scanner(System.in);
		System.out.println("Ingrese los datos de los vendedores");
		for(int i=0;i<5;i++){
			System.out.println("Vendedor"+ (i+1));
			a[i]=new Vendedor();
			c=entrada.next();
			a[i].setNombre(c);
			System.out.println(" Ingrese cantidad de ventas a registrar");
			j=entrada.nextInt();
			for(Integer k=0;k<j;k++){
				temp.add(entrada2.nextDouble());				
			}	
			a[i].setVentas(temp);
			a[i].calculo_bono_monto();
			a[i].calculo_bono_ventas();
			a[i].calculo_bono_total();
		}
		
		for(int i=0;i<5;i++){
			System.out.println(a[i].getNombre());
			System.out.println(a[i].getBono_ventas());
			System.out.println(a[i].getBono_monto());
			System.out.println(a[i].getBono_total());
			System.out.println("   ");
		}
		HSSFWorkbook cuaderno=new HSSFWorkbook();
		HSSFSheet pagina=cuaderno.createSheet("Administracion");
		HSSFRow fila=pagina.createRow(0);
		HSSFCell celda=fila.createCell(j+1);
		HSSFRichTextString texto=new HSSFRichTextString("NOMBRE");
		celda.setCellValue(texto);
		celda=fila.createCell(j+2);
		texto=new HSSFRichTextString("Bono por Monto");
		celda.setCellValue(texto);
		celda=fila.createCell(j+3);
		texto=new HSSFRichTextString("Bono por Ventas");
		celda.setCellValue(texto);
		celda=fila.createCell(j+4);
		texto=new HSSFRichTextString("Bono total");
		celda.setCellValue(texto);
		
		for(int i=1;i<=5;i++){	
			fila=pagina.createRow(i);
			celda=fila.createCell(j+1);
			texto=new HSSFRichTextString(a[i-1].getNombre());
			celda.setCellValue(texto);
			celda=fila.createCell(j+2);
			texto=new HSSFRichTextString(String.valueOf(a[i-1].getBono_monto()));
			celda.setCellValue(texto);
			celda=fila.createCell(j+3);
			texto=new HSSFRichTextString(String.valueOf(a[i-1].getBono_ventas()));
			celda.setCellValue(texto);
			celda=fila.createCell(j+4);
			texto=new HSSFRichTextString(String.valueOf(a[i-1].getBono_total()));
			celda.setCellValue(texto);
		}
		for(int i=2;i<=6;i++){
			pagina.autoSizeColumn(i+1);
		}
		try{
			FileOutputStream arch=new FileOutputStream("Mision_2.xls");
			cuaderno.write(arch);
			arch.close();
			cuaderno.close();
		}
		catch(Exception e){
			System.out.println("No esta bien");	
		}	
	}

}
