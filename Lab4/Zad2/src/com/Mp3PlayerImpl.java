package com;

import java.util.ArrayList;

public class Mp3PlayerImpl implements Mp3Player {
	private ArrayList<String> songList;
	private int idCurrentSong = 0;
	private double songTime = 0;
	private boolean playingSong = false;

	@Override
	public void play() {
		if (songList != null) {
			songTime = 1;
			playingSong = true;
		}
	}

	@Override
	public void pause() {
		playingSong = false;
	}

	@Override
	public void stop() {
		songTime = 0;
		playingSong = false;
	}

	@Override
	public double currentPosition() {
		return songTime;
	}

	@Override
	public String currentSong() {
		if (songList == null)
			return null;
		return (String) songList.get(idCurrentSong);
	}

	@Override
	public void next() {
		if (idCurrentSong == (songList.size() - 1))
			idCurrentSong = 0;
		else
			idCurrentSong++;
		songTime = 0;
		play();
	}

	@Override
	public void prev() {
		if (idCurrentSong != 0)
			idCurrentSong--;
		songTime = 0;
		play();
	}

	@Override
	public boolean isPlaying() {
		return playingSong;
	}

	@Override
	public void loadSongs(ArrayList<String> names) {
		songList = names;
	}
}
