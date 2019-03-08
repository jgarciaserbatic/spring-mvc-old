/**
 * 
 */
package es.serbatic.base.dao.exception;

/**
 * Excepcion lanzada por el dao
 * @author jgarcia
 *
 */
public class SerbaticDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1787283214835165307L;

	public SerbaticDaoException() {
		super();
	}

	public SerbaticDaoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SerbaticDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public SerbaticDaoException(String message) {
		super(message);
	}

	public SerbaticDaoException(Throwable cause) {
		super(cause);
	}

}
