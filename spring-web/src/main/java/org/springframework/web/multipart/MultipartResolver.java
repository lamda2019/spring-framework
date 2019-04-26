/*
 * Copyright 2002-2015 the original author or authors.
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

package org.springframework.web.multipart;

import javax.servlet.http.HttpServletRequest;

//处理上传请求
public interface MultipartResolver {

    //判断是不是上传请求
	boolean isMultipart(HttpServletRequest request);

   //将普通请求封装成上传请求MultipartHttpServletRequest
	MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException;

	//处理完后清理上传过程中产生的临时资源
	void cleanupMultipart(MultipartHttpServletRequest request);

}
