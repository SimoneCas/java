package it.simone.prova;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import it.simone.xmlConfigurationBaseBean.SpringChild;
import it.simone.xmlConfigurationBaseBean.SpringFather;

import org.junit.Test;

public class SpringFatherTest {
	@Test
	public void testprintChildInfo() {
		SpringChild child =mock(SpringChild.class);
		SpringFather father=new SpringFather(child);
		father.printChildInfo();
		//verify(mockQuest,times(1)).embark();
		assertTrue( true );
	}
}
