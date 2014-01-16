/*
 * Copyright 2013 the original author or authors.
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

package org.springframework.aws;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aws.cloud.AWSTools;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

/**
 * The component resets the IP permissions in a security group.
 * 
 * @author glenn renfro
 * 
 */
@Component
public class AWSMaintenance {
	/**
	 * @param args
	 */
	private final static Logger LOGGER = LoggerFactory
			.getLogger(AWSMaintenance.class);


	public void changePermissions(String name) throws TimeoutException, IOException {
		AWSTools tools = new AWSTools(getProperties());
		tools.changePermissions(name);
}
	
	private Properties getProperties() throws IOException {
		Resource resource = new ClassPathResource("aws.properties");
		Properties props = null;
		try {
			props = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException ioe) {
			LOGGER.error("Failed to open aws.properties file because: "
					+ ioe.getMessage());
			throw ioe;
		}
		return props;
	}

}
