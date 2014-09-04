package com.mobilosophy.sallyhansen.activity;

import android.annotation.SuppressLint;
import android.app.Activity;

@SuppressLint("NewApi")
public class FixNailPosition extends Activity {
	// implements OnClickListener,
	// OnSeekBarChangeListener {
	// Context context;
	//
	// private Bitmap CML_USER_BITMAP;
	//
	// private ImageView img_hand;
	// private ImageButton img_btn_back, done_btn, img_btn_nail_width,
	// img_btn_nail_height;
	//
	// private RelativeLayout layout_nails_image_holder, layout_header;
	// int width;
	//
	// private TextView txt_seek_title;
	// private SeekBar my_bar_seek;
	//
	// private Boolean isChangeHeightSelected, isViewAdded, isNailClicked =
	// false;
	// private static int nail_selected;
	// ArrayList<NailDataSet> nailDataSets;
	// float nail_center_x, nail_center_y, diff_in_angle;
	// int origix, origiy;
	// private static double startAngle;
	//
	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.fix_nail_position);
	// setupUI();
	// ChangeNailType.setupRoundedNailsOnHand(context,
	// layout_nails_image_holder, width, true);
	// setOnTouchListner(layout_header, layout_nails_image_holder);
	// nailDataSets = CreateLook.initHeightForAllNails(context);
	//
	//
	// //increaseHeightWidthOfNail
	//
	// }
	//
	// private void setupUI() {
	// context = this;
	// isViewAdded = false;
	// nailDataSets = new ArrayList<NailDataSet>();
	// nail_selected = Constants.THUMB_FINGER;
	//
	// CML_USER_BITMAP = CreateLook.retriveFromData(context, getResources()
	// .getString(R.string.capture_file));/*
	// * BitmapFactory .
	// * decodeByteArray (
	// * byteArray , 0, byteArray
	// * . length );
	// */
	//
	// CreateLook.HAND_TYPE = getIntent().getStringExtra(
	// getResources().getString(R.string.hand_type));
	// CreateLook.HAND_SIDE = getIntent().getStringExtra(
	// getResources().getString(R.string.hand_side));
	//
	// txt_seek_title = (TextView) findViewById(R.id.txt_seek_title);
	// my_bar_seek = (SeekBar) findViewById(R.id.my_bar_seek);
	// drawer = (MultiDirectionSlidingDrawer) findViewById(R.id.drawer);
	//
	// img_hand = (ImageView) findViewById(R.id.img_hand);
	//
	// img_btn_back = (ImageButton) findViewById(R.id.img_btn_back);
	// img_btn_nail_width = (ImageButton) findViewById(R.id.img_btn_nail_width);
	// img_btn_nail_height = (ImageButton)
	// findViewById(R.id.img_btn_nail_height);
	// done_btn = (ImageButton) findViewById(R.id.done_btn);
	//
	// layout_nails_image_holder = (RelativeLayout)
	// findViewById(R.id.layout_nails_image_holder);
	// layout_header = (RelativeLayout) findViewById(R.id.layout_header);
	//
	// Display display = getWindowManager().getDefaultDisplay();
	// width = display.getWidth();
	// // height = display.getHeight();
	// my_bar_seek.setOnSeekBarChangeListener(this);
	//
	// if (CML_USER_BITMAP != null)
	// img_hand.setImageBitmap(CML_USER_BITMAP);
	//
	// isChangeHeightSelected = true;
	//
	// img_btn_back.setOnClickListener(this);
	// done_btn.setOnClickListener(this);
	// img_btn_nail_width.setOnClickListener(this);
	// img_btn_nail_height.setOnClickListener(this);
	//
	// }
	//
	// @Override
	// public void onClick(View view) {
	// if (view == img_btn_back) {
	// FixNailPosition.this.finish();
	// }
	// if (view == done_btn) {
	// updateCurrentAngle();
	// Intent intent = new Intent(FixNailPosition.this, CreateLook.class);
	// intent.putExtra(
	// getResources().getString(R.string.hand_type),
	// getIntent().getStringExtra(
	// getResources().getString(R.string.hand_type)));
	// intent.putExtra(getResources().getString(R.string.hand_side),
	// getResources().getString(R.string.hand_side_right));
	// intent.putExtra(
	// getResources().getString(R.string.cml_type),
	// getIntent().getStringExtra(
	// getResources().getString(R.string.cml_type)));
	// intent.putExtra(getResources().getString(R.string.bmp), getIntent()
	// .getByteArrayExtra(getResources().getString(R.string.bmp)));
	// intent.putExtra(
	// context.getResources().getString(R.string.nail_array),
	// nailDataSets);
	// startActivity(intent);
	// FixNailPosition.this.finish();
	// }
	//
	// if (view == img_btn_nail_height) {
	// isChangeHeightSelected = true;
	// drawer.open();
	// txt_seek_title.setText(context.getResources().getString(
	// R.string.nail_length));
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getY_scale());
	// }
	// if (view == img_btn_nail_width) {
	// isChangeHeightSelected = false;
	// drawer.open();
	// txt_seek_title.setText(context.getResources().getString(
	// R.string.nail_width));
	//
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getX_scale());
	// }
	// }
	//
	// /**
	// * call this method to setup onTouchListner for all nails, So that user
	// can
	// * manually adjust nails according to his/her need
	// *
	// * @param layout_header
	// * -LinearLayout which is on top of nail holder relativeLayout
	// * @param layout_nails_image_holder
	// * - RelativeLayout which is holding nail objects to drag
	// */
	// public void setOnTouchListner(final RelativeLayout layout_header,
	// final RelativeLayout layout_nails_image_holder) {
	//
	// CreateLook.img_nail_thumb.setOnTouchListener(new OnTouchListener() {
	//
	// @Override
	// public boolean onTouch(View v, MotionEvent event) {
	// nail_center_x = v.getLeft() + (v.getWidth() / 2);
	// nail_center_y = v.getTop() + (v.getHeight() / 2);
	// isNailClicked = true;
	// if (nail_selected != Constants.THUMB_FINGER) {
	// nail_selected = Constants.THUMB_FINGER;
	// if (isChangeHeightSelected)
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getY_scale());
	// else
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getX_scale());
	// }
	// dragView(v, event, Constants.THUMB_FINGER, layout_header,
	// layout_nails_image_holder, null, 0, 0, 0, context,
	// nail_selected, nailDataSets);
	// System.out.println("nail_selected_x" + nail_center_x
	// + " nail_selected_y " + nail_center_y);
	//
	// if (isViewAdded) {
	// int position = (FixNailPosition.this.layout_nails_image_holder
	// .getChildCount() - 1);
	// FixNailPosition.this.layout_nails_image_holder
	// .removeViewAt(position);
	// isViewAdded = false;
	// }
	//
	// addChangeAngleArrow(context, nail_center_x, nail_center_y,
	// FixNailPosition.this.layout_nails_image_holder,
	// CreateLook.img_nail_thumb,
	// CreateLook.bitmap_img_nail_thumb, nail_selected);
	//
	// return true;
	// }
	// });
	//
	// CreateLook.img_nail_index.setOnTouchListener(new OnTouchListener() {
	//
	// @Override
	// public boolean onTouch(View v, MotionEvent event) {
	// nail_center_x = v.getLeft() + (v.getWidth() / 2);
	// nail_center_y = v.getTop() + (v.getHeight() / 2);
	// isNailClicked = true;
	// if (nail_selected != Constants.INDEX_FINGER) {
	// nail_selected = Constants.INDEX_FINGER;
	// if (isChangeHeightSelected)
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getY_scale());
	// else
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getX_scale());
	// }
	// dragView(v, event, Constants.INDEX_FINGER, layout_header,
	// layout_nails_image_holder, null, 0, 0, 0, context,
	// nail_selected, nailDataSets);
	//
	// if (isViewAdded) {
	// int position = (FixNailPosition.this.layout_nails_image_holder
	// .getChildCount() - 1);
	// FixNailPosition.this.layout_nails_image_holder
	// .removeViewAt(position);
	// isViewAdded = false;
	// }
	//
	// addChangeAngleArrow(context, nail_center_x, nail_center_y,
	// FixNailPosition.this.layout_nails_image_holder,
	// CreateLook.img_nail_index,
	// CreateLook.bitmap_img_nail_index, nail_selected);
	//
	// return true;
	// }
	// });
	// CreateLook.img_nail_middle.setOnTouchListener(new OnTouchListener() {
	//
	// @Override
	// public boolean onTouch(View v, MotionEvent event) {
	// nail_center_x = v.getLeft() + (v.getWidth() / 2);
	// nail_center_y = v.getTop() + (v.getHeight() / 2);
	// isNailClicked = true;
	// if (nail_selected != Constants.MIDDLE_FINGER) {
	// nail_selected = Constants.MIDDLE_FINGER;
	// if (isChangeHeightSelected)
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getY_scale());
	// else
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getX_scale());
	// }
	// dragView(v, event, Constants.MIDDLE_FINGER, layout_header,
	// layout_nails_image_holder, null, 0, 0, 0, context,
	// nail_selected, nailDataSets);
	//
	// if (isViewAdded) {
	// int position = (FixNailPosition.this.layout_nails_image_holder
	// .getChildCount() - 1);
	// FixNailPosition.this.layout_nails_image_holder
	// .removeViewAt(position);
	// isViewAdded = false;
	// }
	//
	// addChangeAngleArrow(context, nail_center_x, nail_center_y,
	// FixNailPosition.this.layout_nails_image_holder,
	// CreateLook.img_nail_middle,
	// CreateLook.bitmap_img_nail_middle, nail_selected);
	//
	// return true;
	// }
	// });
	// CreateLook.img_nail_pinkie.setOnTouchListener(new OnTouchListener() {
	//
	// @Override
	// public boolean onTouch(View v, MotionEvent event) {
	// nail_center_x = v.getLeft() + (v.getWidth() / 2);
	// nail_center_y = v.getTop() + (v.getHeight() / 2);
	// isNailClicked = true;
	// if (nail_selected != Constants.PINKIE_FINGER) {
	// nail_selected = Constants.PINKIE_FINGER;
	// if (isChangeHeightSelected)
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getY_scale());
	// else
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getX_scale());
	// }
	// dragView(v, event, Constants.PINKIE_FINGER, layout_header,
	// layout_nails_image_holder, null, 0, 0, 0, context,
	// nail_selected, nailDataSets);
	//
	// if (isViewAdded) {
	// int position = (FixNailPosition.this.layout_nails_image_holder
	// .getChildCount() - 1);
	// FixNailPosition.this.layout_nails_image_holder
	// .removeViewAt(position);
	// isViewAdded = false;
	// }
	//
	// addChangeAngleArrow(context, nail_center_x, nail_center_y,
	// FixNailPosition.this.layout_nails_image_holder,
	// CreateLook.img_nail_pinkie,
	// CreateLook.bitmap_img_nail_pinkie, nail_selected);
	//
	// return true;
	// }
	// });
	// CreateLook.img_nail_ring.setOnTouchListener(new OnTouchListener() {
	//
	// @Override
	// public boolean onTouch(View v, MotionEvent event) {
	// nail_center_x = v.getLeft() + (v.getWidth() / 2);
	// nail_center_y = v.getTop() + (v.getHeight() / 2);
	// isNailClicked = true;
	// if (nail_selected != Constants.RING_FINGER) {
	// nail_selected = Constants.RING_FINGER;
	// if (isChangeHeightSelected)
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getY_scale());
	// else
	// my_bar_seek.setProgress(nailDataSets.get(nail_selected)
	// .getX_scale());
	// }
	// dragView(v, event, Constants.RING_FINGER, layout_header,
	// layout_nails_image_holder, null, 0, 0, 0, context,
	// nail_selected, nailDataSets);
	//
	// if (isViewAdded) {
	// int position = (FixNailPosition.this.layout_nails_image_holder
	// .getChildCount() - 1);
	// FixNailPosition.this.layout_nails_image_holder
	// .removeViewAt(position);
	// isViewAdded = false;
	// }
	//
	// addChangeAngleArrow(context, nail_center_x, nail_center_y,
	// FixNailPosition.this.layout_nails_image_holder,
	// CreateLook.img_nail_ring,
	// CreateLook.bitmap_img_nail_ring, nail_selected);
	//
	// return true;
	// }
	// });
	// }
	//
	// /**
	// * Call this method to start actual dragging of nail object
	// *
	// * @param view
	// * - nail (ImageView) to drag
	// * @param event
	// * - MotionEvent object from onTouchListner
	// * @param longPress
	// * - integer position of nail (Thumb =0, Index =1, Middle = 2,
	// * Ring = 3, Pinkie =4)
	// * @param layout_header
	// * -LinearLayout which is on top of nail holder relativeLayout
	// * @param layout_nails_image_holder
	// * - RelativeLayout which is holding nail objects to drag
	// * @param y_point
	// * @param x_point
	// * @param bitmap_img_nail_resource
	// * @param nailDataSets
	// */
	// public ArrayList<NailDataSet> dragView(View view, MotionEvent event,
	// final int longPress, RelativeLayout layout_header,
	// RelativeLayout layout_nails_image_holder, ImageView nailView,
	// float x_point, float y_point, int bitmap_img_nail_resource,
	// Context context, int nail_selected,
	// ArrayList<NailDataSet> nailDataSets) {
	// ArrayList<NailDataSet> nailsDataSets = nailDataSets;
	// android.widget.RelativeLayout.LayoutParams layoutParams =
	// (android.widget.RelativeLayout.LayoutParams) view
	// .getLayoutParams();
	// switch (event.getAction()) {
	// case MotionEvent.ACTION_DOWN:
	// CreateLook.layout_nails_image_holder_width = layout_nails_image_holder
	// .getWidth();
	// CreateLook.layout_nails_image_holder_height = layout_nails_image_holder
	// .getHeight();
	// CreateLook.origix = view.getLeft();
	// CreateLook.origiy = view.getTop();
	// if (longPress == -1) {
	// if (nailsDataSets.get(nail_selected).getAngle() == 0) {
	// startAngle = getAngle(x_point, y_point, event.getRawX()
	// + (view.getWidth() / 2),
	// event.getRawY() + (view.getHeight() / 2));
	// nailsDataSets.get(nail_selected).setAngle((int) startAngle);
	// } else
	// startAngle = nailsDataSets.get(nail_selected).getAngle();
	// }
	// break;
	// case MotionEvent.ACTION_MOVE:
	// int x_cord = (int) event.getRawX();
	// int y_cord = (int) event.getRawY();
	// if (x_cord > CreateLook.layout_nails_image_holder_width
	// - view.getWidth()) {
	// x_cord = CreateLook.layout_nails_image_holder_width
	// - view.getWidth();
	// }
	// if (y_cord > (CreateLook.layout_nails_image_holder_height - view
	// .getHeight() / 2)) {
	// y_cord = CreateLook.layout_nails_image_holder_height;
	// }
	// if (x_cord < 0) {
	// CreateLook.origix = 0;
	// System.out.println(x_cord + " 0");
	// } else {
	// CreateLook.origix = x_cord;
	// System.out.println(x_cord + " x_cord ");
	// }
	// if (y_cord < layout_header.getHeight()) {
	// CreateLook.origiy = layout_header.getHeight();
	// System.out.println(y_cord + " layout_header.getHeight() "
	// + CreateLook.origiy);
	// } else {
	// CreateLook.origiy = (y_cord - view.getHeight())
	// - layout_header.getHeight();
	// System.out.println(y_cord + " y_cord + img.getHeight() "
	// + layout_header.getHeight() + "  " + view.getHeight());
	// }
	//
	// if (longPress != -1)
	// Constants.setCurrentNailMargin(longPress, CreateLook.origix,
	// CreateLook.origiy);
	// else if (longPress == -1) {
	// CreateLook.origix = (CreateLook.origix - nailView.getLeft() - 25);
	// CreateLook.origiy = (CreateLook.origiy - 200)
	// - nailView.getTop();
	//
	// double currentAngle = getAngle(x_point, y_point,
	// event.getRawX(), event.getRawY());
	// nailsDataSets.get(nail_selected).setAngle(
	// (int) rotateDialer((float) (currentAngle - startAngle),
	// nailView, bitmap_img_nail_resource, context));
	// System.out.println(startAngle + " Current angle"
	// + (currentAngle - startAngle) + " " + currentAngle);
	//
	// }
	// layoutParams.leftMargin = CreateLook.origix;
	// layoutParams.topMargin = CreateLook.origiy;
	//
	// if (y_cord != CreateLook.origiy) {
	// view.setLayoutParams(layoutParams);
	// }
	// break;
	// default:
	// break;
	// }
	// return nailsDataSets;
	// }
	//
	// @Override
	// public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
	// nailDataSets = CreateLook.increaseHeightWidthOfNail(context, arg1,
	// isChangeHeightSelected, false, nail_selected, nailDataSets,
	// true, true);
	// }
	//
	// @Override
	// public void onStartTrackingTouch(SeekBar arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void onStopTrackingTouch(SeekBar arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// /**
	// * Call this method to get the angle between center of nail to dragged
	// arrow
	// * from user
	// *
	// * @param center_start_point_x
	// * - Center X point of nail
	// * @param center_start_point_y
	// * - Center Y point of nail
	// * @param center_end_point_x
	// * - Center X point of dragged arrow
	// * @param center_end_point_y
	// * - Center Y point of dragged arrow
	// * @return
	// */
	// public static double getAngle(float center_start_point_x,
	// float center_start_point_y, float center_end_point_x,
	// float center_end_point_y) {
	// System.out.println("Center X" + center_start_point_x + " Center Y "
	// + center_start_point_y + " drag X " + center_end_point_x
	// + " Y " + center_end_point_y);
	//
	// double angle = 0;
	// float deltaY = 0, deltaX = 0;
	// deltaY = center_end_point_y - center_start_point_y;
	// deltaX = center_end_point_x - center_start_point_x;
	// angle = Math.atan2(deltaY, deltaX);
	// //
	// // if (angle < 0)
	// // angle = Math.abs(angle);
	// // else
	// // angle = 2 * Math.PI - angle;
	// // System.out.println(2 * Math.PI - angle + " " + 2 * Math.PI + " "
	// // + Math.PI);
	// return Math.toDegrees(angle);
	// // System.out.println("Angle +++++" + angle);
	// // return angle;
	// }
	//
	// private ImageView addChangeAngleArrow(final Context context,
	// final float x_point, final float y_point,
	// final RelativeLayout nail_holder_layout, final ImageView nailView,
	// final int bitmap_img_nail_resource, final int nail_selected) {
	//
	// final ImageView imageView = new ImageView(context);
	// imageView.setBackgroundResource(R.drawable.drag_arrow);
	// RelativeLayout.LayoutParams layoutParams = new
	// RelativeLayout.LayoutParams(
	// LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	// imageView.setLayoutParams(layoutParams);
	// imageView.setX(x_point);
	// imageView.setY((y_point + 150));
	// layout_nails_image_holder.addView(imageView);
	//
	// isViewAdded = true;
	//
	// imageView.setOnTouchListener(new OnTouchListener() {
	//
	// @Override
	// public boolean onTouch(View view, MotionEvent event) {
	//
	// nailDataSets = dragView(view, event, -1, layout_header,
	// nail_holder_layout, nailView, x_point, y_point,
	// bitmap_img_nail_resource, context, nail_selected,
	// nailDataSets);
	// return true;
	// }
	// });
	//
	// return imageView;
	// }
	//
	// /**
	// * Rotate the dialer.
	// *
	// * @param degrees
	// * The degrees, the dialer should get rotated.
	// * @param bitmap_img_nail_resource
	// */
	// public float rotateDialer(float degrees, ImageView nailView,
	// int bitmap_img_nail_resource, Context context) {
	// System.out.println("degrees" + degrees);
	// if (isNailClicked) {
	// diff_in_angle = degrees;
	// isNailClicked = false;
	// }
	// degrees = degrees - diff_in_angle;
	// // if (degrees > 360)
	// // degrees = degrees - 360;
	//
	// // degrees = 360 - degrees;
	// System.out.println("Final angle " + degrees);
	// nailView.setRotation(degrees);
	// nailView.postInvalidate();
	// return degrees;
	// }
	//
	// private void updateCurrentAngle() {
	// if (getIntent().getStringExtra(
	// getResources().getString(R.string.hand_type)).equals(
	// getResources().getString(R.string.hand_type_close))) {
	// Constants.CURRENT_THUMB_ANGLE = (Constants.LEFT_CLOSE_HAND_THUMB_ANGLE -
	// 180);
	// Constants.CURRENT_PINKIE_ANGLE = (Constants.LEFT_CLOSE_HAND_PINKIE_ANGLE
	// - 180);
	// Constants.CURRENT_RING_ANGLE = (Constants.LEFT_CLOSE_HAND_RING_ANGLE -
	// 180);
	// Constants.CURRENT_MIDDLE_ANGLE = (Constants.LEFT_CLOSE_HAND_MIDDLE_ANGLE
	// - 180);
	// Constants.CURRENT_INDEX_ANGLE = (Constants.LEFT_CLOSE_HAND_INDEX_ANGLE -
	// 180);
	// } else {
	// Constants.CURRENT_THUMB_ANGLE = (Constants.RIGHT_OPEN_HAND_THUMB_ANGLE -
	// 180);
	// Constants.CURRENT_PINKIE_ANGLE = (Constants.RIGHT_OPEN_HAND_PINKIE_ANGLE
	// - 180);
	// Constants.CURRENT_RING_ANGLE = (Constants.RIGHT_OPEN_HAND_RING_ANGLE -
	// 180);
	// Constants.CURRENT_MIDDLE_ANGLE = (Constants.RIGHT_OPEN_HAND_MIDDLE_ANGLE
	// - 180);
	// Constants.CURRENT_INDEX_ANGLE = (Constants.RIGHT_OPEN_HAND_INDEX_ANGLE -
	// 180);
	// }
	// }
}
