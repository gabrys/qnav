// Created by plusminus on 7:18:35 PM - Feb 18, 2009
package org.andnav2.ui.map.hud.impl.basic;

import org.andnav2.R;
import org.andnav2.osm.views.overlay.util.DirectionArrowDescriptor;
import org.andnav2.ui.map.hud.IHUDImpl;
import org.andnav2.ui.map.hud.IHUDImplVariation;
import org.andnav2.ui.map.hud.IHUDNextActionView;
import org.andnav2.ui.map.hud.IHUDRemainingSummaryView;
import org.andnav2.ui.map.hud.IHUDTurnDescriptionView;
import org.andnav2.ui.map.hud.impl.basic.views.HUDNextActionView;
import org.andnav2.ui.map.hud.impl.basic.views.HUDRemainingSummaryView;
import org.andnav2.ui.map.hud.impl.basic.views.HUDTurnDescriptionView;
import org.andnav2.ui.map.hud.impl.basic.views.HUDUpperNextActionView;
import org.andnav2.ui.map.hud.util.Util;

import android.graphics.Point;
import android.view.View;


public class BasicHUDImpl implements IHUDImpl {
	// ===========================================================
	// Constants
	// ===========================================================

	public static final int ID = 0;

	// ===========================================================
	// Fields
	// ===========================================================

	private HUDNextActionView mHUDNextActionView;
	private HUDUpperNextActionView mHUDUpperNextActionView;
	private HUDRemainingSummaryView mHUDRemainingSummaryView;
	private HUDTurnDescriptionView mHUDTurnDescriptionView;

	// ===========================================================
	// Constructors
	// ===========================================================

	@Override
	public void init(final View pRootView) {
		this.mHUDNextActionView = (HUDNextActionView) pRootView.findViewById(R.id.hud_ddmap_basic_nextaction);
		this.mHUDUpperNextActionView = (HUDUpperNextActionView) pRootView.findViewById(R.id.hud_ddmap_basic_uppernextaction);
		this.mHUDRemainingSummaryView = (HUDRemainingSummaryView) pRootView.findViewById(R.id.hud_ddmap_basic_summary);
		this.mHUDTurnDescriptionView = (HUDTurnDescriptionView) pRootView.findViewById(R.id.hud_ddmap_basic_turndescription);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	@Override
	public IHUDTurnDescriptionView getTurnTurnDescriptionView() {
		return this.mHUDTurnDescriptionView;
	}

	@Override
	public IHUDNextActionView getNextActionView() {
		return this.mHUDNextActionView;
	}

	@Override
	public IHUDNextActionView getUpperNextActionView() {
		return this.mHUDUpperNextActionView;
	}

	@Override
	public IHUDRemainingSummaryView getRemainingSummaryView() {
		return this.mHUDRemainingSummaryView;
	}

	// ===========================================================
	// Methods from SuperClass/Interfaces
	// ===========================================================

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public IHUDImplVariation getVariation(final int pVariationID) {
		return Util.getVariation(VARIATIONS, pVariationID);
	}

	@Override
	public void setUpperNextActionViewNecessary(final boolean pNecessary) {
		this.mHUDUpperNextActionView.setVisibility((pNecessary) ? View.VISIBLE : View.GONE);
	}

	@Override
	public void invalidateViews() {
		this.mHUDNextActionView.postInvalidate();
		this.mHUDUpperNextActionView.postInvalidate();
		this.mHUDRemainingSummaryView.postInvalidate();
	}

	@Override
	public int getCountOfVariations() {
		return VARIATIONS.length;
	}

	@Override
	public int getNameResourceID() {
		return R.string.hud_basic_name;
	}

	@Override
	public int getDescriptionResourceID() {
		return R.string.hud_basic_description;
	}

	@Override
	public IHUDImplVariation[] getVariations() {
		return VARIATIONS;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

	private static final IHUDImplVariation[] VARIATIONS = new IHUDImplVariation[]{
		new IHUDImplVariation(){
			@Override
			public int getLayoutID() {
				return  R.layout.ddmap_hud_basic_default;
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
				return R.string.hud_basic_variation_default;
			}

			@Override
			public int getScreenshotResourceID() {
				return R.drawable.hud_basic_variation_default_sample;
			}
		},
		new IHUDImplVariation(){
			@Override
			public int getLayoutID() {
				return  R.layout.ddmap_hud_basic_variation_1;
			}

			@Override
			public int getVariationID() {
				return VARIATION_DEFAULT_ID + 1;
			}

			@Override
			public DirectionArrowDescriptor getDirectionArrowDescriptor() {
				return new DirectionArrowDescriptor(new Point(24,30), R.drawable.hud_mavoric_variation_default_direction_arrow);
			}

			@Override
			public int getDescriptionStringID() {
				return R.string.hud_basic_variation_1;
			}

			@Override
			public int getScreenshotResourceID() {
				return R.drawable.hud_basic_variation_1_sample;
			}
		}
	};
}
