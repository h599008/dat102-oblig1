package no.hvl.dat102.adt;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.kjedet.KjedetKoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public abstract class TestKoeADT {
	
	private KoeADT<Integer> koe;
	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	
	protected abstract KoeADT<Integer> reset();

	
	@BeforeEach
	public void setUp() {
		// Setter alltid koe til en tom kø før hver test.
		koe = new KjedetKoe<Integer>();
	}
	
	@Test
	public void testErTom() {
		assertTrue(koe.erTom());
	}
	
	@Test
	public void testInn() {
		koe.innKoe(e0);
		assertTrue(koe.foerste() == e0);
		assertFalse(koe.erTom());

	}
	
	@Test
	public void testFoerste() {	
		koe.innKoe(e1);
		assertEquals(koe.foerste(), e1);
	}
	
	
	@Test
	public void testUtKoe() {
		koe.innKoe(e2);
		assertEquals(koe.utKoe(), e2);
	}

	@Test
	public void testToString() {
		
		//assertEquals();
	}

}