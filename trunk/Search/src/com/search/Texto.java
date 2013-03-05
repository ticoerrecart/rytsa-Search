package com.search;

public abstract class Texto {

	public static boolean esBlancoONulo(String s) {
		return s == null || "".equals(s);
	}

	public static String validateTitle(String s) {
		if (!esBlancoONulo(s)) {
			if (s.toLowerCase().indexOf("track") >= 0
					|| s.toLowerCase().indexOf("title") >= 0) {
				return null;
			} else {
				return s;
			}
		}
		return null;
	}

	public static String validateGenre(String s) {
		if (!esBlancoONulo(s)) {
			if (s.toLowerCase().indexOf("genre") >= 0) {
				return null;
			} else {
				return s;
			}
		}
		return null;
	}

	public static String validateAlbum(String s) {
		if (!esBlancoONulo(s)) {
			if (s.toLowerCase().indexOf("title") >= 0) {
				return null;
			} else {
				return s;
			}
		}
		return null;
	}

}
