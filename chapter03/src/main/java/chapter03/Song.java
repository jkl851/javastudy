package chapter03;

public class Song {
	private String title;
	private String artist;
	private String composer;
	private String album;
	private int year;
	private int track;
	
	public Song(String title, String artist) {
		//this.title = title;
		//this.artist = artist;
		// some code...
		this(title, artist, null, null, 0, 0);
	}
	
	public Song(String title, String artist, String composer, String album, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.composer = composer;
		this.album = album;
		this.year = year;
		this.track = track;
		System.out.println("some code....");
		
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public void show() {
		System.out.println(
				"title:" + title + 
				", artist:"+ artist + 
				", composer:" + composer + 
				", album:" + album +
				", year:" + year +
				", track:" + track);
	}
}
