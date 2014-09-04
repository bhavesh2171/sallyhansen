package com.mobilosophy.sallyhansen.adapter;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextView extends TextView {

	/*
	 * Caches typefaces based on their file path and name, so that they don't
	 * have to be created every time when they are referenced.
	 */
	private static Map<String, Typeface> mTypefaces;

	public CustomTextView(final Context context) {
		this(context, null);
	}

	public CustomTextView(final Context context, final AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomTextView(final Context context, final AttributeSet attrs,
			final int defStyle) {
		super(context, attrs, defStyle);
		if (mTypefaces == null) {
			mTypefaces = new HashMap<String, Typeface>();
		}

		// code comment for future use

		// final TypedArray array = context.obtainStyledAttributes(attrs,
		// CustomTextView);
		// if (array != null) {
		// final String typefaceAssetPath = array
		// .getString(R.styleable.CustomTextView_customFont);
		//
		// if (typefaceAssetPath != null) {
		// Typeface typeface = null;
		//
		// if (mTypefaces.containsKey(typefaceAssetPath)) {
		// typeface = mTypefaces.get(typefaceAssetPath);
		// } else {
		// AssetManager assets = context.getAssets();
		// typeface = Typeface.createFromAsset(assets,
		// typefaceAssetPath);
		// mTypefaces.put(typefaceAssetPath, typeface);
		// }
		//
		// setTypeface(typeface);
		// }
		// array.recycle();
		// }
	}

}