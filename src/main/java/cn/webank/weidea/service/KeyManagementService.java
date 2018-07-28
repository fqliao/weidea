package cn.webank.weidea.service;

import cn.webank.weidea.dto.DecryptReq;
import cn.webank.weidea.dto.KeyManagementRsp;
import cn.webank.weidea.entity.KeyManagement;

public interface KeyManagementService {
	public KeyManagementRsp secretKey(KeyManagement keyManagement);
	public KeyManagementRsp Decrypt(DecryptReq req);
}
