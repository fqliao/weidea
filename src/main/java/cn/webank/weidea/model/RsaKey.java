package cn.webank.weidea.model;

public class RsaKey {
	private String publicRsaKey;
	private String privateRsaKey;

	public RsaKey() {
	}

	public RsaKey(String publicRsaKey, String privateRsaKey) {
		super();
		this.publicRsaKey = publicRsaKey;
		this.privateRsaKey = privateRsaKey;
	}

	public String getPublicRsaKey() {
		return publicRsaKey;
	}

	public void setPublicRsaKey(String publicRsaKey) {
		this.publicRsaKey = publicRsaKey;
	}

	public String getPrivateRsaKey() {
		return privateRsaKey;
	}

	public void setPrivateRsaKey(String privateRsaKey) {
		this.privateRsaKey = privateRsaKey;
	}
}
