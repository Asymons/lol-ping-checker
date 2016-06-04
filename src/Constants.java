
public enum Constants {
	NA("104.160.131.3"),EUW("104.160.141.3"),EUNE("104.160.142.3"),OCE("104.160.156.1"),LAN("104.160.136.3");
	
	private String ip;
	
	Constants(String ip){
		this.ip = ip;
	}
	
	public String getIp(){
		return ip;
	}
}
