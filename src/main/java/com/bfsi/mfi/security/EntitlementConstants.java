package com.bfsi.mfi.security;

/**
 * List of entitlements / permissions present in the MFI application that can be
 * used to check user permissions
 * 
 * @author arun
 */
public interface EntitlementConstants {
	public static final String USER_MGMT_LIST = "listUsers";
	public static final String USER_MGMT_ADD = "addUser";
	public static final String USER_MGMT_MODIFY = "modifyUser";
	public static final String USER_MGMT_DELETE = "deleteUser";
	public static final String USER_MGMT_AUTHORIZE = "authUser";

	public static final String ROLE_MGMT_LIST = "listRoles";
	public static final String ROLE_MGMT_ADD = "addRole";
	public static final String ROLE_MGMT_MODIFY = "modifyRole";
	public static final String ROLE_MGMT_DELETE = "deleteRole";
	public static final String ROLE_MGMT_AUTHORIZE = "authRole";

	public static final String AGENT_MGMT_LIST = "listAgents";
	public static final String AGENT_MGMT_ADD = "addAgent";
	public static final String AGENT_MGMT_MODIFY = "modifyAgent";
	public static final String AGENT_MGMT_DELETE = "deleteAgent";
	public static final String AGENT_MGMT_AUTHORIZE = "authAgent";

	public static final String DEVICE_MGMT_LIST = "listDevices";
	public static final String DEVICE_MGMT_ADD = "addDevice";
	public static final String DEVICE_MGMT_MODIFY = "modifyDevice";
	public static final String DEVICE_MGMT_DELETE = "deleteDevice";
	public static final String DEVICE_MGMT_AUTHORIZE = "authDevice";

	public static final String CASH_SETTLEMENT_LIST = "listCashSettlements";
	public static final String CASH_SETTLEMENT_ADD = "addCashSettlement";
	public static final String CASH_SETTLEMENT_DELETE = "deleteCashSettlement";
	public static final String CASH_SETTLEMENT_AUTHORIZE = "authCashSettlement";

}
