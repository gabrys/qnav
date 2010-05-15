// Created by plusminus on 12:40:07 AM - Apr 5, 2009
package org.andnav2.sys.turninstructions;

public class TurnInstructionSet implements ITurnInstructionsSet {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private String mOn;
	private String mVehicle;
	private String mUTurn;
	private String mStraightForward;
	private String mStartTag;
	private String mSharpRight;
	private String mSharpLeft;
	private String mSeconds;
	private String mSecond;
	private String mRight;
	private String mPedestrian;
	private String mMinutes;
	private String mMinute;
	private String mLeft;
	private String mHours;
	private String mHour;
	private String mHalfRight;
	private String mHalfLeft;
	private String mFor;
	private String mEndTag;
	private String mDays;
	private String mDay;
	private String mCurve;
	private String mBefore;
	private String mApproximation;
	private String mAfter;
	private String mActionNumber;
	private String mThenCommandWithoutDistance;
	private String mThenCommandWithDistance;
	private String mMeters;
	private String mKilometers;
	private String mYards;
	private String mMiles;

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods from SuperClass/Interfaces
	// ===========================================================

	@Override
	public String getMeters() {
		return this.mMeters;
	}

	@Override
	public String getKilometers() {
		return this.mKilometers;
	}

	@Override
	public String getYards() {
		return this.mYards;
	}

	@Override
	public String getMiles() {
		return this.mMiles;
	}

	@Override
	public String getActionNumber() {
		return this.mActionNumber;
	}

	@Override
	public String getAfter() {
		return this.mAfter;
	}

	@Override
	public String getAppoximation() {
		return this.mApproximation;
	}

	@Override
	public String getBefore() {
		return this.mBefore;
	}

	@Override
	public String getCurve() {
		return this.mCurve;
	}

	@Override
	public String getDay() {
		return this.mDay;
	}

	@Override
	public String getDays() {
		return this.mDays;
	}

	@Override
	public String getEndTag() {
		return this.mEndTag;
	}

	@Override
	public String getFor() {
		return this.mFor;
	}

	@Override
	public String getHalfLeft() {
		return this.mHalfLeft;
	}

	@Override
	public String getHalfRight() {
		return this.mHalfRight;
	}

	@Override
	public String getHour() {
		return this.mHour;
	}

	@Override
	public String getHours() {
		return this.mHours;
	}

	@Override
	public String getLeft() {
		return this.mLeft;
	}

	@Override
	public String getMinute() {
		return this.mMinute;
	}

	@Override
	public String getMinutes() {
		return this.mMinutes;
	}

	@Override
	public String getOn() {
		return this.mOn;
	}

	@Override
	public String getPedestrian() {
		return this.mPedestrian;
	}

	@Override
	public String getRight() {
		return this.mRight;
	}

	@Override
	public String getSecond() {
		return this.mSecond;
	}

	@Override
	public String getSeconds() {
		return this.mSeconds;
	}

	@Override
	public String getSharpLeft() {
		return this.mSharpLeft;
	}

	@Override
	public String getSharpRight() {
		return this.mSharpRight;
	}

	@Override
	public String getStartTag() {
		return this.mStartTag;
	}

	@Override
	public String getStraightForward() {
		return this.mStraightForward;
	}

	@Override
	public String getUTurn() {
		return this.mUTurn;
	}

	@Override
	public String getVehicle() {
		return this.mVehicle;
	}

	@Override
	public String getThenCommandWithDistance() {
		return this.mThenCommandWithDistance;
	}

	@Override
	public String getThenCommandWithoutDistance() {
		return this.mThenCommandWithoutDistance;
	}

	public void setOn(final String pOn) {
		this.mOn = pOn;
	}

	public void setVehicle(final String pVehicle) {
		this.mVehicle = pVehicle;
	}

	public void setUTurn(final String pTurn) {
		this.mUTurn = pTurn;
	}

	public void setStraightForward(final String pStraightForward) {
		this.mStraightForward = pStraightForward;
	}

	public void setStartTag(final String pStartTag) {
		this.mStartTag = pStartTag;
	}

	public void setSharpRight(final String pSharpRight) {
		this.mSharpRight = pSharpRight;
	}

	public void setSharpLeft(final String pSharpLeft) {
		this.mSharpLeft = pSharpLeft;
	}

	public void setSeconds(final String pSeconds) {
		this.mSeconds = pSeconds;
	}

	public void setSecond(final String pSecond) {
		this.mSecond = pSecond;
	}

	public void setRight(final String pRight) {
		this.mRight = pRight;
	}

	public void setPedestrian(final String pPedestrian) {
		this.mPedestrian = pPedestrian;
	}

	public void setMinutes(final String pMinutes) {
		this.mMinutes = pMinutes;
	}

	public void setMinute(final String pMinute) {
		this.mMinute = pMinute;
	}

	public void setLeft(final String pLeft) {
		this.mLeft = pLeft;
	}

	public void setHours(final String pHours) {
		this.mHours = pHours;
	}

	public void setHour(final String pHour) {
		this.mHour = pHour;
	}

	public void setHalfRight(final String pHalfRight) {
		this.mHalfRight = pHalfRight;
	}

	public void setHalfLeft(final String pHalfLeft) {
		this.mHalfLeft = pHalfLeft;
	}

	public void setFor(final String pFor) {
		this.mFor = pFor;
	}

	public void setEndTag(final String pEndTag) {
		this.mEndTag = pEndTag;
	}

	public void setDays(final String pDays) {
		this.mDays = pDays;
	}

	public void setDay(final String pDay) {
		this.mDay = pDay;
	}

	public void setCurve(final String pCurve) {
		this.mCurve = pCurve;
	}

	public void setBefore(final String pBefore) {
		this.mBefore = pBefore;
	}

	public void setApproximation(final String pApproximation) {
		this.mApproximation = pApproximation;
	}

	public void setAfter(final String pAfter) {
		this.mAfter = pAfter;
	}

	public void setActionNumber(final String pActionNumber) {
		this.mActionNumber = pActionNumber;
	}

	public void setThenCommandWithDistance(final String pCommand) {
		this.mThenCommandWithDistance = pCommand;
	}

	public void setThenCommandWithoutDistance(final String pCommand) {
		this.mThenCommandWithoutDistance = pCommand;
	}

	public void setMeters(final String pMeters) {
		this.mMeters = pMeters;
	}

	public void setKilometers(final String pKilometers) {
		this.mKilometers = pKilometers;
	}

	public void setYards(final String pYards) {
		this.mYards = pYards;
	}

	public void setMiles(final String pMiles) {
		this.mMiles = pMiles;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
