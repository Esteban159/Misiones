package mision_1;

public class Prestamo {
	private Integer numero_cuota;
	private Float valor_cuota[]=new Float[48];
	private Float amortizacion;
	private Float interes_anual;
	private Float interes_mensual;
	private Float valor;
	private Integer meses;
	
	public Integer getMeses() {
		return meses;
	}
	public void setMeses(Integer meses) {
		this.meses = meses;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Prestamo(){
		
	}
	public Integer getNumero_cuota() {
        return numero_cuota;
    }

    public void setNumero_cuota(Integer numero_cuota) {
        this.numero_cuota = numero_cuota;
    }

    public Float[] getValor_cuota() {
        return valor_cuota;
    }

    public void setValor_cuota(Float[] valor_cuota) {
        this.valor_cuota = valor_cuota;
    }

    public Float getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(Float amortizacion) {
        this.amortizacion = amortizacion;
    }

    public Float getInteres_anual() {
        return interes_anual;
    }

    public void setInteres_anual(Float interes_anual) {
        this.interes_anual = interes_anual;
    }

    public Float getInteres_mensual() {
        return interes_mensual;
    }

    public void setInteres_mensual(Float interes_mensual) {
        this.interes_mensual = interes_mensual;
    }
    
    public void calculo_tasa(){
    	double r,k;
    	r=((double) getInteres_anual())+1;
    	k=1/12.0; 
    	r=Math.pow(r,k)-1;
    	//System.out.println(Math.pow(r,k));
    	this.setInteres_mensual((float) r);
    }
    
    public void calculo_amortizacion(){
    	double pago;
    	double t,k,m;
    	t=(-1)*meses;
    	m=1+(this.interes_mensual);
    	k=Math.pow(m, t);
    	pago=(interes_mensual*valor)/(1-k);
    	this.setAmortizacion((float)pago);
    }
    
    public void calculo_cuota_mensual(){ 	
    	for(int i=0;i<this.meses;i++){
    		if(i==0){
    			this.valor_cuota[i]=((this.valor)-(this.amortizacion));
    		}
    		else{
    			valor_cuota[i]=valor_cuota[i-1]*(1+this.interes_mensual)-amortizacion;
    		}
    		
    	}
    }

}
