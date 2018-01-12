package br.com.rooting.roxana.demo.web.resource.client;

import static br.com.rooting.roxana.message.MessageSeverity.SUCCESS;

import br.com.rooting.roxana.business.parameter.mapper.ParameterMapper;
import br.com.rooting.roxana.message.MessageSeverity;
import br.com.rooting.roxana.message.mapper.MessageMapperEnum;

enum ClientResourceMP implements MessageMapperEnum {
	
	@ParameterMapper("id")
	CLIENT_CREATED(SUCCESS),
	
	@ParameterMapper("id")
	CLIENT_ALTERED(SUCCESS),
	
	@ParameterMapper("id")
	@ParameterMapper("credits")
	CREDITS_ADDED(SUCCESS),
	
	@ParameterMapper("id")
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