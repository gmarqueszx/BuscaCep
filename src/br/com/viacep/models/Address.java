package br.com.viacep.models;

public record Address(String cep, String logradouro, String bairro, String localidade, String estado) {
}
