package com.woohoo.apiHexagonal.core.domain.enums;

public enum TipoExcecao {
    BOLETO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "O boleto encontrado é inválido";
        }
    },

    TIPO_BOLETO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "Infelizmente só podemos calcular o juros dos boletos XPTO";
        }
    },

    BOLETO_NAO_VENCIDO {
        @Override
        public String getMensagemErro() {
            return "O boleto informado ainda não está vencido";
        }
    },
    CONTEUDO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "Conteudo inválido";
        }
    };

    public abstract String getMensagemErro();
}
