package no.hvl.dat102.kjedet;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class KjedetKoeTest extends TestKoeADT {
	@Override
		protected KoeADT<Integer> reset() {
			return new KjedetKoe<Integer>();
		}
	
}
