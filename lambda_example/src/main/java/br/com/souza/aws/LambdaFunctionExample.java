package br.com.souza.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.time.LocalDate;
import java.time.ZoneId;

public class LambdaFunctionExample implements RequestHandler<LambdaRequest, String> {

    @Override
    public String handleRequest(LambdaRequest request, Context context) {

        LocalDate dataIni = request.getDataIni() != null ? request.getDataIni() : LocalDate.now(ZoneId.of("Brazil/East"));
        LocalDate dataFim = request.getDataFim() != null ? request.getDataFim() : LocalDate.now(ZoneId.of("Brazil/East"));

        context.getLogger().log("Buscando dados na api externa nas datas " + dataIni + " e " + dataFim);
        context.getLogger().log("Mapeando dados...");
        context.getLogger().log("Iniciando inserção no banco...");
        context.getLogger().log("Inserção feita com sucesso...");
        context.getLogger().log("Fim do processamento");

        context.getLogger().log("Enviando notificação para usuário");

        return "Processamento entre as datas " + dataIni + " e " + dataFim + " finalizado com sucesso!";
    }

}
