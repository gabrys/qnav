// Created by plusminus on 5:29:31 PM - Feb 18, 2009
package org.andnav2.ui.map.hud;

import org.andnav2.adt.UnitSystem;

import android.view.View.OnClickListener;



public interface IHUDNextActionView extends IHUDView {
	// ===========================================================
	// Final Fields
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public abstract void setTurnAngle(final float aAngle);

	public abstract void setCurrentMeterSpeed(final float aMeterSpeed);

	public abstract void showTargetReached();

	public abstract void setNextActionOnClickListener(final OnClickListener pOnClickListener);

	/** DummyAdapter doing nothing.  */
	public static class IHUDNextActionViewAdapter implements IHUDNextActionView{

		@Override
		public void setCurrentMeterSpeed(final float meterSpeed) { }

		@Override
		public void setNextActionOnClickListener(final OnClickListener onClickListener) { }

		@Override
		public void setTurnAngle(final float angle) { }

		@Override
		public void showTargetReached() { }

		@Override
		public void onClick() { }

		@Override
		public void recycle() { }

		@Override
		public void reset() { }

		@Override
		public void setDisplayQuality(final int displayQuality) { }

		@Override
		public void setDistance(final int meterDistance) { }

		@Override
		public void setUnitSystem(final UnitSystem unitSystem) { }
	}
}
