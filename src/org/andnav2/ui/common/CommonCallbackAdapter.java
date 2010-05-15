/**
 * 
 */
package org.andnav2.ui.common;

/**
 * @author Nicolas Gramlich
 * @since 17:28:42 - 01.06.2009
 */
public abstract class CommonCallbackAdapter<T extends Object> implements CommonCallback<T>{
	@Override
	public abstract void onSuccess(final T result);
	@Override
	public void onFailure(final Throwable t){ /* Nothing */ }
}
