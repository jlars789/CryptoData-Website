package database;

import java.io.Serializable;
import java.text.DecimalFormat;

public class DBInstanceWrapper implements Serializable {

	private static final long serialVersionUID = 3019912395064861089L;
	private static final DecimalFormat df2 = new DecimalFormat("#0.##");
	private static final DecimalFormat df5 = new DecimalFormat("#0.###");

	public DBInstanceWrapper() {
		
	}
	
	public double[] getRSI() {
		double[] arr = new double[DBRunner.currency.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Double.parseDouble(df2.format(DBRunner.currency[i].getRSI()));
		}
		return arr;
	}
	
	public String[] getEMA() {
		String[] arr = new String[DBRunner.currency.length];
		for(int i = 0; i < arr.length; i++) {
			if(DBRunner.currency[i].isBullish()) arr[i] = "Bullish";
			else arr[i] = "Bearish";
		}
		return arr;
	}
	
	public double[] getDeviation() {
		double[] arr = new double[DBRunner.currency.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Double.parseDouble(df5.format(DBRunner.currency[i].getDevPer()));
		}
		return arr;
	}

}
