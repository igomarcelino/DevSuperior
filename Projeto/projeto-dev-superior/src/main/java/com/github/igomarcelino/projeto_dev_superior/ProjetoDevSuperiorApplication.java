package com.github.igomarcelino.projeto_dev_superior;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * Corrige o problema de cors, aqui ele aponta para o servidor em que o swagger estara rodando,
 * baseado em sua url raiz. Ele acontece esse erro pois o railway sobe em https e o swagger sobe em http.
 * */
@OpenAPIDefinition(servers = {@Server(url = "/",description = "default Server URL")},info = @Info(title = "DSlist-intensivao-Java-Spring", version = "1", description = "Api desenvolvida na semana intensivao Java Spring"))
public class ProjetoDevSuperiorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDevSuperiorApplication.class, args);
	}

}
