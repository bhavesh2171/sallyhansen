package com.mobilosophy.sallyhansen.activity;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mobilosophy.sallyhansen.R;
import com.mobilosophy.sallyhansen.constant.Constants;
import com.mobilosophy.sallyhansen.adapter.Preview;

public class CameraWithOverlay extends Activity {
	private static final String TAG = "CamTestActivity";
	Preview preview;
	Button btn_click, btn_re_click, btn_use;
	Camera camera;
	String fileName;
	Activity act;
	Context ctx;
	FrameLayout layout_privew;

	RelativeLayout layout_show_img_holder;
	ImageView img_show_clicked,
			img_hand_overlay/* , img_hand_overlay_on_image */;
	Bitmap bmp;
	int overlay_img = 0;
	boolean is_cml_type_own;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.camera_overlay);

		setupUI();

		btn_click.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					camera.takePicture(shutterCallback, rawCallback,
							jpegCallback);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btn_re_click.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (is_cml_type_own)
					bmp.recycle();
				resetCam();
			}
		});
		btn_use.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				/*
				 * Intent intent = null; if (is_cml_type_own) { intent = new
				 * Intent(CameraWithOverlay.this, FixNailPosition.class);
				 * CreateLook.saveImageToInternalStorage(ctx, bmp,
				 * getResources().getString(R.string.capture_file)); } else {
				 * 
				 * intent = new Intent(CameraWithOverlay.this,
				 * CreateLook.class); } intent.putExtra(
				 * getResources().getString(R.string.hand_type),
				 * getIntent().getStringExtra(
				 * getResources().getString(R.string.hand_type)));
				 * intent.putExtra(getResources().getString(R.string.hand_side),
				 * getResources().getString(R.string.hand_side_right));
				 * intent.putExtra( getResources().getString(R.string.cml_type),
				 * getIntent().getStringExtra(
				 * getResources().getString(R.string.cml_type)));
				 * startActivity(intent); CameraWithOverlay.this.finish();
				 */
				new GetColorMatchedHandImage().execute();
			}
		});
	}

	private void setupUI() {
		ctx = this;
		act = this;

		btn_click = (Button) findViewById(R.id.btn_click);
		btn_re_click = (Button) findViewById(R.id.btn_re_click);
		btn_use = (Button) findViewById(R.id.btn_use);

		img_hand_overlay = (ImageView) findViewById(R.id.img_hand_overlay);
		img_show_clicked = (ImageView) findViewById(R.id.img_clicked_img);
		// img_hand_overlay_on_image = (ImageView)
		// findViewById(R.id.img_hand_overlay_on_image);

		layout_show_img_holder = (RelativeLayout) findViewById(R.id.layout_show_img_holder);

		preview = new Preview(this,
				(SurfaceView) findViewById(R.id.surfaceView));
		preview.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));
		layout_privew = (FrameLayout) findViewById(R.id.preview);
		layout_privew.setVisibility(View.VISIBLE);
		layout_privew.addView(preview);
		preview.setKeepScreenOn(true);

		if (getIntent().getStringExtra(
				getResources().getString(R.string.cml_type)).equals(
				getResources().getString(R.string.cml_default)))
			is_cml_type_own = false;
		else
			is_cml_type_own = true;
		if (is_cml_type_own) {
			if (getIntent().getStringExtra(
					getResources().getString(R.string.hand_type)).equals(
					getResources().getString(R.string.hand_type_open)))
				overlay_img = R.drawable.openrighthand;
			else
				overlay_img = R.drawable.closedlefthand; // closedlefthand;
		} else
			overlay_img = R.drawable.camera_view; // square_camera;
		img_hand_overlay.setBackgroundResource(overlay_img);

	}

	@Override
	protected void onResume() {
		super.onResume();
		layout_show_img_holder.setVisibility(View.GONE);

		camera = Camera.open();
		Camera.Parameters parameters = camera.getParameters();
		List<String> focusModes = parameters.getSupportedFocusModes();
		if (focusModes.contains(Camera.Parameters.FOCUS_MODE_AUTO)) {
			parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
		}
		camera.setParameters(parameters);
		setCameraDisplayOrientation(CameraWithOverlay.this,
				CameraInfo.CAMERA_FACING_BACK, camera);
		// camera.setDisplayOrientation(90);
		camera.startPreview();
		preview.setCamera(camera);
	}

	@Override
	protected void onPause() {
		if (camera != null) {
			camera.stopPreview();
			preview.setCamera(null);
			camera.release();
			camera = null;
		}
		super.onPause();
	}

	private void resetCam() {
		layout_show_img_holder.setVisibility(View.GONE);
		layout_privew.setVisibility(View.VISIBLE);
		Camera.Parameters parameters = camera.getParameters();
		List<String> focusModes = parameters.getSupportedFocusModes();
		if (focusModes.contains(Camera.Parameters.FOCUS_MODE_AUTO)) {
			parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
		}
		camera.setParameters(parameters);
		setCameraDisplayOrientation(CameraWithOverlay.this,
				CameraInfo.CAMERA_FACING_BACK, camera);
		// camera.setDisplayOrientation(90);
		camera.startPreview();
		preview.setCamera(camera);
	}

	ShutterCallback shutterCallback = new ShutterCallback() {
		@Override
		public void onShutter() {
			// Log.d(TAG, "onShutter'd");
		}
	};

	PictureCallback rawCallback = new PictureCallback() {
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			// Log.d(TAG, "onPictureTaken - raw");
		}
	};

	@SuppressLint("NewApi")
	public static void setCameraDisplayOrientation(Activity activity,
			int cameraId, android.hardware.Camera camera) {
		android.hardware.Camera.CameraInfo info = new android.hardware.Camera.CameraInfo();
		android.hardware.Camera.getCameraInfo(cameraId, info);
		int rotation = activity.getWindowManager().getDefaultDisplay()
				.getRotation();
		int degrees = 0;
		switch (rotation) {
		case Surface.ROTATION_0:
			degrees = 0;
			break;
		case Surface.ROTATION_90:
			degrees = 90;
			break;
		case Surface.ROTATION_180:
			degrees = 180;
			break;
		case Surface.ROTATION_270:
			degrees = 270;
			break;
		}

		int result;
		if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
			result = (info.orientation + degrees) % 360;
			result = (360 - result) % 360; // compensate the mirror
		} else { // back-facing
			result = (info.orientation - degrees + 360) % 360;
		}
		camera.setDisplayOrientation(result);
	}

	PictureCallback jpegCallback = new PictureCallback() {
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			btn_click.setClickable(false);
			// FileOutputStream outStream = null;
			try {
				// Write to SD Card
				layout_show_img_holder.setVisibility(View.VISIBLE);
				layout_privew.setVisibility(View.GONE);
				// if (is_cml_type_own) {
				if (data != null) {
					int screenWidth = getResources().getDisplayMetrics().widthPixels;
					int screenHeight = getResources().getDisplayMetrics().heightPixels;
					BitmapFactory.Options sizeOptions = new BitmapFactory.Options();
					sizeOptions.inJustDecodeBounds = true;
					BitmapFactory.decodeByteArray(data, 0,
							(data != null) ? data.length : 0, sizeOptions);
					// Now use the size to determine the ratio you want to
					// shrink it
					Display display = getWindowManager().getDefaultDisplay();
					// Point size = new Point();
					// display.getSize(size);
					final float widthSampling = sizeOptions.outWidth
							/ display.getWidth();
					sizeOptions.inJustDecodeBounds = false;
					// Note this drops the fractional portion, making it
					// smaller
					sizeOptions.inSampleSize = (int) widthSampling;

					bmp = BitmapFactory.decodeByteArray(data, 0, data.length,
							sizeOptions);
					if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
						// Notice that width and height are reversed
						Bitmap scaled = Bitmap.createScaledBitmap(bmp,
								screenHeight, screenWidth, true);
						int w = scaled.getWidth();
						int h = scaled.getHeight();
						// Setting post rotate to 90
						Matrix mtx = new Matrix();
						mtx.postRotate(90);
						// Rotating Bitmap
						bmp = Bitmap
								.createBitmap(scaled, 0, 0, w, h, mtx, true);
					} else {// LANDSCAPE MODE
						// No need to reverse width and height
						Bitmap scaled = Bitmap.createScaledBitmap(bmp,
								screenWidth, screenHeight, true);
						bmp = scaled;
					}
				}
				img_show_clicked.setImageBitmap(bmp);
				// } else {
				// if (getIntent().getStringExtra(
				// getResources().getString(R.string.hand_type))
				// .equals(getResources().getString(
				// R.string.hand_type_open)))
				// img_show_clicked
				// .setBackgroundResource(R.drawable.hand_open_1);
				// else
				// img_show_clicked
				// .setBackgroundResource(R.drawable.hand_closed_1);
				// }
				// img_hand_overlay_on_image.setBackgroundResource(overlay_img);

			} catch (Exception e) {
				e.printStackTrace();
			}/*
			 * finally { // resetCam(); }
			 */
			Log.d(TAG, "onPictureTaken - jpeg");
			btn_click.setClickable(true);
		}
	};

	public static Bitmap rotate(Bitmap bitmap, int degree) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();

		Matrix mtx = new Matrix();
		mtx.postRotate(degree);

		return Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, true);
	}

	class GetColorMatchedHandImage extends AsyncTask<String, String, String> {
		int hand_image = 0, x_count = 0;
		int RED = 0, GREEN = 0, BLUE = 0;
		ProgressDialog dialog;
		int hand_matched = 0;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new ProgressDialog(ctx);
			dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			dialog.setMessage("Please Wait");
			dialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			if (!is_cml_type_own) {
				for (int x = (bmp.getWidth() / 2 - 100); x <= (bmp.getWidth() / 2 + 100); x++) {
					for (int y = (bmp.getHeight() / 2 - 120); y <= (bmp
							.getHeight() / 2 + 120); y++) {
						x_count++;
						RED += Color.red(bmp.getPixel(x, y));
						GREEN += Color.green(bmp.getPixel(x, y));
						BLUE += Color.blue(bmp.getPixel(x, y));
					}
				}
				System.out.println("RED " + RED + " GREEN " + GREEN + " BLUE "
						+ BLUE);
				RED /= x_count;
				GREEN /= x_count;
				BLUE /= x_count;
				System.out.println("RED " + RED + " GREEN " + GREEN + " BLUE "
						+ BLUE);
				hand_matched = (findNearestMatch(RED, GREEN, BLUE) + 1);
				// hand_matched = 5;
				Constants.selected_hand_color_type = hand_matched;

				System.out.println("Hand Matched " + hand_matched);
				if (getIntent().getStringExtra(
						getResources().getString(R.string.hand_type)).equals(
						getResources().getString(R.string.hand_type_close))) {
					if (hand_matched == 1)
						hand_matched = R.drawable.hand_closed_1;
					else if (hand_matched == 2)
						hand_matched = R.drawable.hand_closed_2;
					else if (hand_matched == 3)
						hand_matched = R.drawable.hand_closed_3;
					else if (hand_matched == 4)
						hand_matched = R.drawable.hand_closed_4;
					else if (hand_matched == 5)
						hand_matched = R.drawable.hand_closed_5;
				} else {
					if (hand_matched == 1)
						hand_matched = R.drawable.hand_open_1;
					else if (hand_matched == 2)
						hand_matched = R.drawable.hand_open_2;
					else if (hand_matched == 3)
						hand_matched = R.drawable.hand_open_3;
					else if (hand_matched == 4)
						hand_matched = R.drawable.hand_open_4;
					else if (hand_matched == 5)
						hand_matched = R.drawable.hand_open_5;

				}
			} else {
				Constants.selected_hand_color_type = 1;
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			Intent intent = null;
			if (is_cml_type_own) {
				// for future use

				// intent = new Intent(CameraWithOverlay.this,
				// FixNailPosition.class);
				// CreateLook.saveImageToInternalStorage(ctx, bmp,
				// getResources()
				// .getString(R.string.capture_file));
			} else {

				// intent = new Intent(CameraWithOverlay.this,
				// CreateLook.class);
				// intent.putExtra(getResources().getString(R.string.hand),
				// hand_matched);
			}
			intent.putExtra(
					getResources().getString(R.string.hand_type),
					getIntent().getStringExtra(
							getResources().getString(R.string.hand_type)));
			intent.putExtra(getResources().getString(R.string.hand_side),
					getResources().getString(R.string.hand_side_right));
			intent.putExtra(
					getResources().getString(R.string.cml_type),
					getIntent().getStringExtra(
							getResources().getString(R.string.cml_type)));
			if (dialog.isShowing())
				dialog.dismiss();
			startActivity(intent);
			CameraWithOverlay.this.finish();
			img_show_clicked.setImageBitmap(null);
			if (bmp != null)
				bmp.recycle();

		}
	}

	private int findNearestMatch(int RED, int GREEN, int BLUE) {
		int[] temp = new int[] { 0, 0, 0, 0, 0 };
		for (int count = 0; count < Constants.HAND_COLOR_ARRAY.length; count++) {
			int[] hand_second = Constants.HAND_COLOR_ARRAY[count];
			temp[count] = getDiff(RED, GREEN, BLUE, hand_second[0],
					hand_second[1], hand_second[2]);
		}

		int hand_no = 0, min = temp[0];

		for (int count = 1; count < temp.length; count++) {
			min = (temp[count] < min) ? temp[count] : min;
			if (min == temp[count])
				hand_no = count;
			// else
			// hand_no = hand_no;
		}
		return hand_no;
	}

	private int getDiff(int rED1, int gREEN1, int bLUE1, int rED2, int gREEN2,
			int bLUE2) {

		int delta = 0;
		try {
			double RED1_val = Math.pow(rED1 - rED2, 2);
			double BLUE1_val = Math.pow(bLUE1 - bLUE2, 2);
			double GREEN1_val = Math.pow(gREEN1 - gREEN2, 2);

			delta = (int) Math.sqrt(RED1_val + BLUE1_val + GREEN1_val);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return delta;

		/*
		 * int rDiff = (rED1 > rED2) ? rED1 - rED2 : rED2 - rED1; int gDiff =
		 * (gREEN1 > gREEN2) ? gREEN1 - gREEN2 : gREEN2 - gREEN1; int bDiff =
		 * (bLUE1 > bLUE2) ? bLUE1 - bLUE2 : bLUE2 - bLUE1; return rDiff + gDiff
		 * + bDiff;
		 */}
}
