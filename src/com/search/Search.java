package com.search;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class Search {

	private static Integer secuencia = 1;

	public static XStream getXStream() {
		XStream xs = new XStream();
		xs.alias("file", IndexerMP3.class);
		xs.alias("file", Indexer.class);
		return xs;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date start = new Date();
		String path = "X:\\";
		File f = new File(path);
		List<Indexer> files = new ArrayList<Indexer>();

		procesar(f, files);

		String outFile = path + File.separator + "files.xml";
		System.out.println("****************generando xml en " + outFile
				+ " ****************");
		String xml = getXStream().toXML(files);
		FileWriter f0 = null;
		try {
			f0 = new FileWriter(outFile);
			f0.write(xml);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				f0.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Date finish = new Date();
		System.out.println("tiempo total:"
				+ (finish.getTime() - start.getTime()) / 1000 + " segundos");
	}

	private static void procesar(File f, List<Indexer> files) {
		String name = f.getName();
		if (f.isFile()) {
			Indexer indexer = ProviderIndexer.getIndexer(f, secuencia);
			try {
				indexer.index();
				files.add(indexer);
				secuencia++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			File[] childrenList = f.listFiles();

			if (childrenList == null) {
				// Either dir does not exist or is not a directory
			} else {
				System.out.println("procesando " + name + ", se encontraron "
						+ childrenList.length + " hijos");
				for (int i = 0; i < childrenList.length; i++) {
					// Get filename of file or directory
					procesar(childrenList[i], files);

				}
			}

		}

	}
}
