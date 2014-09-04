package com.mobilosophy.sallyhansen.fragment;

import com.mobilosophy.sallyhansen.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CreateOwnLook extends Fragment implements OnClickListener {

	Context context;
	ImageView img_open_hand_template_selector,
			img_closed_hand_template_selector;
	boolean is_from_cml;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View contenView = inflater.inflate(R.layout.create_own_look, container,
				false);
		context = getActivity().getApplicationContext();
		setupUI(contenView);
		is_from_cml = false;
		return contenView;
	}

	@Override
	public void onResume() {
		super.onResume();
		if (is_from_cml) {
			((Activity) context).onBackPressed();
		}

	}

	private void setupUI(View contenView) {

		img_open_hand_template_selector = (ImageView) contenView
				.findViewById(R.id.img_open_hand_template_selector);
		img_closed_hand_template_selector = (ImageView) contenView
				.findViewById(R.id.img_closed_hand_template_selector);

		img_open_hand_template_selector.setOnClickListener(this);
		img_closed_hand_template_selector.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view == img_closed_hand_template_selector) {
			// Intent intent = new Intent(context, CameraWithOverlay.class);
			// intent.putExtra(getResources().getString(R.string.hand_type),
			// getResources().getString(R.string.hand_type_close));
			// intent.putExtra(getResources().getString(R.string.cml_type),
			// getResources().getString(R.string.cml_own));
			// context.startActivity(intent);
			// is_from_cml = true;
			// ((Activity) context).onBackPressed();
		}
		if (view == img_open_hand_template_selector) {
			// Intent intent = new Intent(context, CameraWithOverlay.class);
			// intent.putExtra(getResources().getString(R.string.hand_type),
			// getResources().getString(R.string.hand_type_open));
			// intent.putExtra(getResources().getString(R.string.cml_type),
			// getResources().getString(R.string.cml_own));
			// context.startActivity(intent);
			// is_from_cml = true;
			// ((Activity) context).onBackPressed();
		}
	}
}
