package com.search;

import java.io.File;

public abstract class ProviderIndexer {

	public static Indexer getIndexer(File file, Integer pSecuencia) {
		Indexer indxr = null;
		String ext = file.getPath().substring(
				file.getPath().lastIndexOf(".") + 1);
		if ("mp3".equalsIgnoreCase(ext)) {
			indxr = new IndexerMP3(file, pSecuencia);
		} else {
			indxr = new Indexer(file, pSecuencia);
		}
		return indxr;
	}
}
