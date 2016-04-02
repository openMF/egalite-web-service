package com.bfsi.mfi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Collection of permissions for the view
 * 
 * @author arun
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionCollection {
	/**
	 * @return
	 */
	Permission[] value();
}
