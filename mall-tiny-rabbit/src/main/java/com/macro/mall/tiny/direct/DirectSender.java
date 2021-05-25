/*
 * Copyright 2015-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.macro.mall.tiny.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by macro on 2020/5/19.
 */
public class DirectSender {

	@Autowired
	private RabbitTemplate template;

	private static final String exchangeName = "exchange.direct";

	private final String[] keys = {"orange", "black", "green"};

	private static final Logger LOGGER = LoggerFactory.getLogger(DirectSender.class);

	public void send(int index) {
		StringBuilder builder = new StringBuilder("Hello to ");
		int limitIndex = index % 3;
		String key = keys[limitIndex];
		builder.append(key).append(' ');
		builder.append(index+1);
		String message = builder.toString();
		template.convertAndSend(exchangeName, key, message);
		LOGGER.info(" [x] Sent '{}'", message);
	}

}
