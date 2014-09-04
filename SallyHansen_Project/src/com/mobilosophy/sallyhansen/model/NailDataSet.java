package com.mobilosophy.sallyhansen.model;

import java.io.Serializable;

public class NailDataSet implements Serializable {

	int nail_width;
	int nail_height;
	int x_scale;
	int y_scale;
	int angle;

	public int getNail_width() {
		return nail_width;
	}

	public void setNail_width(int nail_width) {
		this.nail_width = nail_width;
	}

	public int getNail_height() {
		return nail_height;
	}

	public void setNail_height(int nail_height) {
		this.nail_height = nail_height;
	}

	public int getX_scale() {
		return x_scale;
	}

	public void setX_scale(int x_scale) {
		this.x_scale = x_scale;
	}

	public int getY_scale() {
		return y_scale;
	}

	public void setY_scale(int y_scale) {
		this.y_scale = y_scale;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}
}
