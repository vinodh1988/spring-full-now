package com.rest.utilities;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionState {
  private Integer state=0;
  
  public Integer getState() {
	return state;
  }
  
  public void setState() {
	  state++;
  }
}
