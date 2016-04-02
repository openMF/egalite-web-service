package com.bfsi.mfi.messages;

/**
 * 
 * @author Shabu
 *
 */
public enum AppMessageField {
	MSGCODE{
		@Override
		public String toString(){
			return "MSGCODE";
		}
	},
    MSGTYPE{
		@Override
		public String toString(){
			return "MSGTYPE";
		}
	},
    ERRTYPE{
		@Override
		public String toString(){
			return "ERRTYPE";
		}
	},
    MSGDESC{
		@Override
		public String toString(){
			return "MSGDESC";
		}
	},
    SUBSYS{
		@Override
		public String toString(){
			return "SUBSYS";
		}
	},
    LANG{
		@Override
		public String toString(){
			return "LANG";
		}
	}
    ;
	
	 public String value() {
	        return name();
	    }
	 
	 public static AppMessageField fromValue(String v) {
	        return valueOf(v);
	    }
}
