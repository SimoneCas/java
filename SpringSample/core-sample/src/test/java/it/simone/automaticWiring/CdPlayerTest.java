package it.simone.automaticWiring;

import static org.junit.Assert.*;
import it.simone.automaticWiring.CompactDisk;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CdPlayerConfig.class)
public class CdPlayerTest {
	
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();
	
	@Autowired
	private CompactDisk cd;
	
	@Autowired
	private CdPlayer player;
	
	@Test
	public void cdShouldNotBeNull(){
		assertNotNull(cd);
	}
	
	@Test
	public void play(){
		player.play();
		assertEquals(
				"Playing Sgt. Pepper's Lonely Hearts Club Band" +
				" by The Beatles\n",
				log.getLog());
		
	}

}
