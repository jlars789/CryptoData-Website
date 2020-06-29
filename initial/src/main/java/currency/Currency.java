package currency;

import java.util.ArrayList;

public class Currency {
	
	public static final int SIZE = 256;
	public static final int DER_SIZE = 24;
	public static final double MULTIPLIER = (2 / (10 + 1) );
	private String code;
	
	private double sma;
	
	private ArrayList<Double> values; 
	private ArrayList<Double> changes;
	
	private double ema24;
	private double ema48;
	private double rsi;
	
	private double deviation;
	
	public Currency(String code) {
		this.code = code;
		this.values = new ArrayList<Double>();
		this.changes = new ArrayList<Double>();
	}
	
	public void init() {
		calculateSMA();
		int size = values.size();
		this.ema24 = ((values.get(size-13) - sma) * getMult(12)) + values.get(size-13);
		this.ema48 = ((values.get(size-25) - sma) * getMult(24)) + values.get(size-25);
		for(int i = size-12; i < values.size(); i++) {
			double em = this.ema24;
			this.ema24 = ((values.get(i) - em) * getMult(12)) + values.get(i);
		}
		for(int i = size-24; i < values.size(); i++) {
			double em = this.ema48;
			this.ema48 = ((values.get(i) - em) * getMult(24)) + values.get(i);
		}
		this.rsi = 100 - (100 / (1 + (getAverageGains(0, changes.size())/getAverageLoss(0,changes.size())))); 
		
		double sum = 0;
		for(int i = size-DER_SIZE; i < size; i++) {
			sum+=values.get(i);
		}
		double avg = sum/DER_SIZE;
		sum = 0;
		for(int i = size-DER_SIZE; i < size; i++) {
			sum += Math.pow((values.get(i) - avg), 2);
		}
		deviation = Math.sqrt(sum/DER_SIZE);
	}
	
	public void initializeDataEntry(double data) {
		Double val = null;
		if(values.size() > 0){
			val = values.get(values.size()-1);
			addChange(data-val);
		}
		addValue(data);
	}
	
	private void calculateSMA() {
		Double sum = new Double("0.0");
		for(int i = 0; i < 10; i++) {
			sum += values.get(i);
		}
		this.sma = (sum/10);
	}
	
	public void updateData(Double data) {
		Double val = null;
		if(values.size() > 0){
			val = values.get(values.size()-1);
		}
		addChange(data-val);
		addValue(data);
		updateRSI();
		updateEMA(data);
	}
	
	public void updateTempData(Double data) {
		values.add(data);
		Double val = null;
		if(values.size() > 0){
			val = values.get(values.size()-1);
		}
		changes.add(data-val);
		updateRSI();
		updateEMA(data);
		values.remove(values.size()-1);
		changes.remove(changes.size()-1);
		
	}
	
	private void updateRSI() {
		this.rsi = 100 - (100 / (1 + (getAverageGains(0, changes.size())/getAverageLoss(0,changes.size()))));
	}
	
	private void updateEMA(double data) {
		calculateSMA();
		int size = values.size();
		this.ema24 = ((values.get(size-13) - sma) * getMult(12)) + values.get(size-13);
		this.ema48 = ((values.get(size-25) - sma) * getMult(24)) + values.get(size-25);
		for(int i = size-12; i < values.size(); i++) {
			double em = this.ema24;
			this.ema24 = ((values.get(i) - em) * getMult(12)) + values.get(i);
		}
		for(int i = size-24; i < values.size(); i++) {
			double em = this.ema48;
			this.ema48 = ((values.get(i) - em) * getMult(24)) + values.get(i);
		}
		
		double sum = 0;
		for(int i = size-DER_SIZE; i < size; i++) {
			sum+=values.get(i);
		}
		double avg = sum/DER_SIZE;
		sum = 0;
		for(int i = size-DER_SIZE; i < size; i++) {
			sum += Math.pow((values.get(i) - avg), 2);
		}
		this.deviation = Math.sqrt(sum/DER_SIZE);
	}
	
	private void addValue(Double data) {
		
		values.add(data);
		if(values.size() > SIZE) {
			values.remove(0);
		}
	}
	
	private void addChange(Double change) {
		changes.add(change);
		if(changes.size() > DER_SIZE) {
			changes.remove(0);
		}
	}
	
	public String getCode() {
		return this.code;
	}
	
	public boolean isBullish() {
		//System.out.println(this.code + " 12: " + ema24 + " 24: " + ema48);
		return (this.ema24 > this.ema48);
	}
	
	public Double getRSI() {
		return this.rsi;
	}
	
	public double getDeviation() {
		return this.deviation;
	}
	
	public double getDevPer() {
		return (this.deviation/this.ema24) * 100;
	}
	
	private Double getAverageLoss(int start, int end) {
		ArrayList<Double> loss = getLosses(start, end);
		Double sum = new Double("0.0");
		for(int i = 0; i < loss.size(); i++) {
			sum += Math.abs(loss.get(i));
		}
		
		return sum/loss.size();
	}
	
	private Double getAverageGains(int start, int end) {
		ArrayList<Double> gain = getGains(start, end);
		Double sum = new Double("0.0");
		for(int i = 0; i < gain.size(); i++) {
			sum += gain.get(i);
		}
		
		return sum/gain.size();
	}
	
	private ArrayList<Double> getLosses(){
		ArrayList<Double> loss = new ArrayList<Double>();
		for(int i = 0; i < changes.size(); i++) {
			if(changes.get(i) < 0) loss.add(changes.get(i));
		}
		
		return loss;
	}
	
	private ArrayList<Double> getGains(){
		ArrayList<Double> gain = new ArrayList<Double>();
		for(int i = 0; i < changes.size(); i++) {
			if(changes.get(i) >= 0) gain.add(changes.get(i));
		}
		
		return gain;
	}
	
	private ArrayList<Double> getLosses(int start, int end){
		ArrayList<Double> loss = new ArrayList<Double>();
		for(int i = start; i < end; i++) {
			if(changes.get(i) < 0) loss.add(changes.get(i));
		}
		
		return loss;
	}
	
	private ArrayList<Double> getGains(int start, int end){
		ArrayList<Double> gain = new ArrayList<Double>();
		for(int i = start; i < end; i++) {
			if(changes.get(i) >= 0) gain.add(changes.get(i));
		}
		
		return gain;
	}
	
	private static double getMult(int periods) {
		return (double)(2 / (double)(periods + 1));
	}
	
}
