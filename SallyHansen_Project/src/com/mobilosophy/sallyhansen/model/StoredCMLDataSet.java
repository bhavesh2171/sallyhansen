package com.mobilosophy.sallyhansen.model;

import android.graphics.Bitmap;

public class StoredCMLDataSet {

	Bitmap bitmap;
	String fileName;

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
