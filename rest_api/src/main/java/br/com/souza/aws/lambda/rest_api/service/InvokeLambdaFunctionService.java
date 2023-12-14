package br.com.souza.aws.lambda.rest_api.service;

import br.com.souza.aws.lambda.rest_api.properties.AwsProperties;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.InvokeRequest;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class InvokeLambdaFunctionService {

    private final AWSLambda awsLambda;
    private final AwsProperties awsProperties;

    public InvokeLambdaFunctionService(AWSLambda awsLambda,
                                       AwsProperties awsProperties) {
        this.awsLambda = awsLambda;
        this.awsProperties = awsProperties;
    }

    public void processarDados(LocalDate dataIni, LocalDate dataFim){
        InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName(awsProperties.getFunctionName())
                .withPayload("{\n" +
                        " \"dataIni\": \"" + dataIni.toString() + "\",\n" +
                        " \"dataFim\": \"" + dataFim.toString() + "\"" +
                        "}");

        try{
            awsLambda.invoke(invokeRequest);
            System.out.println("Lambda chamada com sucesso");
        }catch (Exception e){
            System.err.println("Erro ao chamar função lambda: " + e);
            throw e;
        }
    }
}
