package upe.ecomp.OlaSpring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import java.io.File


@SpringBootApplication
class OlaSpringApplication

@RestController
class GeradorPaginasHTML {
    var nAcessos = run {
        val texto = File("acessos.txt").readText()
        val valor = texto.toIntOrNull()
        if (valor==null)
           0
        else
           valor

    }

    @GetMapping("/Ola.html")
    fun ola() : String {
        println("Bom dia a todos")
        nAcessos++
        File("acessos.txt").writeText(nAcessos.toString())
        return """
        <html>
        <title>Texto dinamico</title>
        <body>
        Este arquivo html foi gerado dinamicamente pelo servidor
        <p>
        Esta página foi acessada ${nAcessos} vezes.
        </body>
        </html>
        """
    }

}


fun main(args: Array<String>) {
	runApplication<OlaSpringApplication>(*args)
}
