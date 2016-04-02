package com.bfsi.mfi.service;
import java.util.List;

import com.bfsi.mfi.vo.AgentTransactionVO;
public interface AuthCheckService {
 void checkAuthStatus(List<AgentTransactionVO> txnlist);
}
