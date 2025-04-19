public class JogoDTO {
    private int idJogo;
    private String tituloDoJogo;
    private String plataformaDoJogo;
    private String generoJogo;
    private String dataLancamento;

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getTituloDoJogo() {
        return tituloDoJogo;
    }

    public void setTituloDoJogo(String tituloDoJogo) {
        this.tituloDoJogo = tituloDoJogo;
    }

    public String getPlataformaDoJogo() {
        return plataformaDoJogo;
    }

    public void setPlataformaDoJogo(String plataformaDoJogo) {
        this.plataformaDoJogo = plataformaDoJogo;
    }

    public String getGeneroJogo() {
        return generoJogo;
    }

    public void setGeneroJogo(String generoJogo) {
        this.generoJogo = generoJogo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}