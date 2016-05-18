package services;

import java.util.HashMap;

import middleware.ClientProxy;

public class NamingService {
	
	private HashMap<String, ClientProxy> proxies;

	public NamingService() {
		super();
		this.proxies = new HashMap<String, ClientProxy>();
	}
	
	public void bind(String name, ClientProxy proxy){
		proxies.put(name, proxy);
	}
	
	public ClientProxy lookup(String name) {
		return proxies.get(name);
	}

	public HashMap<String, ClientProxy> getProxies() {
		return proxies;
	}

	public void setProxies(HashMap<String, ClientProxy> proxies) {
		this.proxies = proxies;
	}
	
}
