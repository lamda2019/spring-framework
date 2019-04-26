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

package org.springframework.web.reactive.result.condition;

import org.springframework.lang.Nullable;
import org.springframework.web.server.ServerWebExchange;

//RequestCondition接口用于保存从request提取出的用于匹配Handler的条件
public interface RequestCondition<T> {


	T combine(T other);


	@Nullable
	T getMatchingCondition(ServerWebExchange exchange);


	int compareTo(T other, ServerWebExchange exchange);

}
