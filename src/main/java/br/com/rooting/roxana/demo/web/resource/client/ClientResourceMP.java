package br.com.rooting.roxana.demo.web.resource.client;

import static br.com.rooting.roxana.message.MessageSeverity.SUCCESS;

import br.com.rooting.roxana.message.MessageSeverity;
import br.com.rooting.roxana.message.mapper.MessageMapperEnum;
import br.com.rooting.roxana.message.mapper.parameter.MessageParameter;

enum ClientResourceMP implements MessageMapperEnum {
	
	@MessageParameter("id")
	CLIENT_CREATED(SUCCESS),
	
	@MessageParameter("id")
	CLIENT_ALTERED(SUCCESS),
	
	@MessageParameter("id")
	@MessageParameter("credits")
	CREDITS_ADDED(SUCCESS),
	
	@MessageParameter("id")
	CREDITS_CANCELLED(SUCCESS);
	
	private final MessageSeverity severity;
	
	private ClientResourceMP(final MessageSeverity severity) {
		this.severity = severity;
	}

	@Override
	public MessageSeverity getSeverity() {
		return this.severity;
	}

}