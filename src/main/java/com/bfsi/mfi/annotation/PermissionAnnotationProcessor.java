package com.bfsi.mfi.annotation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Processes permission annotation provided on top of the class
 * 
 * @author arun
 * 
 */
public class PermissionAnnotationProcessor {
	@SuppressWarnings("rawtypes")
	private static Map<Class, PermissionCollection> controllerPermissions = new ConcurrentHashMap<Class, PermissionCollection>();

	/**
	 * Returns the permission string for given type
	 * 
	 * @param permType
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getPermissionString(Class clazz,
			PermissionType permType) {
		if (!controllerPermissions.containsKey(clazz)) {
			loadPemissionList(clazz);
		}
		PermissionCollection permissionList = controllerPermissions.get(clazz);
		if (permissionList != null) {
			for (Permission permission : permissionList.value()) {
				if (permission.type() == permType) {
					return permission.name();
				}
			}
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void loadPemissionList(Class clazz) {
		PermissionCollection permCollection = (PermissionCollection) clazz
				.getAnnotation(PermissionCollection.class);
		if (permCollection != null) {
			controllerPermissions.put(clazz, permCollection);
		}
	}

}
