package com.inossem.wms.common.exception;

import org.apache.shiro.authc.DisabledAccountException;

/**
 * A special kind of <tt>DisabledAccountException</tt>, this exception is thrown when attempting
 * to authenticate and the corresponding account has been disabled explicitly due to being locked.
 *
 * <p>For example, an account can be locked if an administrator explicitly locks an account or
 * perhaps an account can be locked automatically by the system if too many unsuccessful
 * authentication attempts take place during a specific period of time (perhaps indicating a
 * hacking attempt).
 *
 * @since 0.1
 */
public class FreeznAccountException extends DisabledAccountException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8907558415596397334L;

	/**
     * Creates a new LockedAccountException.
     */
    public FreeznAccountException() {
        super();
    }

    /**
     * Constructs a new LockedAccountException.
     *
     * @param message the reason for the exception
     */
    public FreeznAccountException(String message) {
        super(message);
    }

    /**
     * Constructs a new LockedAccountException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public FreeznAccountException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new LockedAccountException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public FreeznAccountException(String message, Throwable cause) {
        super(message, cause);
    }

}
