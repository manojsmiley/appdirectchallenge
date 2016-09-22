package com.appdirect.client.action;

public interface IAppDirectAction {
   <T> ActionResult<T> execute(Class<T> resultType);
}
