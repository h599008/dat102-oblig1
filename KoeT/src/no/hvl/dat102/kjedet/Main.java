package no.hvl.dat102.kjedet;

public class Main {
	
	private static Integer a = 1;
	private static Integer b = 2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KjedetKoe<Integer> koe = new KjedetKoe();
		koe.innKoe(a);
		koe.innKoe(b);
		System.out.print(koe.toString());
	}

}
