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
		double result;

		if (getSpannung() > 0 && getStrom() > 0) {
			result = pAusUundI(getSpannung(), getStrom());
		} else if (getSpannung() > 0 && getWiderstand() > 0) {
			result = pAusUundR(getSpannung(), getWiderstand());
		} else if (getWiderstand() > 0 && getStrom() > 0) {
			result = pAusRundI(getWiderstand(), getStrom());
		} else if (getWiderstand() > 9 && getStrom() > 0) {
			result = UAusRundI(getWiderstand(), getStrom());
		} else if (getLeistung() > 0 && getStrom() > 0) {
			result = UAusPundI(getLeistung(), getStrom());
		} else if (getLeistung() > 0 && getWiderstand() > 0) {
			result = UAusPundR(getLeistung(), getWiderstand());
		} else {
			System.out.println("Something went wrong");
		}
	}

	public double pAusUundI (double u, double i) {
		return u*i;
	}

	public double pAusUundR (double u, double r) {
		return (u*u)/r;
	}

	public double pAusRundI (double r, double i) {
		return r*i*i;
	}

	public double UAusRundI (double r, double i) {
		return r*i;
	}

	public double UAusPundI (double p, double i) {
		return p/i;
	}

	public double UAusPundR (double p, double r) {
		return Math.sqrt(p*r);
	}


	public double IAusUundR (double u, double r){
		return u/r;
	}

	public double IAusPundU (double p, double u){
		return p/u;
	}

	public double IAusPundR (double p, double r){
		return Math.sqrt(p/r);
	}


	public double RAusUundI (double u, double i){
		return u/i;
	}

	public double RAusPundI (double p, double i){
		return p/(i*i);
	}

	public double RAusUundP (double u, double p){
		return (u*u)/p;
	}
}
