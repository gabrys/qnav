// Created by plusminus on 12:17:26 AM - Apr 21, 2009
package org.andnav2.sys.ors.adt.ts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.andnav2.osm.adt.BoundingBoxE6;
import org.andnav2.osm.adt.IGeoPoint;

import com.openmap.util.quadtree.QuadTree;


public class ListBackedQuadTreeOrganizer<T extends IGeoPoint> implements ISpatialDataOrganizer<T> {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private final QuadTree<T> mQuadTree;

	protected final List<T> mFeatureList = new ArrayList<T>();

	// ===========================================================
	// Constructors
	// ===========================================================

	public ListBackedQuadTreeOrganizer() {
		this.mQuadTree = new QuadTree<T>();
	}

	public ListBackedQuadTreeOrganizer(final List<T> pItems) {
		this();
		addAll(pItems);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	@Override
	public boolean isIndexBuilt() {
		return true;
	}

	@Override
	public List<T> getItems() {
		return this.mFeatureList;
	}

	@Override
	public void add(final T pItem) {
		if(pItem != null){
			this.mQuadTree.put(pItem.getLatitudeE6(), pItem.getLongitudeE6(), pItem);
			this.mFeatureList.add(pItem);
		}
	}

	@Override
	public void addAll(final Collection<T> pItems){
		if(pItems != null) {
			for(final T item : pItems) {
				this.add(item);
			}
		}
	}

	// ===========================================================
	// Methods from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	@Override
	public void clearIndex(){
		this.mFeatureList.clear();
		this.mQuadTree.clear();
	}

	@Override
	public void buildIndex(){
		/* Index is always built. */
	}

	@Override
	public List<T> getClosest(final IGeoPoint pGeoPoint, final int pCount){
		throw new IllegalStateException("Wrong method!");
	}

	@Override
	public List<T> getWithinBoundingBox(final BoundingBoxE6 pBoundingBoxE6, final int count) {
		final List<T> out = this.mQuadTree.get(pBoundingBoxE6.getLatNorthE6(),
				pBoundingBoxE6.getLonWestE6(),
				pBoundingBoxE6.getLatSouthE6(),
				pBoundingBoxE6.getLonEastE6());
		// TODO respect count.
		return out;
	}

	@Override
	public GetMode getGetMode() {
		return GetMode.BOUNDINGBOX;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}