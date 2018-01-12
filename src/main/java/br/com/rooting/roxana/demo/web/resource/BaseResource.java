package br.com.rooting.roxana.demo.web.resource;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rooting.roxana.message.Message;
import br.com.rooting.roxana.message.builder.MessageBuilder;
import br.com.rooting.roxana.message.builder.MessageBuilderFactory;
import br.com.rooting.roxana.message.mapper.MessageMapperEnum;

public abstract class BaseResource {
	
	private MessageBuilder messageBuilder;
	
	public Message buildMessage(MessageMapperEnum enumMapper, Object...parametersValues) {
		return this.getMessageBuilder().build(enumMapper, parametersValues);
	}
	
	private MessageBuilder getMessageBuilder() {
		return messageBuilder;
	}

	@Autowired
	private void setMessageBuilder(final MessageBuilderFactory factory) {
		this.messageBuilder = factory.getMessageBuilder();
	}
	
}
