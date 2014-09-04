/**
 * 
 */
package com.mobilosophy.sallyhansen.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mobilosophy.sallyhansen.R;
import com.mobilosophy.sallyhansen.constant.Constants;

public class CreateMyLookTabFragment extends Fragment implements
		OnClickListener {

	Context context;
	private View fragmentView;
	private ImageView img_open_hand_template_selector,
			img_closed_hand_template_selector;
	private Button btn_make_your_own;

	CreateOwnLook createOwnLook;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		fragmentView = inflater.inflate(R.layout.create_my_look, container,
				false);

		context = getActivity().getApplicationContext();
		if (container == null) {
			return null;
		}
		// context = (MainActivity) this.getActivity();
		// context.menuButton.setVisibility(View.INVISIBLE);
		// context.backButton.setVisibility(View.GONE);
		// context.applicationName.setVisibility(View.VISIBLE);
		// context.done_btn.setVisibility(View.INVISIBLE);

		setupUI();

		return fragmentView;
	}

	@Override
	public void onActivityCreated(Bundle saved) {
		super.onActivityCreated(saved);
		// context.mMenuDrawer.setMenuView(R.layout.setting_drawer);
		// context.menuDrawer1();
	}

	@Override
	public void onSaveInstanceState(Bundle toSave) {
		super.onSaveInstanceState(toSave);
	}

	/**
	 * Call this method to setup all UI component with attaching click listeners
	 */
	private void setupUI() {
		createOwnLook = new CreateOwnLook();

		// context.txttitleMain.setText(context.getResources().getString(
		// R.string.create_look));
		// btn_make_your_own = (Button) fragmentView
		// .findViewById(R.id.btn_make_your_own);

		img_open_hand_template_selector = (ImageView) fragmentView
				.findViewById(R.id.img_open_hand_template_selector);
		img_closed_hand_template_selector = (ImageView) fragmentView
				.findViewById(R.id.img_closed_hand_template_selector);

	//	btn_make_your_own.setOnClickListener(this);

		img_closed_hand_template_selector.setOnClickListener(this);
		img_open_hand_template_selector.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view == btn_make_your_own) {
			resetNailPositios();
			// context.getSupportFragmentManager().beginTransaction()
			// .replace(R.id.realtabcontent, createOwnLook)
			// .addToBackStack("create_own_look").commit();
		}
		if (view == img_closed_hand_template_selector) {
			// AlertDialog.Builder builder = new AlertDialog.Builder(context);
			// builder.setMessage("To be done...");
			// builder.setPositiveButton("Ok",
			// new DialogInterface.OnClickListener() {
			//
			// @Override
			// public void onClick(DialogInterface dialog, int which) {
			// dialog.dismiss();
			// }
			// });
			// builder.show();
			resetNailPositios();
			// Intent intent = new Intent(context, CameraWithOverlay.class);
			// intent.putExtra(getResources().getString(R.string.hand_type),
			// getResources().getString(R.string.hand_type_close));
			// intent.putExtra(getResources().getString(R.string.cml_type),
			// getResources().getString(R.string.cml_default));
			// context.startActivity(intent);
		}
		if (view == img_open_hand_template_selector) {
			// AlertDialog.Builder builder = new AlertDialog.Builder(context);
			// builder.setMessage("To be done...");
			// builder.setPositiveButton("Ok",
			// new DialogInterface.OnClickListener() {
			//
			// @Override
			// public void onClick(DialogInterface dialog, int which) {
			// dialog.dismiss();
			// }
			// });
			// builder.show();
			resetNailPositios();
			// Intent intent = new Intent(context, CameraWithOverlay.class);
			// intent.putExtra(getResources().getString(R.string.hand_type),
			// getResources().getString(R.string.hand_type_open));
			// intent.putExtra(getResources().getString(R.string.cml_type),
			// getResources().getString(R.string.cml_default));
			// context.startActivity(intent);
		}
	}

	/**
	 * Call this method to reset current nail position
	 */
	private void resetNailPositios() {
		Constants.CURRENT_HAND_INDEX_FINGER_LEFT_MARGIN = -1;
		Constants.CURRENT_HAND_INDEX_FINGER_TOP_MARGIN = -1;
		Constants.CURRENT_HAND_MIDDLE_FINGER_LEFT_MARGIN = -1;
		Constants.CURRENT_HAND_MIDDLE_FINGER_TOP_MARGIN = -1;
		Constants.CURRENT_HAND_RING_FINGER_LEFT_MARGIN = -1;
		Constants.CURRENT_HAND_RING_FINGER_TOP_MARGIN = -1;
		Constants.CURRENT_HAND_PINKIE_FINGER_LEFT_MARGIN = -1;
		Constants.CURRENT_HAND_PINKIE_FINGER_TOP_MARGIN = -1;
		Constants.CURRENT_HAND_THUMB_FINGER_LEFT_MARGIN = -1;
		Constants.CURRENT_HAND_THUMB_FINGER_TOP_MARGIN = -1;

		// CreateLook.img_nail_thumb = CreateLook.img_nail_index =
		// CreateLook.img_nail_middle = CreateLook.img_nail_pinkie =
		// CreateLook.img_nail_ring = null;

		Constants.CURRENT_INDEX_ANGLE = 0;
		Constants.CURRENT_MIDDLE_ANGLE = 0;
		Constants.CURRENT_PINKIE_ANGLE = 0;
		Constants.CURRENT_RING_ANGLE = 0;
		Constants.CURRENT_THUMB_ANGLE = 0;
	}
}
