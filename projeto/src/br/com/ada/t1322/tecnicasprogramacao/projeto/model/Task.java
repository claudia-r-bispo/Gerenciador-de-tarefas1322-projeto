package br.com.ada.t1322.tecnicasprogramacao.projeto.model;

public class Task {

    public enum Status {
        PENDENTE("Pendente"),
        EM_ANDAMENTO("Em andamento"),
        CONCLUIDO("Concluído");

        private final String descricao;

        Status(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
