package my.learning.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import my.learning.test.MagicNumberExample;

public class MagicNumberExampleTest {

	@Test
	public void test() {
		MagicNumberExample mne = new MagicNumberExample();
		assertTrue(mne.isMagicNumber(163));
		assertFalse(mne.isMagicNumber(164));
	}

}
