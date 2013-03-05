package com.search;

import java.io.File;

import org.farng.mp3.MP3File;
import org.farng.mp3.id3.AbstractID3v2;
import org.farng.mp3.id3.ID3v1;

public class IndexerMP3 extends Indexer {

	public IndexerMP3(File f, Integer pSecuencia) {
		super(f, pSecuencia);
	}

	private String album;
	private String artist;
	private String genre;
	private String year;

	private String title;
	private String trackNumber;
	private String lyric;

	public void index() throws Exception {
		super.index();
		MP3File mp3 = new MP3File(sourceFile);
		AbstractID3v2 iD3v2 = mp3.getID3v2Tag();
		if (iD3v2 != null) {
			setAlbum(Texto.validateAlbum(iD3v2.getAlbumTitle()));
			setArtist(iD3v2.getAuthorComposer());
			if (Texto.esBlancoONulo(artist)) {
				setArtist(iD3v2.getLeadArtist());
			}

			setSize(iD3v2.getSize());
			// iD3v2.getSongComment();
			setGenre(Texto.validateGenre(iD3v2.getSongGenre()));
			setLyric(iD3v2.getSongLyric());
			setTitle(Texto.validateTitle(iD3v2.getSongTitle()));
			setTrackNumber(iD3v2.getTrackNumberOnAlbum());
			setYear(iD3v2.getYearReleased());
		}

		ID3v1 iD3v1 = mp3.getID3v1Tag();
		if (iD3v1 != null) {
			if (Texto.esBlancoONulo(album)) {
				setAlbum(Texto.validateAlbum(iD3v1.getAlbum()));
			}
			if (Texto.esBlancoONulo(album)) {
				setAlbum(Texto.validateAlbum(iD3v1.getAlbumTitle()));
			}
			if (Texto.esBlancoONulo(artist)) {
				setArtist(iD3v1.getArtist());
			}
			// iD3v1.getAuthorComposer();
			/*
			 * if (Texto.esBlancoONulo(genre)) {
			 * setGenre(Texto.validateGenre(iD3v1.getGenre())); }
			 */
			if (size == null || size.intValue() == 0) {
				setSize(iD3v1.getSize());
			}

			if (Texto.esBlancoONulo(genre)) {
				setGenre(Texto.validateGenre(iD3v1.getSongGenre()));
			}
			// iD3v1.getSongLyric();
			if (Texto.esBlancoONulo(title)) {
				setTitle(Texto.validateTitle(iD3v1.getSongTitle()));
			}
			if (Texto.esBlancoONulo(title)) {
				setTitle(Texto.validateTitle(iD3v1.getTitle()));
			}
			if (Texto.esBlancoONulo(trackNumber)) {
				try {
					setTrackNumber(iD3v1.getTrackNumberOnAlbum());
				} catch (Exception e) {
				}
			}
			if (Texto.esBlancoONulo(year)) {
				setYear(iD3v1.getYear());
			}
			if (Texto.esBlancoONulo(year)) {
				setYear(iD3v1.getYearReleased());
			}
		}

	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

}
