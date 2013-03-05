package com.search;

import java.io.File;

public class Indexer {
	protected File sourceFile;
	protected Integer size;
	protected Integer secuencia;

	public Indexer(File f, Integer pSecuencia) {
		setSecuencia(pSecuencia);
		setSourceFile(f);
	}

	public void index() throws Exception {
		if (sourceFile == null) {
			throw new RuntimeException("source file nulo");
		}
	}

	public File getSourceFile() {
		return sourceFile;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

}
