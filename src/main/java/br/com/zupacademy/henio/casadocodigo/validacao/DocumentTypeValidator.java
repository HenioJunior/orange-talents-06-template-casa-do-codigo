package br.com.zupacademy.henio.casadocodigo.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.henio.casadocodigo.controller.exceptions.FieldMessage;
import br.com.zupacademy.henio.casadocodigo.dto.request.ClienteRequest;
import br.com.zupacademy.henio.casadocodigo.modelo.enums.TipoCliente;
import br.com.zupacademy.henio.casadocodigo.validacao.utils.DocumentoBrasil;

public class DocumentTypeValidator implements ConstraintValidator<DocumentType, ClienteRequest> {

	@Override
	public void initialize(DocumentType params) {
	}

	@Override
	public boolean isValid(ClienteRequest value, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (value.getTipoDocumento().equals(TipoCliente.PESSOAFISICA.getCod())
				&& !DocumentoBrasil.isValidCPF(value.getDocumento())) {
			list.add(new FieldMessage("documento", "CPF inválido"));
		}
		if (value.getTipoDocumento().equals(TipoCliente.PESSOAJURIDICA.getCod())
				&& !DocumentoBrasil.isValidCNPJ(value.getDocumento())) {
			list.add(new FieldMessage("documento", "CNPJ inválido"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}