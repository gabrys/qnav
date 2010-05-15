// Created by plusminus on 11:17:18 AM - Feb 27, 2009
package org.andnav2.ui.map.hud.impl.bigarrow;

import org.andnav2.R;
import org.andnav2.adt.UnitSystem;
import org.andnav2.osm.views.overlay.util.DirectionArrowDescriptor;
import org.andnav2.ui.map.hud.IHUDImpl;
import org.andnav2.ui.map.hud.IHUDImplVariation;
import org.andnav2.ui.map.hud.IHUDNextActionView;
import org.andnav2.ui.map.hud.IHUDRemainingSummaryView;
import org.andnav2.ui.map.hud.IHUDTurnDescriptionView;
import org.andnav2.ui.map.hud.impl.bigarrow.views.HUDNextActionView;
import org.andnav2.ui.map.hud.util.Util;
import org.andnav2.util.TimeUtils;
import org.andnav2.util.constants.Constants;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class BigArrowHUDImpl implements IHUDImpl {
	// ===========================================================
	// Constants
	// ===========================================================

	public static final int ID = 2;

	// ===========================================================
	// Fields
	// ===========================================================

	private TextView mTvTurnDescription;
	private TextView mTvTimeRemaining;
	private TextView mTvLengthRemaining;
	private HUDNextActionView mHUDNextActionView;

	private DescriptionAndSummaryWrapper mDescriptionAndSummaryWrapper;

	private IHUDNextActionView mHUDUpperNextActionDummyAdapter;

	// ===========================================================
	// Constructors
	// ===========================================================

	@Override
	public void init(final View pRootView) {
		this.mHUDNextActionView = (HUDNextActionView) pRootView.findViewById(R.id.hud_ddmap_bigarrow_nextaction);
		this.mTvLengthRemaining = (TextView) pRootView.findViewById(R.id.hud_ddmap_bigarrow_restlength);
		this.mTvTimeRemaining = (TextView) pRootView.findViewById(R.id.hud_ddmap_bigarrow_time);
		this.mTvTurnDescription = (TextView) pRootView.findViewById(R.id.hud_ddmap_bigarrow_turndescription);

		this.mDescriptionAndSummaryWrapper = new DescriptionAndSummaryWrapper();

		this.mHUDUpperNextActionDummyAdapter = new IHUDNextActionView.IHUDNextActionViewAdapter();
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods from SuperClass/Interfaces
	// ===========================================================

	@Override
	public int getCountOfVariations() {
		return VARIATIONS.length;
	}

	@Override
	public int getDescriptionResourceID() {
		return R.string.hud_bigarrow_description;
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public int getNameResourceID() {
		return R.string.hud_bigarrow_name;
	}

	@Override
	public IHUDNextActionView getNextActionView() {
		return this.mHUDNextActionView;
	}

	@Override
	public IHUDRemainingSummaryView getRemainingSummaryView() {
		return this.mDescriptionAndSummaryWrapper;
	}

	@Override
	public IHUDTurnDescriptionView getTurnTurnDescriptionView() {
		return this.mDescriptionAndSummaryWrapper;
	}

	@Override
	public IHUDNextActionView getUpperNextActionView() {
		return this.mHUDUpperNextActionDummyAdapter;
	}

	@Override
	public IHUDImplVariation getVariation(final int pVariationID) throws IllegalArgumentException {
		return Util.getVariation(VARIATIONS, pVariationID);
	}

	@Override
	public IHUDImplVariation[] getVariations() {
		return VARIATIONS;
	}


	@Override
	public void invalidateViews() {

	}

	@Override
	public void setUpperNextActionViewNecessary(final boolean pNecessary) {
		/* Nothing. */
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

	private class DescriptionAndSummaryWrapper implements IHUDRemainingSummaryView, IHUDTurnDescriptionView {
		private UnitSystem mUnitSystem = UnitSystem.METRIC;
		protected boolean mArrivalTimeInsteadOfRestTime = false;

		@Override
		public void setDataConnectionStrength(final int dataConnectionStrength) {
			/* Not displayed. */
		}

		@Override
		public void setEstimatedRestSeconds(final int pEstimatedRestSeconds) {
			final int estimatedTimeLeftMinutes;
			if(pEstimatedRestSeconds == Constants.NOT_SET) {
				return;
			}


			estimatedTimeLeftMinutes = (pEstimatedRestSeconds + 15)/ 60; /* The last 15 seconds will show "0:00" */

			if(this.mArrivalTimeInsteadOfRestTime){
				BigArrowHUDImpl.this.mTvTimeRemaining.setText(TimeUtils.getTimeString(estimatedTimeLeftMinutes));
			}else{
				BigArrowHUDImpl.this.mTvTimeRemaining.setText(TimeUtils.getTimeDurationString(estimatedTimeLeftMinutes));
			}
		}

		@Override
		public void setGPSConnectionStrength(final int pConnectionStrength) {
			/* Not displayed. */
		}

		@Override
		public void setMetersDrivenSession(final int pMetersDriven) {
			final String[] pParts = this.mUnitSystem.getDistanceString(pMetersDriven, null);
			BigArrowHUDImpl.this.mTvLengthRemaining.setText(pParts[UnitSystem.DISTSTRINGS_DIST_ID] + " " + pParts[UnitSystem.DISTSTRINGS_UNIT_ID]);
		}

		@Override
		public void onClick() {
			this.mArrivalTimeInsteadOfRestTime = !this.mArrivalTimeInsteadOfRestTime;
		}

		@Override
		public void recycle() {

		}

		@Override
		public void reset() {
			BigArrowHUDImpl.this.mTvLengthRemaining.setText("");
			BigArrowHUDImpl.this.mTvTimeRemaining.setText("");
			BigArrowHUDImpl.this.mTvTurnDescription.setText("");
		}

		@Override
		public void setDisplayQuality(final int pDisplayQuality) {
			/* Nothing, because the views are TextViews only. */
		}

		@Override
		public void setDistance(final int pMeterDistance) {
			if(pMeterDistance != Constants.NOT_SET){
				final String[] pParts = this.mUnitSystem.getDistanceString(pMeterDistance, null);
				BigArrowHUDImpl.this.mTvLengthRemaining.setText(pParts[UnitSystem.DISTSTRINGS_DIST_ID] + " " + pParts[UnitSystem.DISTSTRINGS_UNIT_ID]);
			}
		}

		@Override
		public void setUnitSystem(final UnitSystem pUnitSystem) {
			this.mUnitSystem = pUnitSystem;
		}

		@Override
		public void setRemainingSummaryOnClickListener(final OnClickListener pOnClickListener) {
			BigArrowHUDImpl.this.mTvTimeRemaining.setOnClickListener(pOnClickListener);
			BigArrowHUDImpl.this.mTvLengthRemaining.setOnClickListener(pOnClickListener);
		}

		@Override
		public String getTurnDescription() {
			return BigArrowHUDImpl.this.mTvTurnDescription.getText().toString();
		}

		@Override
		public void setTurnDescription(final String pTurnDescription) {
			BigArrowHUDImpl.this.mTvTurnDescription.setText(pTurnDescription);
		}

		@Override
		public void setTurnDescriptionOnClickListener(final OnClickListener pOnClickListener) {
			BigArrowHUDImpl.this.mTvTurnDescription.setOnClickListener(pOnClickListener);
		}
	}

	private static final IHUDImplVariation[] VARIATIONS = new IHUDImplVariation[]{
		new IHUDImplVariation(){
			@Override
			public int getLayoutID() {
				return  R.layout.ddmap_hud_bigarrow_default;
			}

			@Override
			public int getVariationID() {
				return VARIATION_DEFAULT_ID;
			}

			@Override
			public DirectionArrowDescriptor getDirectionArrowDescriptor() {
				return new DirectionArrowDescriptor(new Point(20,20), R.drawable.hud_basic_variation_default_direction_arrow);
			}

			@Override
			public int getDescriptionStringID() {
				return R.string.hud_bigarrow_variation_default;
			}

			@Override
			public int getScreenshotResourceID() {
				return R.drawable.hud_bigarrow_variation_default_sample;
			}
		},
		new IHUDImplVariation(){
			@Override
			public int getLayoutID() {
				return  R.layout.ddmap_hud_bigarrow_variation_1;
			}

			@Override
			public int getVariationID() {
				return VARIATION_DEFAULT_ID + 1;
			}

			@Override
			public DirectionArrowDescriptor getDirectionArrowDescriptor() {
				return new DirectionArrowDescriptor(new Point(20,20), R.drawable.hud_basic_variation_default_direction_arrow);
			}

			@Override
			public int getDescriptionStringID() {
				return R.string.hud_bigarrow_variation_1;
			}

			@Override
			public int getScreenshotResourceID() {
				return R.drawable.hud_bigarrow_variation_1_sample;
			}
		}
	};
}
