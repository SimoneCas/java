package it.simone.esempio.di;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BeanConfiguration.class)
public class AppDITest {
	
	@Autowired
	LettoreMultimediale lettore;
	
	@Autowired 
	SupportoMultimediale supporto;
	
	@Test
	public void testPlay() {
		SupportoMultimediale supporto =mock(SupportoMultimediale.class);
		LettoreMultimediale lettore=new LettoreMultimediale(supporto);
		when(supporto.play()).thenReturn("###DVD###");
		//verify(mockQuest,times(1)).embark();
		assertTrue( lettore.play().equals("NEW") );
	}
	
	@Test
	public void testPlayBean(){
		
		String result = lettore.play();
		
		if (supporto instanceof Vhs){
			assertEquals(result, "OLD");
		} else {
			assertEquals(result, "NEW");
		}
			
	}
}
