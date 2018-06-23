package br.com.rooting.roxana.demo.web.resource.client;

import static br.com.rooting.roxana.message.MessageSeverity.SUCCESS;

import br.com.rooting.roxana.message.MessageSeverity;
import br.com.rooting.roxana.message.mapper.MessageMapperEnum;
import br.com.rooting.roxana.parameter.mapper.Param;

enum ClientResourceMP implements MessageMapperEnum {
	
	@Param("id")
	CLIENT_CREATED(SUCCESS),
	
	@Param("id")
	CLIENT_ALTERED(SUCCESS),
	
	@Param("id")
	@Param("credits")
	CREDITS_ADDED(SUCCESS),
	
	@Param("id")
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