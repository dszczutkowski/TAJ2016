package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Mp3PlayerImpl;
import com.Mp3Player;

import java.util.ArrayList;

public class Mp3PlayerTest {
	private Mp3Player mp3;
	private ArrayList<String> list = new ArrayList<String>();

	private static final double delta = 0;

	@Before
	public void setUp() {
		mp3 = new Mp3PlayerImpl();
		list = new ArrayList<String>();
		list.add("Bill Chase -- Open Up Wide");
		list.add("Jethro Tull -- Locomotive Breath");
		list.add("The Boomtown Rats -- Monday");
		list.add("Carl Orff -- O Fortuna");
	}

	@Test
	public void testPlay() {
		mp3.loadSongs(list);
		assertNotNull(mp3.currentSong());

		mp3.play();
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(1, mp3.currentPosition(), delta);
		assertTrue(mp3.isPlaying());

		mp3.pause();
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(1, mp3.currentPosition(), delta);
		assertFalse(mp3.isPlaying());

		mp3.stop();
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(0, mp3.currentPosition(), delta);
		assertFalse(mp3.isPlaying());
	}

	@Test
	public void testPlayNoList() {

		assertNull(mp3.currentSong());

		mp3.play();
		assertNull(mp3.currentSong());
		assertEquals(0, mp3.currentPosition(), delta);
		assertFalse(mp3.isPlaying());

		mp3.pause();
		assertNull(mp3.currentSong());
		assertEquals(0, mp3.currentPosition(), delta);
		assertFalse(mp3.isPlaying());

		mp3.stop();
		assertNull(mp3.currentSong());
		assertEquals(0, mp3.currentPosition(), delta);
		assertFalse(mp3.isPlaying());
	}

	@Test
	public void testAdvance() {
		mp3.loadSongs(list);
		mp3.play();
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(1, mp3.currentPosition(), delta);
		assertTrue(mp3.isPlaying());

		mp3.prev();
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(1, mp3.currentPosition(), delta);
		assertTrue(mp3.isPlaying());

		mp3.next();
		assertEquals(list.get(1), mp3.currentSong());

		mp3.next();
		assertEquals(list.get(2), mp3.currentSong());

		mp3.prev();
		assertEquals(list.get(1), mp3.currentSong());

		mp3.next();
		assertEquals(list.get(2), mp3.currentSong());

		mp3.next();
		assertEquals(list.get(3), mp3.currentSong());

		mp3.next();
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(1, mp3.currentPosition(), delta);
		assertTrue(mp3.isPlaying());
	}

	@After
	public void teardown() {
		mp3 = null;
		list = null;
	}
}
