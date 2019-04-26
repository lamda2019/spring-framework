/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//业务容器

//实现Root WebApplicationContext容器的初始化
//该类由Spring框架提供
public class ContextLoaderListener extends ContextLoader implements ServletContextListener {
	public ContextLoaderListener() {
	}

	public ContextLoaderListener(WebApplicationContext context) {
		super(context);
	}

	/**
	 * 在Servlet容器（Tomcat,Jetty)启动的时候，会被ContextLoaderListener监听到，
	 * 从而调用contextInitialized(ServletContextEvent event)方法，
	 * 实现对Root WebApplicationContext容器的初始化
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		//初始化WebApplicationContext容器
		initWebApplicationContext(event.getServletContext());
	}

	/**
	 * 在Servlet 容器关闭时，销毁 WebApplicationContext 容器。
	 * Close the root web application context.
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		//销毁WebApplicationContext容器，销毁逻辑暂时先留着
		closeWebApplicationContext(event.getServletContext());
		ContextCleanupListener.cleanupAttributes(event.getServletContext());
	}

}
