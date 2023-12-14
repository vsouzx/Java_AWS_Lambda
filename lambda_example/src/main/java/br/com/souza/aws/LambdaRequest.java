package br.com.souza.aws;

import java.time.LocalDate;

public class LambdaRequest {

    private LocalDate dataIni;
    private LocalDate dataFim;

    public LambdaRequest(){

    }

    public LocalDate getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDate dataIni) {
        this.dataIni = dataIni;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
