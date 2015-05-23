package mision_2;
import java.util.*;

public class Vendedor {
	private String nombre;
	private List <Double> ventas=new ArrayList<Double>();
	private Double bono_ventas;
	private Double bono_monto;
	private Double bono_total;
	
	public Vendedor(){
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getBono_ventas() {
		return bono_ventas;
	}
	public void setBono_ventas(Double bono_ventas) {
		this.bono_ventas = bono_ventas;
	}
	public Double getBono_monto() {
		return bono_monto;
	}
	public void setBono_monto(Double bono_monto) {
		this.bono_monto = bono_monto;
	}
	public Double getBono_total() {
		return bono_total;
	}
	public void setBono_total(Double bono_total) {
		this.bono_total = bono_total;
	}
	public List<Double> getVentas() {
		return ventas;
	}
	public void setVentas(List<Double> ventas) {
		this.ventas = ventas;
	}
	
	public void calculo_bono_ventas(){
		if(this.ventas.size()>=30 && this.ventas.size()<=40){
			this.setBono_ventas(20.0);
		}
		else if (this.ventas.size()>40 && this.ventas.size()<100) {
			this.setBono_ventas(50.0);
		}
		else if(this.ventas.size()>=100){
			this.setBono_ventas(100.0);
		}
		else{
			this.setBono_ventas(0.0);
		}
	}
	
	public void calculo_bono_monto(){
		Double suma;
		suma=0.0;
		for(int i=0;i<this.ventas.size();i++){
			if(this.ventas.get(i)>500 && this.ventas.get(i)<=1000){
				suma=suma+this.ventas.get(i)*(0.03)*(0.81);
			}
			else if(this.ventas.get(i)>1000 && this.ventas.get(i)<=1500){
				suma=suma+this.ventas.get(i)*(0.05)*(0.81);
			}
			else if(this.ventas.get(i)>1500){
				suma=suma+this.ventas.get(i)*(0.07)*(0.81);
			}
			else{
				suma=suma+0;
			}
		}
		this.setBono_monto(suma);	
	}
	
	public void calculo_bono_total(){
		this.setBono_total(this.bono_ventas+this.bono_monto);
	}

}
