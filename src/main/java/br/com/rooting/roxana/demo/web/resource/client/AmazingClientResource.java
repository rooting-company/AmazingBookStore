package br.com.rooting.roxana.demo.web.resource.client;

import static br.com.rooting.roxana.demo.web.resource.client.ClientResourceMP.CLIENT_ALTERED;
import static br.com.rooting.roxana.demo.web.resource.client.ClientResourceMP.CLIENT_CREATED;
import static br.com.rooting.roxana.demo.web.resource.client.ClientResourceMP.CREDITS_ADDED;
import static br.com.rooting.roxana.demo.web.resource.client.ClientResourceMP.CREDITS_CANCELLED;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rooting.roxana.demo.domain.business.client.AmazingClientBusiness;
import br.com.rooting.roxana.demo.domain.business.client.InvalidCreditTransactionIdentifier;
import br.com.rooting.roxana.demo.domain.business.client.InvalidMoneyValue;
import br.com.rooting.roxana.demo.domain.model.AmazingClient;
import br.com.rooting.roxana.demo.domain.model.CreditTransaction;
import br.com.rooting.roxana.demo.web.resource.BaseResource;
import br.com.rooting.roxana.message.Message;
import br.com.rooting.roxana.response.FilledResponse;
import br.com.rooting.roxana.response.Response;
import br.com.rooting.roxana.response.ResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Transactional
@RestController
@RequestMapping(path = "/api/clients")
@Api(tags = "The Amazing Client Resources")
public class AmazingClientResource extends BaseResource {
	
	@Autowired
	private AmazingClientBusiness clientBusiness;
	
	@ResponseStatus(code = CREATED)
	@RequestMapping(method = POST)
	public @ResponseBody FilledResponse<ClientRespDTO> create(@RequestBody ClientReqDTO requestClient) {
		
		AmazingClient client = new AmazingClient();
		client = this.getClientBusiness().create(requestClient.mergeClient(client));
		
		Message sucess = this.createMessage(CLIENT_CREATED, client.getId());
		return ResponseBuilder.buildFilledWith(new ClientRespDTO(client), sucess);
	}
	
	@ResponseStatus(code = OK)
	@RequestMapping(method = GET, path = "/{id}")
	public @ResponseBody FilledResponse<ClientRespDTO> get(
			@ApiParam(value = "Client identifier", required = true) @PathVariable("id") Long id) {
		
		AmazingClient client = this.getClientBusiness().getClient(id);
		return ResponseBuilder.buildFilledWith(new ClientRespDTO(client));
	}
	
	@ResponseStatus(code = ACCEPTED)
	@RequestMapping(method = PUT, path = "/{id}")
	public @ResponseBody Response alter(
			@ApiParam(value = "Client identifier", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "Client informations", required = true) @RequestBody ClientReqDTO requestClient) {
		
		AmazingClient client = this.getClientBusiness().getClient(id);
		this.getClientBusiness().alter(requestClient.mergeClient(client));
		
		Message sucess = this.createMessage(CLIENT_ALTERED, client.getId());
		return ResponseBuilder.buildWith(sucess);
	}
	
	@ResponseStatus(code = OK)
	@RequestMapping(method = GET, path = "/{id}/book-collection")
	public @ResponseBody FilledResponse<List<BookRespDTO>> getBookCollection(
			@ApiParam(value = "Client identifier", required = true) @PathVariable("id") Long id) {
		
		AmazingClient client = this.getClientBusiness().getClient(id);
		List<BookRespDTO> books = client.getBooks()
										.stream()
										.map(BookRespDTO::new)
										.collect(Collectors.toList());
		
		return ResponseBuilder.buildFilledWith(books);
	}
	
	@ResponseStatus(code = OK)
	@RequestMapping(method = GET, path = "/{id}/credits-transactions")
	public @ResponseBody FilledResponse<List<CreditTransactionRespDTO>> getCreditTransactions(
			@ApiParam(value = "Client identifier", required = true) @PathVariable("id") Long id) {
		
		List<CreditTransactionRespDTO> transactions = this.getClientBusiness()
															.getCreditTransactions(id)
															.stream()
															.map(CreditTransactionRespDTO::new)
															.collect(Collectors.toList());
		return ResponseBuilder.buildFilledWith(transactions);
	}
	
	@ResponseStatus(code = CREATED)
	@RequestMapping(method = POST, path = "/{id}/credits-transactions")
	public @ResponseBody FilledResponse<CreditTransactionRespDTO> buyCredit(
			@ApiParam(value = "Client identifier", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "Amount of money used to buy credit", required = true) @RequestParam BigDecimal money)
			throws InvalidMoneyValue {

		CreditTransaction transaction = this.getClientBusiness().buyCredit(id, money);
		Message message = this.createMessage(CREDITS_ADDED, transaction.getCredit());
		return ResponseBuilder.buildFilledWith(new CreditTransactionRespDTO(transaction), message);
	}
	
	@ResponseStatus(code = OK)
	@RequestMapping(method = PATCH, path = "/{id}/credits-transactions")
	public @ResponseBody Response cancelCreditTransaction(
			@ApiParam(value = "Client identifier", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "Credit transaction identifier to be cancelled", required = true) @RequestParam Long transactionId)
			throws InvalidCreditTransactionIdentifier {

		CreditTransaction transaction = this.getClientBusiness().cancelCreditTransaction(id, transactionId);
		Message message = this.createMessage(CREDITS_CANCELLED, transaction.getCredit());
		return ResponseBuilder.buildFilledWith(new CreditTransactionRespDTO(transaction), message);
	}
	
	protected AmazingClientBusiness getClientBusiness() {
		return clientBusiness;
	}

}