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
		/* Hier auf Grund der vorhanden Werte entscheiden
		 * welche Methode unten aufgerufen werden muss.
		 */
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
