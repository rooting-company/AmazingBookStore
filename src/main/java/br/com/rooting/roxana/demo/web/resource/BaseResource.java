package br.com.rooting.roxana.demo.web.resource;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rooting.roxana.message.Message;
import br.com.rooting.roxana.message.MessageCreator;
import br.com.rooting.roxana.message.MessageCreatorFactory;
import br.com.rooting.roxana.message.mapper.MessageMapperEnum;

public abstract class BaseResource {
	
	private MessageCreator messageCreator;
	
	public Message createMessage(MessageMapperEnum enumMapper, Object...parametersValues) {
		return this.getMessageCreator().create(enumMapper, parametersValues);
	}
	
	private MessageCreator getMessageCreator() {
		return messageCreator;
	}

	@Autowired
	private void setMessageBuilder(final MessageCreatorFactory factory) {
		this.messageCreator = factory.getMessageCreator();
	}
	
}
