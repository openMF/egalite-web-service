package com.bfsi.mfi.cbs.adapter;

/**
 * 
 * @author Shabu S Francis
 * 
 */
public enum CbsActionType {

	SYNCLOANS {
		@Override
		public String toString() {
			return "SYNCLOANS";
		}
	},
	SYNCDEPOSITS {
		@Override
		public String toString() {
			return "SYNCDEPOSITS";
		}
	},
	SYNCCUSTOMERS {
		@Override
		public String toString() {
			return "SYNCCUSTOMERS";
		}
	},
	SYNCBRANCHES {
		@Override
		public String toString() {
			return "SYNCBRANCHES";
		}
	},
	SYNCCURRENCY {
		@Override
		public String toString() {
			return "SYNCCURRENCY";
		}
	},
	SYNCFXRATES {
		@Override
		public String toString() {
			return "SYNCFXRATES";
		}
	},
	CASHDEPOSIT {
		@Override
		public String toString() {
			return "CASHDEPOSIT";
		}
	},
	CASHWITHDRAW {
		@Override
		public String toString() {
			return "CASHWITHDRAW";
		}
	},
	LOANREPAYMENT {
		@Override
		public String toString() {
			return "LOANREPAYMENT";
		}
	},
	LOANDISBUREMENT {
		@Override
		public String toString() {
			return "LOANDISBUREMENT";
		}
	},
	SYNCCUSTACCOUNTS {
		@Override
		public String toString() {
			return "SYNCCUSTACCOUNTS";
		}
	},
	SYNCCBSGENTRANS {
		@Override
		public String toString() {
			return "SYNCCBSGENTRANS";
		}
	},
	ENROLLCUSTOMER {
		@Override
		public String toString() {
			return "ENROLLCUSTOMER";
		}
	},
	CBSBUSINESSDATE {
		@Override
		public String toString() {
			return "CBSBUSINESSDATE";
		}
	},
	LOANPREPAYMENT {
		@Override
		public String toString() {
			return "LOANPREPAYMENT";
		}
	},
	DEPOSITCOLLECTION {
		@Override
		public String toString() {
			return "DEPOSITCOLLECTION";
		}
	},
	DEPOSITMATURITYPAYOUT {
		@Override
		public String toString() {
			return "DEPOSITMATURITYPAYOUT";
		}
	},
	DEPOSITREDEMPTIONPAYOUT {
		@Override
		public String toString() {
			return "DEPOSITREDEMPTIONPAYOUT";
		}
	},
	DEPOSITPREPAYREQUEST {
		@Override
		public String toString() {
			return "DEPOSITPREPAYREQUEST";
		}
	},
	DEPOSITNEWACCREQUEST {
		@Override
		public String toString() {
			return "DEPOSITNEWACCREQUEST";
		}
	},
	TRANSGENRERICREQUEST {
		@Override
		public String toString() {
			return "TRANSGENRERICREQUEST";
		}
	},
	DROPLISTREQUEST {
		@Override
		public String toString() {
			return "DROPLISTREQUEST";
		}
	};
	public String value() {
		return name();
	}

}
