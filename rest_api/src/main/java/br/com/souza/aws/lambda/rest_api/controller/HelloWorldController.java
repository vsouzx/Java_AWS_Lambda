package br.com.souza.aws.lambda.rest_api.controller;

import br.com.souza.aws.lambda.rest_api.service.InvokeLambdaFunctionService;
import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/process")
public class HelloWorldController {

    private final InvokeLambdaFunctionService invokeLambdaFunctionService;

    public HelloWorldController(InvokeLambdaFunctionService invokeLambdaFunctionService) {
        this.invokeLambdaFunctionService = invokeLambdaFunctionService;
    }

    @GetMapping(value = "/{dataIni}/{dataFim}")
    public ResponseEntity<String> processarDados(@PathVariable("dataIni") LocalDate dataIni,
                                                 @PathVariable("dataFim") LocalDate dataFim){
        invokeLambdaFunctionService.processarDados(dataIni, dataFim);
        return new ResponseEntity<>("Processamento iniciado", HttpStatus.OK);
    }
}
