package com.woohoo.apiHexagonal.core.domain.enums;

public enum TipoExcecao {
    BOLETO_INVALIDO {

        @Override
        public String getMessageError() {
            return "Boleto inválido";
        }
        
    },
    TIPO_BOLETO_INVALIDO {

        @Override
        public String getMessageError() {
            return "Tipo de boleto inválido ou inexistente";
        }

    },
    BOLETO_NAO_VENCIDO {

        @Override
        public String getMessageError() {
            return "Boleto dentro do prazo de vencimento.";
        }
        
    };

    public abstract String getMessageError();
}
