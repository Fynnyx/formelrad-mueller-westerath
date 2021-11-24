package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}

	public void setLeistung(double leistung) {
		this.leistung = leistung;
	}

	public void setSpannung(double spannung) {
		this.spannung = spannung;
	}

	public void setStrom(double strom) {
		this.strom = strom;
	}

	public void setWiderstand(double widerstand) {
		this.widerstand = widerstand;
	}

	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		int empty = 0;

		if (getLeistung() > 0){
			empty = empty + 1;
		}
		if(getSpannung() > 0){
			empty = empty + 1;
		}
		if(getStrom() > 0){
			empty = empty + 1;
		}
		if(getWiderstand() > 0){
			empty = empty + 1;
		}
		if(empty > 2){
			System.out.println("Warning! More than 2 inputs!");
		}
		double result;

		if (getSpannung() > 0 && getStrom() > 0) {
			this.leistung = PAusUundI(getSpannung(), getStrom());
			this.widerstand = RAusUundI(getSpannung(), getStrom());

		} else if (getSpannung() > 0 && getWiderstand() > 0) {
			this.leistung = PAusUundR(getSpannung(), getWiderstand());
			this.strom = IAusUundR(getSpannung(), getWiderstand());

		} else if (getSpannung() > 0 && getLeistung() > 0){
			this.widerstand = RAusUundP(getSpannung(), getLeistung());
			this.strom = IAusPundU(getLeistung(), getSpannung());

		} else if (getWiderstand() > 0 && getStrom() > 0) {
			this.leistung = PAusRundI(getWiderstand(), getStrom());
			this.spannung = UAusRundI(getWiderstand(), getStrom());

		} else if (getLeistung() > 0 && getStrom() > 0) {
			this.spannung = UAusPundI(getLeistung(), getStrom());
			this.widerstand = RAusPundI(getLeistung(), getStrom());

		} else if (getLeistung() > 0 && getWiderstand() > 0) {
			this.spannung = UAusPundR(getLeistung(), getWiderstand());
			this.strom = IAusPundR(getLeistung(), getWiderstand());
		} else {
			System.out.println("Something went wrong");
		}
	}

	public double PAusUundI (double u, double i) {
		System.out.println("Called PAusUundI");
		return u*i;
	}

	public double PAusUundR (double u, double r) {
		System.out.println("Called PAusUundR");
		return (u*u)/r;
	}

	public double PAusRundI (double r, double i) {
		System.out.println("Called PAusRundI");
		return r*i*i;
	}

	public double UAusRundI (double r, double i) {
		System.out.println("Called UAusRundI");
		return r*i;
	}

	public double UAusPundI (double p, double i) {
		System.out.println("Called UAusPundI");
		return p/i;
	}

	public double UAusPundR (double p, double r) {
		System.out.println("Called UAusPundR");
		return Math.sqrt(p*r);
	}


	public double IAusUundR (double u, double r){
		System.out.println("Called IAusUundR");
		return u/r;
	}

	public double IAusPundU (double p, double u){
		System.out.println("Called IAusPundU");
		return p/u;
	}

	public double IAusPundR (double p, double r){
		System.out.println("Called IAusPundR");
		return Math.sqrt(p/r);
	}


	public double RAusUundI (double u, double i){
		System.out.println("Called RAusUundI");
		return u/i;
	}

	public double RAusPundI (double p, double i){
		System.out.println("Called RAusPundI");
		return p/(i*i);
	}

	public double RAusUundP (double u, double p){
		System.out.println("Called RAusUundP");
		return (u*u)/p;
	}
}
