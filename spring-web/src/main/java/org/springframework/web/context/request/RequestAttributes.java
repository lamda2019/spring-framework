/*
 * Copyright 2002-2017 the original author or authors.
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

package org.springframework.web.context.request;

import org.springframework.lang.Nullable;

/**
 * Abstraction for accessing attribute objects associated with a request.
 * Supports access to request-scoped attributes as well as to session-scoped
 * attributes, with the optional notion of a "global session".
 *
 * <p>Can be implemented for any kind of request/session mechanism,
 * in particular for servlet requests.
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see ServletRequestAttributes
 */
//	get/set/removeAttribute
public interface RequestAttributes {

	/**
	 * Constant that indicates request scope.
	 */
	int SCOPE_REQUEST = 0;

	/**
	 * Constant that indicates session scope.
	 * <p>This preferably refers to a locally isolated session, if such
	 * a distinction is available.
	 * Else, it simply refers to the common session.
	 */
	int SCOPE_SESSION = 1;


	/**
	 * Name of the standard reference to the request object: "request".
	 * @see #resolveReference
	 */
	String REFERENCE_REQUEST = "request";

	/**
	 * Name of the standard reference to the session object: "session".
	 * @see #resolveReference
	 */
	String REFERENCE_SESSION = "session";


	@Nullable
	Object getAttribute(String name, int scope);
	void setAttribute(String name, Object value, int scope);
	void removeAttribute(String name, int scope);
	String[] getAttributeNames(int scope);

	void registerDestructionCallback(String name, Runnable callback, int scope);

	@Nullable
	Object resolveReference(String key);

	String getSessionId();
	Object getSessionMutex();

}
