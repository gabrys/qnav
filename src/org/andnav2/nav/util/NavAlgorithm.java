// Created by plusminus on 17:37:55 - 12.12.2008
package org.andnav2.nav.util;

import java.util.List;

import org.andnav2.osm.adt.GeoPoint;
import org.andnav2.util.constants.Constants;

import android.graphics.Point;


public class  NavAlgorithm implements Constants{
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected static final int[] SEARCHINDEX_OFFSETS = new int[] {
		0, 1, 2, 3, 4, 5, 6, -1, 7, -2, 8, -3, 9, -4, 10, -5, 11, -6, 12, -7, 13, -8, 14, -9, 15, -10, 16, -11, 17, -12, 18, -13, 19, -14, 20, -15, 21, -16, 22, -17, 23, -18, 24, -19, 25, -20, 26, -21, 27, -22, 28, -23, 29, -24, 30, -25, 31, -26, 32, -27, 33, -28, 34, -29, 35, -30, 36, -31, 37, -32, 38, -33, 39, -34, 40, -35, 41, -36, 42, -37, 43, -38, 44, -39, 45, -40, 46, -41, 47, -42, 48, -43, 49, -44, 50, -45, 51, -46, 52, -47, 53, -48, 54, -49, 55, -50, 56, -51, 57, -52, 58, -53, 59, -54, 60, -55, 61, -56, 62, -57, 63, -58, 64, -59, 65, -60, 66, -61, 67, -62, 68, -63, 69, -64, 70, -65, 71, -66, 72, -67, 73, -68, 74, -69, 75, -70, 76, -71, 77, -72, 78, -73, 79, -74, 80, -75, 81, -76, 82, -77, 83, -78, 84, -79, 85, -80, 86, -81, 87, -82, 88, -83, 89, -84, 90, -85, 91, -86, 92, -87, 93, -88, 94, -89, 95, -90, 96, -91, 97, -92, 98, -93, 99, -94, 100, -95, 101, -96, 102, -97, 103, -98, 104, -99, 105, -100, 106, -101, 107, -102, 108, -103, 109, -104, 110, -105, 111, -106, 112, -107, 113, -108, 114, -109, 115, -110, 116, -111, 117, -112, 118, -113, 119, -114, 120, -115, 121, -116, 122, -117, 123, -118, 124, -119, 125, -120, 126, -121, 127, -122, 128, -123, 129, -124, 130, -125, 131, -126, 132, -127, 133, -128, 134, -129, 135, -130, 136, -131, 137, -132, 138, -133, 139, -134, 140, -135, 141, -136, 142, -137, 143, -138, 144, -139, 145, -140, 146, -141, 147, -142, 148, -143, 149, -144, 150, -145, 151, -146, 152, -147, 153, -148, 154, -149, 155, -150, 156, -151, 157, -152, 158, -153, 159, -154, 160, -155, 161, -156, 162, -157, 163, -158, 164, -159, 165, -160, 166, -161, 167, -162, 168, -163, 169, -164, 170, -165, 171, -166, 172, -167, 173, -168, 174, -169, 175, -170, 176, -171, 177, -172, 178, -173, 179, -174, 180, -175, 181, -176, 182, -177, 183, -178, 184, -179, 185, -180, 186, -181, 187, -182, 188, -183, 189, -184, 190, -185, 191, -186, 192, -187, 193, -188, 194, -189, 195, -190, 196, -191, 197, -192, 198, -193, 199, -194, 200, -195, 201, -196, 202, -197, 203, -198, 204, -199};

	public static int BASE_SEARCHINDEX_COUNT = 40; // Search some indizes.
	public static int MAX_SEARCHINDEX_COUNT = SEARCHINDEX_OFFSETS.length; // Search all indizes.

	/** Distance in meters. */
	public static int DISTANCE_TO_TOGGLE_OFF_ROUTE = 30;

	/** Distance <b>NOT</b> in meters. */
	private static final int PSEUDO_DISTANCE_TO_SNAP_ON_ROUTE = 25; // <-- TODO is it a problem, because it is not a real distance?

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public static int getDISTANCE_TO_TOGGLE_OFF_ROUTE() {
		return DISTANCE_TO_TOGGLE_OFF_ROUTE;
	}

	public static void setDISTANCE_TO_TOGGLE_OFF_ROUTE(final int aDistanceToToggleOffRoute) {
		DISTANCE_TO_TOGGLE_OFF_ROUTE = aDistanceToToggleOffRoute;
	}

	// ===========================================================
	// Methods from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * 
	 */
	public static int getClosestIndex(final List<GeoPoint> polyLine, final Point pPointToGetClosestIndexFor, final int pSearchIndexToStartWith, final int pNumberOfCyclesToSearch){

		final int polyLineLength = polyLine.size();

		/* We will search around the lastActiveIndex in a jumping-manner. */
		int iteration = 0;

		int indexOfClosest = NOT_SET;

		final int maxSearchCount = Math.min(SEARCHINDEX_OFFSETS.length, pNumberOfCyclesToSearch);

		float currentMinDistance = Float.MAX_VALUE;

		/* Get index in route. */
		// TODO Use extracted method in OSMMapViewSimpleTraceOverlay and also in MapDrivingDirectionsOverlay
		while (iteration < maxSearchCount) {
			/* Calculate the index to be tested. */
			final int testIndex = pSearchIndexToStartWith + calculateNextIndex(iteration);
			if (testIndex < polyLineLength && testIndex > 0) {
				final float dist = Util.getDistanceToLine(polyLine.get(testIndex - 1), polyLine.get(testIndex), pPointToGetClosestIndexFor);
				if (dist < currentMinDistance) {
					indexOfClosest = testIndex;
					currentMinDistance = dist;

					/* Check if the distance found is 'close enough'. */
					if (currentMinDistance < PSEUDO_DISTANCE_TO_SNAP_ON_ROUTE) {
						break;
					}
				}
			}
			iteration++;
		}

		return indexOfClosest;
	}

	private static int calculateNextIndex(final int pIteration) {
		return SEARCHINDEX_OFFSETS[pIteration];
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
