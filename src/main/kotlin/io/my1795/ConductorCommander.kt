package io.my1795

import picocli.CommandLine.Command
import picocli.CommandLine.Parameters

@Command(name = "config", mixinStandardHelpOptions = true)
class ConductorCommander : Runnable {

    @Parameters(paramLabel = "<name>", defaultValue = "picocli", description = ["Get Configuration"])
    var name: String? = null
    override fun run() {
        System.out.printf("TO-DO : print config here")
    }

}